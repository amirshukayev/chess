public abstract class Piece
{

    // stuff
    public boolean white;
    public Coord c;
    public char letter;


    public Piece() {

    }

    public boolean isWhite () {

        return this.white;

    }

    public MoveList getMoveList(Board b) {

        // REMOVE
        System.out.println("Not Overrided.");

        MoveList m = new MoveList();
        return m;

    }

}
