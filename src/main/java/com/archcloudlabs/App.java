package com.archcloudlabs;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )  throws IOException{

        // 2d array for our "malicous signatues" and then an empty string
        // the empty string will be updated with content later on.
        String[][] signatures = {
            {"evil bytes", ""},
            {"water", ""},
            {"coffee", ""},
            {"bose headphones", ""}
        };

        Scanner sc = new Scanner(System.in); //scanner for stdin!
        System.out.println("Enter file path to scan: ");

        String fname = sc.next(); // scanner.next just returns a string. 
        File fpath = new File(fname);

        FScan filescanner = new FScan(); // new File scanner object, look at FScan.javav0

        filescanner.ReadData2(fpath); // Lets read in some data
        filescanner.setSize(fpath.length()); // lets set the size of our obj
        filescanner.setfName(fpath.getName()); // lets get the pathname

        FileWriter fw = new FileWriter("report.txt");
        PrintWriter pw = new PrintWriter(fw);

        for (int i = 0; i < signatures.length; i++) {
            if (filescanner.getData().equalsIgnoreCase(signatures[i][i])) {

                System.out.println("WARNING FOUND MALICOUS FILE: " + filescanner.getfName());
                signatures[i][i] = filescanner.getfName(); // assign the a file name to the "signature" that was matched.
                pw.write("Malicious file is" + filescanner.getfName());
                pw.flush();
                System.exit(1);
            }
        }

        String msg = "No malicous files found!";
        System.out.println(msg);
        fw.write(msg);

        fw.close();
        sc.close();
    }
}