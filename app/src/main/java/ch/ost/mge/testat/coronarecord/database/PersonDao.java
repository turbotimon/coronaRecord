package ch.ost.mge.testat.coronarecord.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    List<Person> getEntries();

    @Insert
    void insert(Person person);

    @Update
    void update(Person person);

    @Delete
    void delete(Person person);
}
