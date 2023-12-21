package test;

import java.util.Random;

public class Employee {
	    // Constants
	    private static final int WAGE_PER_HOUR = 20;
	    private static final int FULL_DAY_HOURS = 8;
	    private static final int PART_TIME_HOURS = 4;
	    private static final int WORKING_DAYS_PER_MONTH = 20;
	    private static final int MAX_WORKING_HOURS = 100;

	    // Instance variables
	    private int totalWage;
	    private int totalWorkingHours;
	    private int totalWorkingDays;

	    public int checkAttendance() {
	        // Generate a random number between 0 and 1 (0: Absent, 1: Present)
	        Random random = new Random();
	        return random.nextInt(2);
	    }

	    public int calculateDailyWage(int attendance) {
	        if (attendance == 1) {
	            return WAGE_PER_HOUR * FULL_DAY_HOURS;
	        } else {
	            return 0;
	        }
	    }

	    public int calculatePartTimeWage(int attendance) {
	        if (attendance == 1) {
	            return WAGE_PER_HOUR * PART_TIME_HOURS;
	        } else {
	            return 0;
	        }
	    }
	    public void calculateWagesForMonth() {
	        while (totalWorkingDays < WORKING_DAYS_PER_MONTH && totalWorkingHours < MAX_WORKING_HOURS) {
	            int attendance = checkAttendance();
	            int dailyWage = calculateDailyWage(attendance);

	            totalWage += dailyWage;
	            totalWorkingHours += FULL_DAY_HOURS;
	            totalWorkingDays++;
	        }

	        System.out.println("Total Employee Wage for the Month: $" + totalWage);
	    }
	}

	
