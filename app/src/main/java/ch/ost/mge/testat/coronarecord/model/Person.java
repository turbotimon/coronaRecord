package ch.ost.mge.testat.coronarecord.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    static long ID = 0;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Boolean selected = false;
    private final long unique_ID;

    public Person(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.unique_ID = ++ID;
    }

    public Person(){
        this.unique_ID = ++ID;
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

    public long getUnique_ID() {
        return unique_ID;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
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
}