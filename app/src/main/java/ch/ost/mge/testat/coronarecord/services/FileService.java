package ch.ost.mge.testat.coronarecord.services;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileService {

    private String filename;
    private Context context;

    public FileService(Context context, String filename){
        this.filename=filename;
        this.context=context;
    }

    public void write(int b){
        try{ //TODO sauber machen
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(b);
            fos.close();
        } catch (Exception e) {

        }
    }

    public int read(){
        try { // TODO sauber machen
            FileInputStream fis = context.openFileInput(filename);
            int b = fis.read();
            fis.close();
            return b;
        } catch (Exception e){
            return 0;
        }
    }

}
