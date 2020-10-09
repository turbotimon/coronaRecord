package ch.ost.mge.testat.coronarecord.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.services.PersonService;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    Context context;
    PersonService personService;
    ArrayList<Person> personArrayList;
    LayoutInflater inflater;

    public PersonAdapter(Context context, PersonService personService) {
        this.context = context;
        this.personService = personService;
        this.personArrayList = personService.getPersonArrayList();
        inflater = LayoutInflater.from(context);
    }

    public void add(Person person){
        person.setSelected(true);
        personService.onAdd(person);
        personArrayList.add(person);
        notifyItemInserted(personArrayList.size());
    }

    public void remove(Person person) {
        int position = personArrayList.indexOf(person);
        personService.onRemove(person);
        personArrayList.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_item_person_select,parent,false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.name.setText(person.getName());
        holder.contactInfo.setText(person.getContactInfo());
        holder.checkbox.setChecked(person.getSelected());
        holder.checkbox.setOnClickListener(v -> {
            person.setSelected(v.isSelected());
        });
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }
}