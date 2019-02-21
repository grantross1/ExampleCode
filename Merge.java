/*
*THIS IS NOT MY CODE!
*This is code taken and modified from the Chapter examples
*Code used for Hash Lab, lab 6
*This code has been modified for Grant Ross
*Original Authors Dale/Joyce/Weems 
*/ 

import java.util.*;

public class Merge
{
    static final int SIZE = 10000;            // size of array to be sorted
    static Person[] values = new Person[SIZE];   // values to be sorted
    static int compares = 0;
    static int swaps = 0;  
    static void initValues(Person[] personArray)
    // Initializes the values array with random integers from 0 to 99.
    {

      values = personArray;
   
    }

    static public boolean isSorted()
    // Returns true if the array values are sorted and false otherwise.
    {
        boolean sorted = true;
        for (int index = 0; index < (SIZE - 1); index++)
            if (values[index].compareTo(values[index + 1]) == 1)
                sorted = false;
                compares++;    
            return sorted;
   }

    static public void swap(int index1, int index2)
    // Precondition: index1 and index2 are >= 0 and < SIZE.
    //
    // Swaps the integers at locations index1 and index2 of the values array. 
    {
        Person temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    
    }

    static public void printValues()
    // Prints all the values integers.
    {
        Person value;
        System.out.println("The values array is:");
        for (int index = 0; index < SIZE; index++)
        {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(value.idNum);
            else
                System.out.print(value.idNum + " ");
        }
        System.out.println();
    }



    //  Merge Sort

    static void merge (int leftFirst, int leftLast,
    int rightFirst, int rightLast)
    // Preconditions: values[leftFirst]..values[leftLast] are sorted.
    //                values[rightFirst]..values[rightLast] are sorted.
    // 
    // Sorts values[leftFirst]..values[rightLast] by merging the two subarrays
    {
      Person[] tempArray = new Person [SIZE];
      int index = leftFirst;
      int saveFirst = leftFirst;  // to remember where to copy back
 
      while ((leftFirst <= leftLast) && (rightFirst <= rightLast))
      {
          if (values[leftFirst].compareTo(values[rightFirst]) == -1)
          {
              tempArray[index] = values[leftFirst];
              leftFirst++;
          }
          else
          {
              tempArray[index] = values[rightFirst];
              rightFirst++;
              swaps++;
          }
              compares++;
              index++;
      }
 
      while (leftFirst <= leftLast)
      // Copy remaining items from left half.
 
      {
          tempArray[index] = values[leftFirst];
          leftFirst++;
          index++;
      }
 
      while (rightFirst <= rightLast)
      // Copy remaining items from right half.
      {
          tempArray[index] = values[rightFirst];
          rightFirst++;
          index++;
      }
 
      for (index = saveFirst; index <= rightLast; index++)
          values[index] = tempArray[index];
    }

    static void mergeSort(int first, int last)
    // Sorts the values array using the merge sort algorithm.
    {
        if (first < last)
        {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }
    public void compare(){
        System.out.println("  The merge used "+compares +
        " compare(s) and "+swaps+" swap(s) to sort the data.");
     

     }
  }
