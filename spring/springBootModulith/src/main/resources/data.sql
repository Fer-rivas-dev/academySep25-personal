-- Fix Spring Modulith event_publication table schema
-- This runs after Hibernate creates the tables and extends the serialized_event column

-- Alter the event_publication table to use larger column for serialized_event
ALTER TABLE event_publication ALTER COLUMN serialized_event SET DATA TYPE TEXT;

-- Alter the event_publication_archive table to use larger column for serialized_event
ALTER TABLE event_publication_archive ALTER COLUMN serialized_event SET DATA TYPE TEXT;