package File;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.text.FieldPosition;
import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        // try{
        //     OutputStream f = new FileOutputStream("hello.txt");
        //     byte bWrite[] = {65,66,67};

        //     for(int x = 0; x < bWrite.length; x++){
        //         f.write(bWrite[x]);
        //     }

        //     f.close();

        // } catch(Exception e){
        //     e.printStackTrace();
        // }

        try{
            FileWriter fw = new FileWriter("cry.txt");

            fw.write("I love Linh Dan so much!");

            fw.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        try{
            FileReader fr = new FileReader("cry.txt");
            int c;

            while((c = fr.read()) != -1){
                System.out.println(c);
            }
            

        } catch(Exception e){
            e.printStackTrace();
        }


    }
}
