package pl.sda.people;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[3];
        people[0] = new PolishPerson("Jan","Kowalski", "1034567890");
        people[1] = new PolishPerson("Zbyszek","Nowak", "9911654321");
        people[2] = new AlienPerson("Gung","Bao", 1985, "China");


        for (Person person :people) {
            System.out.println(person);
        }


    }
}
