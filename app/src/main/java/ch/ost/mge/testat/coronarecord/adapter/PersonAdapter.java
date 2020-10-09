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

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    Context context;
    ArrayList<Person> personArrayList;
    LayoutInflater inflater;

    public PersonAdapter(Context context, ArrayList<Person> personArrayList) {
        this.context = context;
        this.personArrayList = personArrayList;
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
        Person person = personArrayList.get(position);
        holder.name.setText(person.getName());
        holder.contactInfo.setText(person.getContactInfo());
        holder.checkbox.setActivated(person.getSelected());
        holder.checkbox.setOnClickListener(v -> {
            person.setSelected(v.isSelected());
        });
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }
}