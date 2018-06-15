/**
 * https://www.reddit.com/r/dailyprogrammer/comments/8jcffg/20180514_challenge_361_easy_tally_program/
 * tally players scores and sort
 */

import java.util.Scanner;

public class Tally {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] players = new int[5];
        int[] scores = new int[5];
        
        String input = keyboard.nextLine();
        
        for (int i = 0; i < players.length; i++) {
            players[i] = i + 'a';
        }

        for (int i = 0; i < input.length(); i++) {

            switch (input.charAt(i)) {
                case 'a':
                    scores[0]++;
                    break;   
                case 'b':
                    scores[1]++;
                    break;
                case 'c':
                    scores[2]++;
                    break;
                case 'd':
                    scores[3]++;
                    break;
                case 'e':
                    scores[4]++;
                    break;
        
                case 'A':
                    scores[0]--;
                    break;
                case 'B':
                    scores[1]--;
                    break;
                case 'C':
                    scores[2]--;
                    break;
                case 'D':
                    scores[3]--;
                    break;
                case 'E':
                    scores[4]--;
                    break;
             
                default:
                    break;
         
            }
        }
        
        
        for (int i = 0; i < scores.length - 1; i++) {
            for (int j = 0; j < scores.length - i - 1; j++) {
                if (scores[j] < scores[j + 1]) {
                    int temp = scores[j + 1];
                    scores[j + 1] = scores[j];
                    scores[j] = temp;

            
                    temp = players[j + 1];
                    players[j + 1] = players[j];
                    players[j] = temp;
                }
            }
        }
       
        for (int i = 0; i < players.length; i++) {
            System.out.print((char) players[i] + ": " + scores[i] + " ");
        }
    }
}
