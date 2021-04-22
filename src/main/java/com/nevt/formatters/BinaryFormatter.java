package com.nevt.formatters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.nevt.common.Envelope;
import com.nevt.common.Formatter;

/**
 *
 */
public class BinaryFormatter implements Formatter {

    /**
     * Default constructor
     */
    public BinaryFormatter() {
    }

    /**
     * @param data
     * @return
     */
    public byte[] format(Envelope data) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("envelope.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                oos.flush();
                oos.close();
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * @param bytes
     * @return
     */
    public Envelope parse(byte[] bytes) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Envelope en = null;
        try {
            fis = new FileInputStream("envelope.dat");
            ois = new ObjectInputStream(fis);
            en = (Envelope) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(ois!=null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


        return null;
    }

}