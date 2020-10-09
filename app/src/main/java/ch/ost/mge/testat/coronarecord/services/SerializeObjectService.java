package ch.ost.mge.testat.coronarecord.services;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeObjectService {

    private String filename;
    private Context context;
    private Object object;

    SerializeObjectService(Context context, String filename, Object object) {

    }

//    public void save() {
//        FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
//        ObjectOutputStream os = new ObjectOutputStream(fos);
//        os.writeObject(this);
//        os.close();
//        fos.close();
//    }
//
//    public String load() {
//        FileInputStream fis = context.openFileInput(filename);
//        ObjectInputStream is = new ObjectInputStream(fis);
//        SimpleClass simpleClass = (SimpleClass) is.readObject();
//        is.close();
//        fis.close();
//    }

}
