package pl.sda.people;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private String country;

    public Person(String firstName, String lastName, int yearOfBirth, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.country = country;
    }


    @Override
    public String toString() {
        return "Person: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", country='" + country + '\'';
    }
}
