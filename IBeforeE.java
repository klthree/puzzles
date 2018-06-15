/**
 * reddit.com/r/dailyprogrammer/coments/8q96da/20180611_challenge_363_easy_i_before_e_except 
 * Easy challenge to test words for conformity to the "i before e" rule
 *
 */


import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class IBeforeE {

static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {   
        
        while(true) {
            System.out.println("Enter the number corresponding to your choice:\n"
                    + "1. Test a word\n2. Test a file\n3. Exit");
            String input = keyboard.nextLine();
            System.out.println();

            if (input.equals("1")) {
                wordTester();
            }
            else if (input.equals("2")) { 
                fileTester();
            }
            else if (input.equals("3")) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Invalid selection. Try again.\n");
                continue;
            }
        }
    }

    // The point of the challenge. Regex match for exceptions.
    public static boolean exceptionTester (String s) { 
        return (s.matches("^ei.*|.*cie.*|.*[^cC]+ei.*"));
    }

    /**
     * Prompts for individual words and sends them to exceptionTester
     */
    public static void wordTester() { 
                System.out.print("Enter word: ");
                String word = keyboard.nextLine();
                
                if (exceptionTester(word)) {
                    System.out.println("false\n");
                }
                else {
                    System.out.println("true\n");
                }
    }

    /**
     * Prompts for filename of file consisting of a list of words, with each
     * word on a new line, to read and count exceptions
     */
    public static void fileTester() {
                String file;
                System.out.println("Enter name of file to process: ");
        
                try {
                file = keyboard.nextLine();
                File inputFile = new File(file);
                if (!inputFile.exists()) {
                    System.out.println("File not found\n");
                    return;
                }
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr);
        
                int exceptionCount = 0;
                String nextWord;
        
                while((nextWord = br.readLine()) != null) {
                    if (exceptionTester(nextWord)) {
                        exceptionCount++;
                    }
                }
        
        
                System.out.println("Number of exceptions in file: " + exceptionCount + "\n");
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
    }
}
