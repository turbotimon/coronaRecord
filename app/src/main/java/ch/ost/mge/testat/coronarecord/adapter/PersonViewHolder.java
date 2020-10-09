package ch.ost.mge.testat.coronarecord.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;

import ch.ost.mge.testat.coronarecord.R;

public class PersonViewHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public TextView contactInfo;
    public MaterialCheckBox checkbox;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.rowitem_person_select_lbl_name);
        contactInfo = itemView.findViewById(R.id.rowitem_person_select_lbl_contactinfo);
        checkbox = itemView.findViewById(R.id.rowitem_person_select_cb_selected);

    }
}
