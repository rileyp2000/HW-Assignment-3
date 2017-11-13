/**
 * 
 * @author Patrick Riley
 */

/**
 * <p>This program takes a text file, creates an index (by line numbers)
 *  for all the words in the file and writes the index
 *  into the output file.  The program takes input and output file names
 *  from the command-line args or prompts the user for the file names.
 *  THIS FILE WAS TAKEN FROM THE INDEXMAKER LAB IN CHAPTER 11 OF THE SKYLIT
 *  JAVA METHODS BOOK</p>
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file:

    if (args.length > 0)
      fileName = args[0];
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile =
                 new BufferedReader(new FileReader(fileName), 1024);

    String readInFile = fileName;
    
    // Create output file:

    if (args.length > 1)
      fileName = args[1];
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }

    PrintWriter outputFile =
                 new PrintWriter(new FileWriter(fileName));

    
    
    /*outputFile.println("***Tests for IndexMaker***\n\n");
    
    IndexEntry n1 = new IndexEntry("hello");
	n1.add(0);
	n1.add(1);
	n1.add(2);
	n1.add(3);
	outputFile.println(n1);
	
    IndexEntry n2 = new IndexEntry("test 2", 4);
    outputFile.println(n2);
    
    IndexEntry n3 = new IndexEntry(n2);
    outputFile.println("Copy of the previous IndexEntry: " + n3);
    
    outputFile.println("Compare n1 and n2: " + n1.compareTo(n2));
    
    outputFile.println("\n\n**Tests for DocumentIndex***\n\n");*/
    
    
    
    // Create index:

    DocumentIndex index = new DocumentIndex();

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    // Save index:
    outputFile.println("Index for " + readInFile + ": ");
    Set<String> keyVal = index.keySet();
    for (String entry : keyVal)
      outputFile.println(index.get(entry));

    // Finish:

    inputFile.close();
    outputFile.close();

    keyboard.close();
    System.out.println("Done.");
  }
}

