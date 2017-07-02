package Core; /**
 * Create Core.User Assignment; Core.Person Class
 * Attributes include: first name, last name, SSN, dob, gender
 */

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;

    public Person() {
        this.firstName = "Matt";
        this.lastName = "Wilchek";
        this.dob = "10/16/1989";
        this.gender = "male";
    }

    public Person(String firstName, String lastName, String dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    /**
     * Get First Name of Person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set First Name of Person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get Last Name of Person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Last Name of Person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get DOB of Person
     */
    public String getDob() {
        return dob;
    }

    /**
     * Set DOB of Person
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Get Gender of Person
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set Gender of Person
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}

