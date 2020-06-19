import java.util.*;
import java.io.*;
/**
 * Write a description of class ListIndex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListIndex implements Index{
    ArrayList<Entry> index;
    int totalEntries;
    public ListIndex(){
        this.index = new ArrayList<Entry>();
        this.totalEntries = 0;
    }

    public void newEntry(String word, int line){
        if(isHere(word) == false){
            this.index.add(new Entry(word, line));
        }
        else if(isHere(word) == true){
            addLine(word, line);
        }
        this.totalEntries++;
    }

    public Entry getEntry(String word){
        for(Entry e: this.index){
            if(e.word.equals(word)){
                return e;
            }
        }
        return null;
    }

    public ArrayList<Integer> getLine(String word){
        ArrayList<Integer> numList = null;
        if(isHere(word) == true){
            Entry temp = getEntry(word);
            numList = new ArrayList<Integer>();
            Iterator<Integer> ite = temp.lineList.iterator();
            while(ite.hasNext()){
                numList.add(ite.next());
            }
            return numList;
        }
        return numList;
    }

    public boolean isHere(String word){
        return this.index.contains(getEntry(word));
    }

    public void addLine(String word, int line){
        Entry temp = null;
        if(isHere(word) == true){
            getEntry(word).add(line);
        }
    }

    public long toText(String name){
        long startTime = System.currentTimeMillis();
        try{
            PrintWriter results = new PrintWriter(name);
            for(Entry e: this.index){
                results.println(e.word+" "+e.lineList);
            }
            results.close();
        }
        catch(Exception e){
            System.err.println(e + " "+"Could not be printed");
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
    
    public void sort(){
        Collections.sort(index, new Sorter());
    }

    public class Entry{
        String word;
        Integer line;
        TreeSet<Integer> lineList;
        public Entry(String word, int line){
            this.word = word;
            this.line = new Integer(line);
            this.lineList = new TreeSet<Integer>();
            this.lineList.add(this.line);
        }

        public void add(int line){
            Integer x = new Integer(line);
            this.lineList.add(x);
        }
    }
    
    public class Sorter implements Comparator<Entry>{
        @Override
        public int compare(Entry a, Entry b){
            return (int) (a.word.compareTo(b.word));
        }
    }

}
