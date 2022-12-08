import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class History {
    String fileName;

    public void showHistory(int id) {
        this.fileName = id+".txt";
        try {
            File file = new File(fileName);
            file.createNewFile();
            Stream<String> lines = Files.lines(Paths.get(fileName));
            lines.forEach(ele -> {
                System.out.println(ele);
            });
        }catch (IOException io){
            io.printStackTrace();
        }

    }
    public void showChat(int id) {
        this.fileName = id+".txt";
        try {
            File file = new File(fileName);
            file.createNewFile();
            int count = 0;
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            FileReader in = new FileReader(fileName);
            LineNumberReader reader = new LineNumberReader(in);
            if(count<=5)
            {
                Stream<String> lines = Files.lines(Paths.get(fileName));
                lines.forEach(ele -> {
                    System.out.println(ele);
                });
            }
            else
            {
                int line = count;
                while (line>0) {
                    line--;
                    String s = reader.readLine();
                    if(line<=5)
                    {
                        System.out.println(s);
                    }
                }
            }
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    public void updateHistory(int id, String mes) {
        this.fileName = id+".txt";
        try {
            FileWriter fw = null;
            File f = new File(fileName);
            fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(mes);
            pw.flush();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
