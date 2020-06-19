import java.util.*;
import java.io.*;
/**
 * Write a description of interface Index here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Index{
    void newEntry(String word, int line);
    void addLine(String word, int line);
    long toText(String name);
}
