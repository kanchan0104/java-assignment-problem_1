import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.*;
import java.lang.*;

public class problem1
{
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());//sorting in descending order
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args)throws Exception
    {
        HashMap<String,Integer> words=new HashMap<String, Integer>();
        FileReader f = new FileReader("koutput.txt ");//in place of koutput enter the path of file
        Scanner file=new Scanner (f);
        while(file.hasNext()){
            String word=file.next();
            Integer count=words.get(word);
            if(count!=null)
                count++;
            else
                count=1;
            words.put(word,count);
        }
        file.close();
//        List<Integer> s = new ArrayList<>(words.values());
//        Collections.sort(s);
        Map<String, Integer> hm1 = sortByValue(words);
//        System.out.println(words);
        System.out.println("#output1");
        int i=0;
        //iterating loop for printing top three words
        for (Map.Entry<String,Integer> entry : hm1.entrySet() ) {
            System.out.println(entry.getKey() +
                    " - " + entry.getValue());
            i++;
            if(i==3)
                break;
        }
        System.out.println("#output2");
        //iterating loop for printing all the words and their occurrence
        for (Map.Entry<String,Integer> entry : hm1.entrySet() ) {
            System.out.println( entry.getKey() + " - " + entry.getValue());
        }

    }
}