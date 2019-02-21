/** Description of class
  *
  * @author		Grant Ross
  * @id			gross
  * @course		Programming II
  * @assignment		HashLab
  * @related		
  * @included		Person
  */
public class Person implements Hashable, Comparable<Person>
{
    protected String name;
    protected int idNum;
    protected String emailAcc;
    protected final int MAX_ELEMENTS = 20000;
   
    public Person (String name, String email, int SSN)
    {
        this.name = name;
        idNum = SSN;
        emailAcc = email;
    }
   
    public int hash()
        {
            return (idNum % MAX_ELEMENTS);
        }
    public int compareTo(Person e) {
       if (idNum > e.idNum)
            return 1;
       if (idNum < e.idNum)
            return -1;
        return 0;
    }
    public int getSSN(){
        return idNum;
    }
}

   