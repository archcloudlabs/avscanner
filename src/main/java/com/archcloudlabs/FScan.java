package com.archcloudlabs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FScan {

    private long size = -1;
    private String fName;
    private String fPath;
    private String data;

    // getter for private size variable
    public long getSize() {
        return size;
    }

    // setter for private size variable
    public void setSize(long l) {
        this.size = l;
    }

    // get the file name of this object
    public String getfName() {
        return fName;
    }

    // Set the file name of an object
    public void setfName(String string) {
        this.fName = string;
    }

    // get the file path of an object
    public String getfPath() {
        return fPath;
    }

    // set the file path of an object
    public void setfPath(String fPath) {
        this.fPath = fPath;
    }

    // Get the data from the object
    public String getData() {
        return this.data;
    }


    public void ReadData(File fname) {

        try {
            FileReader freader = new FileReader(fname.getAbsoluteFile());

            try {
                BufferedReader bufreader = new BufferedReader(freader);
                this.data = bufreader.readLine();

                // Close to prevent memory leaks
                bufreader.close();
                freader.close();

            } catch (IOException e) {
                    System.out.println("Woops! Cannot read file: " + fname.getName());
                    System.exit(1);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Woops! File " + fname.getName() + " not found!");
            System.exit(1);
        }
    }

    public void info(FScan fscanObj)  {

        System.out.printf("File name is: %s\nSize is: %d\nData is: %s\n",
            fscanObj.fName,
            fscanObj.size,
            fscanObj.data);
    }
   
    public void ReadData2(File fname) throws IOException {
        FileReader freader = new FileReader(fname.getAbsoluteFile());
        BufferedReader bufreader = new BufferedReader(freader);
        this.data = bufreader.readLine();
        System.out.println(this.data);
        bufreader.close();
        freader.close();
    }


}
