package ch.ost.mge.testat.coronarecord.services;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import java.util.ArrayList;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.adapter.PersonAdapter;
import ch.ost.mge.testat.coronarecord.database.PersonDao;
import ch.ost.mge.testat.coronarecord.database.PersonDatabase;
import ch.ost.mge.testat.coronarecord.model.Person;

public class PersonService {
    ArrayList<Person> personArrayList = new ArrayList<>();
    PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
        loadPersonEntries();
    }

    private void loadPersonEntries(){
        for(ch.ost.mge.testat.coronarecord.database.Person person : personDao.getEntries()){
            personArrayList.add(new Person(person));
        }
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void onAdd(Object object) {
        Person person = (Person) object;
        Runnable write = () -> {
            personDao.insert(person.getPersonForDao());
        };

        new Thread(write).start();
    }

    public void onUpdate(Object object) {
        Person person = (Person) object;
        Runnable write = () -> {
            personDao.update(person.getPersonForDao());
        };

        new Thread(write).start();
    }

    public void onRemove(Object object) {
        Person person = (Person) object;
        Runnable write = () -> {
            personDao.delete(person.getPersonForDao());
        };

        new Thread(write).start();
    }
}
