package ch.ost.mge.testat.coronarecord.services;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;

import ch.ost.mge.testat.coronarecord.database.PersonDao;
import ch.ost.mge.testat.coronarecord.database.PersonDatabase;
import ch.ost.mge.testat.coronarecord.model.Person;

public class PersonService {
    public interface Callback {
        void run();
    }

    PersonDatabase db;
    PersonDao personDao;

    public PersonService(Context context) {
        db = Room.databaseBuilder(context, PersonDatabase.class, "room.db").build();
        personDao = db.personDao();
    }

    public ArrayList<Person> loadPersonEntries(){
        ArrayList<Person> personArrayList = new ArrayList<>();
        for(ch.ost.mge.testat.coronarecord.database.Person person : personDao.getEntries()){
            personArrayList.add(new Person(person));
        }
        return personArrayList;
    }

    public void add(Person person, Callback callback) {
        Runnable write = () -> {
            ch.ost.mge.testat.coronarecord.database.Person personDb = person.getPersonForDao();
            personDao.insert(personDb);
            person.setId(personDb.id);
            callback.run();
        };

        new Thread(write).start();
    }

    public void update(Person person, Callback callback) {
        Runnable write = () -> {
            personDao.update(person.getPersonForDao());
            callback.run();
        };

        new Thread(write).start();
    }

    public void remove(Person person, Callback callback) {
        Runnable write = () -> {
            personDao.delete(person.getPersonForDao());
            callback.run();
        };

        new Thread(write).start();
    }
}
