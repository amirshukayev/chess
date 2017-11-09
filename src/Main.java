public class Main {

    public static void main (String[] args){

        Board b = new Board();
        b.resetBoard();

        Piece p2 = new Rook("e5", true);
        b.addPiece(p2);

        b.printBoard();

        Piece p = b.getPiece("e5");
        MoveList m = p.getMoveList(b);

        m.printMoves();

    }

}
