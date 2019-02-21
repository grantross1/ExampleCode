/** Description of class
  *
  * @author		Grant Ross
  * @id			gross
  * @course		Programming II
  * @assignment		HashLab
  * @related		
  * @included		HashTable
  */
public class HashTable
{
    protected final int DEFCAP = 20000; // default capacity
    protected int origCap;            // original capacity
    protected Hashable[] list;        // array to hold this list’s elements
    protected int numElements = 0;    // number of elements in this list
    protected int location;   // indicates location of element if found
    protected int compares = 0;

    public HashTable() 
    {
      list = new Hashable[DEFCAP];
      origCap = DEFCAP;
    }  

    public HashTable(int origCap) 
    {
      list = (Hashable[]) new Object[origCap];
      this.origCap = origCap;
     }

    
     public void add (Hashable element)
     {
         int location;
         location = element.hash();
         compares++;
             while (list[location] != null){
                    location = (location + 1) %list.length;
                    compares++;
                    }
          list[location] = element;
         numElements++;
     }
   
     public Hashable get(Hashable element)
     {
         int location;
         location = element.hash();
             while (!list[location].equals(element))
                    location = (location + 1) %list.length;
                    return (Hashable)list[location];
     }
     public void compare(){
         System.out.println("  The hash table used "+compares +
         " compare(s) to sort the data.");
     }
}