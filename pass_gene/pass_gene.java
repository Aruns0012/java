//        ----------------------this code will generate the random password of given length---------------------
//        ----------------------also this will be able to write the password in a txt documents-----------------
import java.io.*;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
class generator {
//    declaring the return type of below function like char[] is mandatory
    public char[] gene (int len) {
        String capitalChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChar = "abcedfghijklmnopqrstuvwxyz";
        String numberChar = "1234567890";
        String specialChar = "!@#$";
        String combinedChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcedfghijklmnopqrstuvwxyz1234567890!@#$";
        Random rand = new Random();
        char [] password = new char[len];
        password[0] = capitalChar.charAt(rand.nextInt(capitalChar.length()));
        password[1] = smallChar.charAt(rand.nextInt(smallChar.length()));
        password[2] = numberChar.charAt(rand.nextInt(numberChar.length()));
        password[3] = specialChar.charAt(rand.nextInt(specialChar.length()));
        for (int i = 4; i<len; i++) {
            password[i] = combinedChar.charAt(rand.nextInt(combinedChar.length()));
        }
        return password;
    }
//    this method creates the file if not present
    public static void file_handler() {
//        the block below creates a file with the given name and it works only if the file don't exists
        try {
            File myFile = new File("pass_gene.txt");
            if(!myFile.exists()) {
                if (myFile.createNewFile()){
                    System.out.println("file created successfully");
                } else {
                    System.out.println("file creation failed!!");
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    this method writes the data in created file
    public static void file_writer(String place, char[] password) {
        String pa = String.valueOf(password);
        try {
            FileWriter writer = new FileWriter("pass_gene.txt",true);
            try {
                writer.write("\n"+place+"  ------  "+" " + pa);
                writer.close();
            } catch (IOException e) {
                System.out.println("!! SOME ERROR OCCURRED IN PROCESS !!");
            }
        } catch (IOException e) {
            System.out.println("!! SOME ERROR OCCURRED IN PROCESS !!");
        }
    }
//    this method shows the password to the user
    public static void pass_viewer(){
        String masterPass = "********";
        File file = new File("pass_gene.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your master password");
        String userpass = sc.next();
        if(userpass.equals(masterPass)) {
            try {
                Scanner frsc = new Scanner(file);
                while (frsc.hasNextLine())
                System.out.println(frsc.nextLine());
            } catch (IOException e) {
                System.out.println("SOME ERROR OCCURED WHILE READING FILE");
            }
        } else {
            System.out.println("YOU ENTERED WRONG PASSWORD");
        }
    }
}
public class pass_gene {
    public static void main(String[] args) throws IOException {

//        what do you want to do generate or see saved passwords enter g or v(view)
        while (true) {
            System.out.println("WHAT DO YOU WANT TO DO NOW GENERATE A NEW PASSWORD OR VIEW SAVED PASSWORD(enter g to generate and v to view password)");
            Scanner sc = new Scanner(System.in);
            String operation = sc.next();
            if (operation.equalsIgnoreCase("g")) {
    //        Scanner sc = new Scanner(System.in);
                generator pass = new generator();
                System.out.println("FOR WHERE YOU WANT TO GENERATE PASSWORD");      // asking for location of password
                String place = sc.next();
                System.out.println("ENTER THE LENGTH OF PASSWORD");       // asking for length of password
                int passLen = sc.nextInt();
                if(passLen <= 4) {
                    System.out.println("LENGTH TOO SHORT!!");
                    passLen = sc.nextInt();
                }
                char[] yourPass = pass.gene(passLen);       // password stored in yourPass
                String password = String.valueOf(yourPass);
                generator.file_handler();
                generator.file_writer(place,yourPass);
                System.out.println("YOUR PASSWORD IS  ---> " + password);
                System.out.println("YOUR PASSWORD IS STORED SECURELY");
            } else if (operation.equalsIgnoreCase("v")) {       // code to view password
                generator.pass_viewer();
            }
                System.out.println("DO YOU WANT TO EXIT (ENTER Y TO EXIT)");
                String step = sc.next();
                if(step.equalsIgnoreCase("y") || step.equalsIgnoreCase("e")) {
                    break;
                }
//                 the data should be added to in xl file and not in the txt file so that the data can be fetched easily
        }
    }
}
