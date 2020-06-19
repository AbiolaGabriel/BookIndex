import java.util.*;
import java.io.*;
/**
 * Write a description of class Dictionary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dictionary{
    private ArrayList<String>dict;
    int totalWords;
    public Dictionary(){
        this.dict = new ArrayList<String>();
        this.totalWords = 0;
        addWords("English.txt");
    }
    

    public void addWords(String file){
        Scanner s1 = null;
        Scanner s2 = null;
        String line = "";
        try{
            s1 = new Scanner(new FileReader(file));
            int count = 1;
            while(s1.hasNextLine()){
                String alphaLetter = "";
                if(count == 1){
                    line = s1.nextLine();
                    s2 = new Scanner(line);
                    while(s2.hasNextInt()){
                        this.totalWords = s2.nextInt();
                    }
                }
                else{
                    line = s1.nextLine();
                    this.dict.add(line);
                }
                count++;
            }
        }
        catch(Exception e){
            System.err.println(e);
            System.out.println("Error in dic");
        }
    }
    
    public boolean dictWord(String word){
        int pos = Collections.binarySearch(this.dict, word);
        return pos>-1;
    }
}
