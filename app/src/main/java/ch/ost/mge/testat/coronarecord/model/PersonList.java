package ch.ost.mge.testat.coronarecord.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.stream.Collectors;

import ch.ost.mge.testat.coronarecord.services.PersonService;

public class PersonList extends Observable {
    private ArrayList<Person> personArrayList = new ArrayList<>();
    private PersonService personService;

    public PersonList(PersonService personService) {
        this.personService = personService;
    }

    public void loadListFromService() {
        this.personArrayList = personService.loadPersonEntries();
    }

    public void remove(Person person) {
        personArrayList.remove(person);
        setChanged();
        personService.remove(person, this::notifyObservers);
    }

    public void update(Person person) {
        personArrayList.set(personArrayList.indexOf(person),person);
        setChanged();
        personService.update(person, this::notifyObservers);
    }

    public void add(Person person) {
        personArrayList.add(person);
        setChanged();
        personService.add(person,  this::notifyObservers);
    }

    public Person get(int position){
        return personArrayList.get(position);
    }

    public int size(){
        return personArrayList.size();
    }

    public ArrayList<Person> getSelected() {
        ArrayList<Person> resPersonArrayList = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            resPersonArrayList = (ArrayList<Person>) personArrayList.stream().filter(Person::getSelected).collect(Collectors.toList());
        } else {
            for (Person person : personArrayList) {
                if(person.getSelected()){
                    resPersonArrayList.add(person);
                }
            }
        }

        return resPersonArrayList;
    }
}
