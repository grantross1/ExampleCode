/** Description of class
  *
  * @author		Grant Ross
  * @id			gross
  * @course		Programming II
  * @assignment		HashLab
  * @related		
  * @included		Advanced
  */
import java.io.*;   
import java.util.*;

public class Advanced { 

    protected final int LISTSIZE = 10000;  // default capacity
    protected Person[] personList = new Person[LISTSIZE];      
    //array to hold this list’s elements
    protected Person[] personListSearch = new Person[LISTSIZE];
    //array for the search
    ArraySortedList<Person> arrayList = new ArraySortedList(); 
    //Sorted List
    int index2;                            //2nd index for searching
    int searchOrder;                       //order of searching
    int compareCount;                      //number of seraches required 
       
    public void sortList() throws IOException {                //sort list()
        Scanner scanner = new Scanner(new File("people2.txt"));//what text file
        HashTable hash = new HashTable();  //initilize hash
        Merge merge = new Merge();         //initilize merge
        int index = 0;
            while(!scanner.hasNext()==false){ //while the .txt file has people
                Person person = new Person(scanner.next(),scanner.next(),
                scanner.nextInt()); //make the person by scanning 
                hash.add(person);   //add to hash
                personList[index] = person; //add into array
                index++;                    //move to next index
                if (!arrayList.contains(person))
                   arrayList.add(person);   //add to the sorted array
           }      
       scanner.close();                   //close scanner 
       Merge.initValues(personList);      //merge people array list
       Merge.mergeSort(0,(LISTSIZE-1));   //sort into merge
       hash.compare();                    //print hash compare
       merge.compare();                   //print merge compare, swaps
       arrayList.compare();
       //print sorted array compares, swaps, and number of elements
      
    }   
         
    public void searchList() throws IOException { //search
        Scanner scanner = new Scanner(new File("people2.txt"));
        //what text file to search
        arrayList.reset();
            while(!scanner.hasNext()==false){ 
                Person person = new Person(scanner.next(),scanner.next(),
                scanner.nextInt()); 
                personListSearch[index2] = person; 
                searchOrder = 0;  
                searchContains();          
                index2++;
            } 
        System.out.println("  "+compareCount + 
        " is the amount of compares it took to look up people from"+
        " one text file to the other.");      
    }
    
    public void searchContains(){          //counts the searches
        if (personListSearch[index2].idNum == personList[searchOrder].idNum){
            compareCount++;   
        }
        else{
          searchOrder++;
          searchContains();
          compareCount++;          
        }   
   }
}