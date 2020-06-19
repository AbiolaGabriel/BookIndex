import java.util.*;
import java.io.*;
/**
 * Write a description of class Demo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demo{
    String file;
    Dictionary d;
    public Demo(String file){
        this.file = file;
        this.d = new Dictionary();
    }

    public long readBook(Index a){
        Scanner s1 = null;
        Scanner s2 = null;
        String line = "";
        int lineNum = 0;
        long startTime = System.currentTimeMillis();
        try{
            s1 = new Scanner(new FileReader(this.file));
            while(s1.hasNextLine()){
                line = s1.nextLine();
                lineNum++;
                String [] words = line.split("[^A-Za-z]+");
                for(int i = 0; i<words.length; i++){
                    String word = words[i].toLowerCase();
                    if(d.dictWord(word) == true){
                        a.newEntry(word, lineNum);
                    }
                }
            }
        }
        catch(Exception e){
            System.err.println(e);
            System.out.println("Error in Demo");
        }
        long endTime = System.currentTimeMillis(); 
        return (endTime - startTime);
    }

    public static void main(String [] args){
        Demo d = new Demo("Shakespeare.txt");
        Demo e = new Demo("DoI.txt");
        Demo f = new Demo("Twist.txt");

        HashIndex a = new HashIndex();
        System.out.println(d.readBook(a));
        System.out.println(a.totalEntries+" "+a.toText("Shakespeare1"));
        a = new HashIndex();
        System.out.println(e.readBook(a));
        System.out.println(a.totalEntries+" "+a.toText("DoI1"));
        a = new HashIndex();
        System.out.println(f.readBook(a));
        System.out.println(a.totalEntries+" "+a.toText("Twist1"));

        TreeIndex b = new TreeIndex();
        System.out.println(d.readBook(b));
        System.out.println(b.totalEntries+" "+b.toText("Shakespeare2"));
        b = new TreeIndex();
        System.out.println(e.readBook(b));
        System.out.println(b.totalEntries+" "+b.toText("DOI2"));
        b = new TreeIndex();
        System.out.println(f.readBook(b));
        System.out.println(b.totalEntries+" "+b.toText("Twist2"));

        ListIndex c = new ListIndex();
        System.out.println(d.readBook(c));
        c.sort();
        System.out.println(c.totalEntries+" "+c.toText("Shakespeare3"));
        c = new ListIndex();
        System.out.println(e.readBook(c));
        c.sort();
        System.out.println(c.toText("DOI3"));
        c = new ListIndex();
        System.out.println(f.readBook(c));
        c.sort();
        System.out.println(c.totalEntries+" "+c.toText("Twist3"));
    }

}
