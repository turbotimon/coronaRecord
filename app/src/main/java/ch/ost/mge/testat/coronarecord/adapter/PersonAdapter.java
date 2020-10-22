package ch.ost.mge.testat.coronarecord.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.model.PersonList;
import ch.ost.mge.testat.coronarecord.services.PersonService;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> implements Observer {
    Context context;
    LayoutInflater inflater;
    PersonList personList;

    public PersonAdapter(Context context, PersonList personList) {
        this.context = context;
        this.personList = personList;
        inflater = LayoutInflater.from(context);
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
        Person person = personList.get(position);
        holder.name.setText(person.getName());
        holder.contactInfo.setText(person.getContactInfo());
        holder.checkbox.setChecked(person.getSelected());
        holder.checkbox.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            person.setSelected(isChecked);
            personList.update(person);
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public void update(Observable o, Object arg) {
        notifyDataSetChanged();
    }
}