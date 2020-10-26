package ch.ost.mge.testat.coronarecord.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}
