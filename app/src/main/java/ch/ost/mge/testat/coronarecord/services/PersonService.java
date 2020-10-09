package ch.ost.mge.testat.coronarecord.services;

import java.util.ArrayList;

import ch.ost.mge.testat.coronarecord.model.Person;

public class PersonService {

    private static PersonService personService = new PersonService(); //TODO Timon: check if needed??? (merge conflict, not sure if needed or not)

    ArrayList<Person> personArrayList = new ArrayList<>();

    public PersonService() {
        personArrayList.add(new Person("Max", "Muster", "079 891 27 63", "max@muster.ch"));
        personArrayList.add(new Person("Tom", "Hunter", "079 212 32 21", "tom@gmail.com"));
        personArrayList.add(new Person("Mia", "Hustler", "079 234 12 42", "mia.hustler@gmx.to"));
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void onAdd(Object object) {
        Person person = (Person) object;
        // TODO: persist add
    }

    public void onRemove(Object object) {
        Person person = (Person) object;
        // TODO: persist remove
    }
}
