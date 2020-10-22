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
        notifyObservers();
    }

    public void remove(Person person) {
        personArrayList.remove(person);
        personService.remove(person);
        notifyObservers(person);
    }

    public void update(Person person) {
        personService.update(person);
        notifyObservers(person);
    }

    public void add(Person person) {
        personArrayList.add(person);
        personService.add(person);
        notifyObservers(person);
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
