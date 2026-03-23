package oop.labor04.Lab4_1;

public class Person {

    private String lastName;
    private String firstName;
    private int birthYear;


    public Person(String lastName, String firstName, int birthYear) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.birthYear = birthYear;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

}
