package ch.ost.mge.testat.coronarecord.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo
    public String firstName;
    @ColumnInfo
    public String lastName;
    @ColumnInfo
    public String phone;
    @ColumnInfo
    public String email;
    @ColumnInfo
    public Boolean selected;
}
