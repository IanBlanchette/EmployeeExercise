
package jan25.pkg17;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author Ian
 */
public class Employee 
{
    private String firstName, lastName;
    private int socialInsurance;
    private LocalDate dateOfBirth;

public Employee(String first, String last, int sin, LocalDate dob)
{
    firstName = first;
    lastName = last;
    socialInsurance = sin;
    setBirthday(dob);
}

/**
* This method will return the employee's first and last name
*/
    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
    
    /**
     * This method will validate that the employee is 15-90 years old and set the dateOfBirth instance variables
     */
    public void setBirthday(LocalDate dob)
    {
        LocalDate today = LocalDate.now();
        int age = Period.between(dob,today).getYears();
        
        if (age >= 15 && age <= 90) //Valid employee dob
            this.dateOfBirth = dob;
        else 
            throw new IllegalArgumentException("The employee must be between 15-90 years old");
        
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSocialInsurance() {
        return socialInsurance;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
}