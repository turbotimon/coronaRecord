package ch.ost.mge.testat.coronarecord.model;

import androidx.annotation.Nullable;

import java.util.HashSet;

public class People extends HashSet<Person> {

    private HashSet<Person> people = new HashSet<>();

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean add(Person person) {
        return super.add(person);
    }

    @Override
    public boolean remove(@Nullable Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        super.clear();
    }
}
