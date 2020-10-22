package ch.ost.mge.testat.coronarecord.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Observable;
import java.util.Observer;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.activities.PersonActivity;
import ch.ost.mge.testat.coronarecord.interfaces.PersonEditIntent;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.model.PersonList;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> implements Observer {

    Context context;
    LayoutInflater inflater;
    PersonList personList;
    PersonEditIntent personEditIntent;

    public PersonAdapter(Context context, PersonEditIntent personEditIntent,PersonList personList) {
        this.context = context;
        this.personEditIntent = personEditIntent;
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
        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            person.setSelected(isChecked);
            personList.update(person);
        });
        holder.itemView.setOnClickListener(v -> personEditIntent.editPerson(person));
        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Delete " + person.getFirstName())
                    .setMessage("Do you really want to delete " + person.getFirstName() + "?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Yes", (dialog, whichButton) -> personList.remove(person))
                    .setNegativeButton("No", null).show();
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Person) {
            int position = personList.indexOf((Person) arg);
            ((Activity) context).runOnUiThread(() -> notifyItemChanged(position));
        } else if (arg instanceof Integer){
            ((Activity) context).runOnUiThread(() -> notifyItemRemoved((int) arg));
        } else {
            ((Activity)context).runOnUiThread(this::notifyDataSetChanged);
        }
    }
}