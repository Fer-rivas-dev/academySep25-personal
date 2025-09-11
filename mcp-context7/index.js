#!/usr/bin/env node

import { Server } from '@modelcontextprotocol/sdk/server/index.js';
import { StdioServerTransport } from '@modelcontextprotocol/sdk/server/stdio.js';
import {
  CallToolRequestSchema,
  ListToolsRequestSchema,
} from '@modelcontextprotocol/sdk/types.js';
import fetch from 'node-fetch';

class Context7Server {
  constructor() {
    this.server = new Server(
      {
        name: 'context7-server',
        version: '1.0.0',
      },
      {
        capabilities: {
          tools: {},
        },
      }
    );

    this.setupToolHandlers();
    
    // Error handling
    this.server.onerror = (error) => console.error('[MCP Error]', error);
    process.on('SIGINT', async () => {
      await this.server.close();
      process.exit(0);
    });
  }

  setupToolHandlers() {
    this.server.setRequestHandler(ListToolsRequestSchema, async () => ({
      tools: [
        {
          name: 'fetch_context7_page',
          description: 'Fetch content from a context7.com page',
          inputSchema: {
            type: 'object',
            properties: {
              path: {
                type: 'string',
                description: 'Path to fetch from context7.com (e.g., "/about", "/services")',
                default: '/'
              },
            },
          },
        },
        {
          name: 'search_context7',
          description: 'Search for content on context7.com',
          inputSchema: {
            type: 'object',
            properties: {
              query: {
                type: 'string',
                description: 'Search query',
              },
            },
            required: ['query'],
          },
        },
      ],
    }));

    this.server.setRequestHandler(CallToolRequestSchema, async (request) => {
      const { name, arguments: args } = request.params;

      try {
        if (name === 'fetch_context7_page') {
          const path = args.path || '/';
          const url = `https://context7.com${path}`;
          
          const response = await fetch(url);
          if (!response.ok) {
            throw new Error(`HTTP ${response.status}: ${response.statusText}`);
          }
          
          const content = await response.text();
          
          return {
            content: [
              {
                type: 'text',
                text: `Content from ${url}:\n\n${content}`,
              },
            ],
          };
        } else if (name === 'search_context7') {
          const query = args.query;
          const searchUrl = `https://context7.com/search?q=${encodeURIComponent(query)}`;
          
          const response = await fetch(searchUrl);
          if (!response.ok) {
            // If search endpoint doesn't exist, do a simple fetch of main page
            const mainResponse = await fetch('https://context7.com');
            const content = await mainResponse.text();
            
            return {
              content: [
                {
                  type: 'text',
                  text: `Search for "${query}" - showing main page content:\n\n${content}`,
                },
              ],
            };
          }
          
          const content = await response.text();
          
          return {
            content: [
              {
                type: 'text',
                text: `Search results for "${query}":\n\n${content}`,
              },
            ],
          };
        }
        
        throw new Error(`Unknown tool: ${name}`);
      } catch (error) {
        return {
          content: [
            {
              type: 'text',
              text: `Error: ${error.message}`,
            },
          ],
          isError: true,
        };
      }
    });
  }

  async run() {
    const transport = new StdioServerTransport();
    await this.server.connect(transport);
    console.error('Context7 MCP server running on stdio');
  }
}

const server = new Context7Server();
server.run().catch(console.error);