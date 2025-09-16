package com.luv2code.component.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ApplicationDao {

    public double addGradeResultsForSingleClass(List<Double> grades) {
    	System.out.println("****** NO IMPRIMIR ******");
        double result = 0;
        for (double i : grades) {
            result += i;
        }
        return result;
    }

    public double findGradePointAverage (List<Double> grades ) {
    	System.out.println("****** NO IMPRIMIR ******");
        int lengthOfGrades = grades.size();
        double sum = addGradeResultsForSingleClass(grades);
        double result = sum / lengthOfGrades;

        // add a round function
        BigDecimal resultRound = BigDecimal.valueOf(result);
        resultRound = resultRound.setScale(2, RoundingMode.HALF_UP);
        return resultRound.doubleValue();

    }

    public Object checkNull(Object obj) {
    	System.out.println("****** NO IMPRIMIR ******");
        if ( obj != null ) {
            return obj;
        }
        return null;
    }
}
