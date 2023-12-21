package test;

public class EmployeeWageComputation {
	
		    public static void main(String[] args) {
		        System.out.println("Welcome to Employee Wage Computation Program on Master Branch!");

		        // Create an instance of the Employee class
		        Employee employee = new Employee();

		        // UC 1: Check Employee is Present or Absent
		        int attendance = employee.checkAttendance();
		        System.out.println("Employee is " + (attendance == 1 ? "Present" : "Absent"));

		        // UC 2: Calculate Daily Employee Wage
		        int dailyWage = employee.calculateDailyWage(attendance);
		        System.out.println("Daily Employee Wage: $" + dailyWage);

		        // UC 3: Add Part-time Employee & Wage
		        int partTimeWage = employee.calculatePartTimeWage(attendance);
		        System.out.println("Part-time Employee Wage: $" + partTimeWage);

		        // UC 4 and UC 5: Calculate Wages for a Month and till a condition is reached
		        employee.calculateWagesForMonth();
		    }
		}

