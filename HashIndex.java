import java.util.*;
import java.io.*;
/**
 * Write a description of class HashIndex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HashIndex implements Index{
    HashMap<String, TreeSet<Integer>> index;
    private TreeMap<String, TreeSet<Integer>> sorted = new TreeMap<String, TreeSet<Integer>>(); 
    int totalEntries;
    public HashIndex(){
        this.index = new HashMap<String, TreeSet<Integer>>();
        this.totalEntries = 0;
    }

    public void newEntry(String word, int line){
        Integer x = new Integer(line);
        if(index.containsKey(word) == false){
            TreeSet<Integer> list = new TreeSet<Integer>();
            list.add(x);
            this.index.put(word, list);
        }
        else if(index.containsKey(word) == true){
            addLine(word, line);
        }
        this.totalEntries++;
    }

    public ArrayList<Integer> getLine(String word){
        ArrayList<Integer> numList = null;
        if(index.containsKey(word) == true){
            TreeSet<Integer> list = this.index.get(word);
            numList = new ArrayList<Integer>();
            Iterator<Integer> ite = list.iterator();
            while(ite.hasNext()){
                numList.add(ite.next());
            }
            return numList;
        }
        return numList;
    }

    public void addLine(String word, int line){
        Integer x = new Integer(line);
        if(index.containsKey(word) == true){
            this.index.get(word).add(line);
        }
    }

    public long toText(String name){
        sorted.putAll(index);
        long startTime = System.currentTimeMillis();
        try{
            PrintWriter results = new PrintWriter(name);
            for(Map.Entry<String, TreeSet<Integer>> entry: this.sorted.entrySet()){
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
