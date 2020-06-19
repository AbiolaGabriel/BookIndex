import java.util.*;
import java.io.*;
/**
 * Write a description of class TreeIndex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TreeIndex implements Index{
    TreeMap<String, TreeSet<Integer>> index;
    int totalEntries;
    public TreeIndex(){
        this.index = new TreeMap<String, TreeSet<Integer>>();
        this.totalEntries = 0;
    }

    public void newEntry(String word, int line){
        Integer x = new Integer(line);
        if(isHere(word) == false){
            TreeSet<Integer> list = new TreeSet<Integer>();
            list.add(x);
            this.index.put(word, list);
        }
        else if(isHere(word) == true){
            addLine(word, line);
        }
        this.totalEntries++;
    }

    public boolean isHere(String word){
        return this.index.containsKey(word);
    }

    public void addLine(String word, int line){
        Integer x = new Integer(line);
        if(isHere(word) == true){
            this.index.get(word).add(line);
        }
    }

    public long toText(String name){
        long startTime = System.currentTimeMillis();
        try{
            PrintWriter results = new PrintWriter(name);
            for(Map.Entry<String, TreeSet<Integer>> entry: this.index.entrySet()){
                results.println(entry.getKey()+" "+entry.getValue());
            }
            results.close();
        }
        catch(Exception e){
            System.err.println(e + " "+"Could not be printed");
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
}
