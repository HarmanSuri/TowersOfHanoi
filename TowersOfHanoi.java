/*  Class TowersOfHanoi
    Author: Harman Suri
    Nov 6, 2020
    Description:    Asks the user for a number of disks to make a tower,
                    then uses a recursive method to tell the user what moves
                    are needed to get the tower from the first pole to the
                    last. All moves avoid having a higher number/larger
                    disk on top of a smaller one.

    Methods:        main (String[] args)                            - asks for user input and uses that input to pass into moveTower
                    String moveTower (int n, int start, int end)    - takes in a number of disks and a start and end position,
                                                                      recursively moves those number of disks from the start to the end
 */

import javax.swing.JOptionPane;

public class TowersOfHanoi {

    public static void main(String[] args) {
        // asks the user for how many disks they want the tower to be
        int disks = Integer.parseInt(JOptionPane.showInputDialog("How many disks is the tower made of?"));
        
        // shows the user every move to get the tower from the first post to the third post
        System.out.println(moveTower(disks, 1, 3));
    }

    /*
        moveTower recursively moves a tower of n number of disks from the
        start position to the end position, using the middle position for help.
        A string with the moves needed to move the all the disks.
    */
    public static String moveTower (int n, int start, int end) {
        // calculates the middle post
        int middle = 6 - (start + end);

        // if n is 1 (most simple case)
        if (n == 1) {
            // disk 1 is moved from the current start to the current end
            return "1 from " + start + " to " + end + "\n";
        }
        // otherwise
        else {
            // every disk except the largest one (or n) is moved from the current start to the the current middle
            // then the largest disk (or n) is moved from the current start to the current end, only after every disks above it is gone
            // finally the tower made by all the disks, except the largest one (that were moved to the current middle), are moved to the end on top of the largest one
            return moveTower(n - 1, start, middle) + (n + " from " + start + " to " + end + "\n") + moveTower(n - 1, middle, end);
        }
    }
}