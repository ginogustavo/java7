package app;

import java.io.DataOutputStream;
import java.io.FileInputStream;

public class Feature3_ResourceMgmt {

    /** Feature 3: Automatic Resource Management */
    public void autoClose() {

        // Before
        FileInputStream fos1 = null;
        DataOutputStream dos1 = null;
        try {
            fos1 = new FileInputStream("stocks.txt");
            dos1 = new DataOutputStream(null);
            dos1.writeUTF("testing writing files");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos1.close();
                dos1.close();
            } catch (Exception e) {
                // log exception
            }
        }

        // --- Since Java 7

        // try -> resource to be closed.
        // Resources are enclosed in the try statement one after another separated by ;
        // They are automatically closed, since behind classes inherit
        // java.lang.AutoCloseable interface

        try (FileInputStream fos = new FileInputStream("stocks.txt");
                DataOutputStream dos = new DataOutputStream(null)) {
            dos.writeUTF("Testing java 7 automatic resource management");
        } catch (Exception e) {
            // log exception
        }

    }

}