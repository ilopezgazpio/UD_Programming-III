package Hanoi_Towers;

public class Hanoi_Towers
{

    /** hanoi towers recursive implementation
     *  - use recursion to solve towers of hanoi
     * @param PieceNumber variable denoting the size of the Hanoi problem
     * @param fromTower tower that contains the pieces we want to move
     * @param toTower tower to where we want to move the pieces
     * @param auxiliaryTower tower to use as auxiliary for movements
     */
    public static void hanoi (int PieceNumber, char fromTower, char toTower, char auxiliaryTower)
    {
        if (PieceNumber == 0) return;

        // Step 1
        hanoi (PieceNumber-1, fromTower, auxiliaryTower, toTower);

        // Step 2
        System.out.println("Move Piece from " + fromTower + " to " + toTower);

        // Step 3
        hanoi (PieceNumber-1, auxiliaryTower, toTower, fromTower);
    }



    public static void main(String[] args)
    {
        Hanoi_Towers.hanoi(4,'A', 'C','B');
    }
}
