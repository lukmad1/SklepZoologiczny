package pl.sda.people;

public class PolishPerson extends Person {
    private String pesel;

    public PolishPerson(String firstName, String lastName, String pesel) {
        super(firstName, lastName, peselToYearOfBirth(pesel), "PL");
        this.pesel = pesel;
    }

    private static int peselToYearOfBirth(String pesel) {

        int yearOfBirth = Integer.parseInt(pesel.substring(0, 2));
        int peselMonthOfBirth = Integer.parseInt(pesel.substring(2, 4));
        if (peselMonthOfBirth > 15) {
            yearOfBirth = 2000 + yearOfBirth;
        } else if (peselMonthOfBirth < 15) {
            yearOfBirth = 1900 + yearOfBirth;
        }
        return yearOfBirth;

    }


    @Override
    public String toString() {
        return super.toString() +
                ", pesel='" + pesel + '\'';
    }



}
