public class Rook extends Piece {

    public Rook (Coord c, boolean white) {

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'R';

        } else {

            super.letter = 'r';

        }

    }

    public Rook (String s, boolean white) {

        Coord c = new Coord(s);

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'R';

        } else {

            super.letter = 'r';

        }

    }

    public Rook (int x, int y, boolean white) {

        super.white = white;

        Coord c = new Coord(x, y);

        super.c = c;

        if (white) {

            super.letter = 'R';

        } else {

            super.letter = 'r';

        }

    }

    @Override
    public MoveList getMoveList (Board b) {

        MoveList moves = new MoveList();

        int testX = super.c.x;
        int testY = super.c.y;

        testX--;

        while (testX > -1) {

            Coord c = new Coord(testX, testY);

            if (!b.isSameColourPiece(c, super.white) ) {

                moves.addMove(super.c, c);
                if (b.getPiece(c).letter != ' ') {
                    break;
                }

            } else {
                break;
            }

            testX--;

        }

        testX = super.c.x;

        testX++;
        while (testX < 8) {

            Coord c = new Coord(testX, testY);

            if (!b.isSameColourPiece(c, super.white) ) {

                moves.addMove(super.c, c);
                if (b.getPiece(c).letter != ' ') {
                    break;
                }

            } else {
                break;
            }

            testX++;

        }

        testX = super.c.x;

        testY--;
        while (testY > -1) {

            Coord c = new Coord(testX, testY);

            if (!b.isSameColourPiece(c, super.white) ) {

                moves.addMove(super.c, c);
                if (b.getPiece(c).letter != ' ') {
                    break;
                }

            } else {
                break;
            }

            testY--;

        }

        testY = super.c.y;

        testY++;
        while (testY < 8){

            Coord c = new Coord(testX, testY);

            if (!b.isSameColourPiece(c, super.white) ) {

                moves.addMove(super.c, c);
                if (b.getPiece(c).letter != ' ') {
                    break;
                }

            } else {
                break;
            }

            testY++;

        }

        return moves;

    }

}
