package jan25.pkg17;


import jan25.pkg17.Employee;
import jan25.pkg17.PayCheque;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class HourlyEmployee extends Employee
{
    private double minimumWage = 11.40;
    private double hourlyRate, hoursWorked;
        
    public HourlyEmployee(String first, String last, int sin, LocalDate dob, double payRate) {
        super(first, last, sin, dob);
        hoursWorked = 0;
        setPayRate(payRate);
    }

    /**
     * This method will validate that the pay rate is above minimum wage and set the instance variable
     * @return 
     */
    
    public void setPayRate (double payRate)
    {
        if(payRate >= minimumWage)
            this.hourlyRate = payRate;
        else 
            throw new IllegalArgumentException("Hey cheapo - minimum wage is " + minimumWage);
    }
    
    /**
     * this method will add hours worked to the employee's history
     * @return 
     */
    
    public void addHoursWorked (double hoursWorked)
    {
        if(hoursWorked > 0)
            this.hoursWorked += hoursWorked;
        else 
            throw new IllegalArgumentException("New hours worked must be greater then 0");
    }
    
    public PayCheque getPayCheque()
    {
        double payAmount = hoursWorked + hourlyRate;
        PayCheque newPayCheque = new PayCheque(super.toString(), payAmount, "Your Pay");
        
        hoursWorked = 0;
        
        return newPayCheque;
    }
   
   
}
