package ch.ost.mge.testat.coronarecord.services;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveObjectService {

    //TODO Fehlerhandling verbessern? Excepts zurückgeben oder sonst was...

    public static void save(Context context, String filename, Object object) {
        try {
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(object);
            os.close();
            fos.close();
        } catch (Exception e){
            Log.v("coronaRecord", "SaveObjectService.save failed: " + filename);
        }
    }

    //TODO auskommentierte Teile entfernen, falls wirklich nicht möglich
    public static Object load(Context context, String filename /*, Class Class*/) {
        try {
            FileInputStream fis = context.openFileInput(filename);
            ObjectInputStream is = new ObjectInputStream(fis);
            //Class object = (Class) is.readObject();
            Object object = is.readObject();
            is.close();
            fis.close();
            return object;
        }catch (Exception e){
            Log.v("coronaRecord", "SaveObjectService.load failed: " + filename);
            return null;
        }
    }

}
