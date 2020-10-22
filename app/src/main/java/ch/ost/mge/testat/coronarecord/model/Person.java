package ch.ost.mge.testat.coronarecord.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    public static final String OBJECT_KEY = "PERSON_OBJ";

    private int id = 0;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Boolean selected = false;

    public Person(){};

    public Person(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Person(ch.ost.mge.testat.coronarecord.database.Person person) {
        id = person.id;
        firstName = person.firstName;
        lastName = person.lastName;
        email = person.email;
        phone = person.phone;
        selected = person.selected;
    }

    public String getName() {
        return firstName + ' ' + lastName;
    }

    public String getContactInfo() {
        return phone + " | " + email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                phone.equals(person.phone) &&
                email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phone, email);
    }

    public ch.ost.mge.testat.coronarecord.database.Person getPersonForDao(){
        ch.ost.mge.testat.coronarecord.database.Person person = new ch.ost.mge.testat.coronarecord.database.Person();

        person.id = id;
        person.firstName = firstName;
        person.lastName = lastName;
        person.email = email;
        person.phone = phone;
        person.selected = selected;

        return person;
    }
}