package ch.ost.mge.testat.coronarecord.services;

import java.util.ArrayList;

import ch.ost.mge.testat.coronarecord.database.PersonDao;
import ch.ost.mge.testat.coronarecord.model.Person;

public class PersonService {
    PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public ArrayList<Person> loadPersonEntries(){
        ArrayList<Person> personArrayList = new ArrayList<>();
        for(ch.ost.mge.testat.coronarecord.database.Person person : personDao.getEntries()){
            personArrayList.add(new Person(person));
        }
        return personArrayList;
    }

    public void add(Person person) {
        Runnable write = () -> {
            personDao.insert(person.getPersonForDao());
        };

        new Thread(write).start();
    }

    public void update(Person person) {
        Runnable write = () -> {
            personDao.update(person.getPersonForDao());
        };

        new Thread(write).start();
    }

    public void remove(Person person) {
        Runnable write = () -> {
            personDao.delete(person.getPersonForDao());
        };

        new Thread(write).start();
    }
}
