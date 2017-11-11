public class Pawn extends Piece {

    public boolean firstMove;
    public boolean enPassant;

    public Pawn (Coord c, boolean white) {

        super.c = c;
        super.white = white;

        if (white) {

            super.letter = 'P';

        } else {

            super.letter = 'p';

        }

        this.firstMove = true;
        this.enPassant = false;

    }

    public Pawn (int x, int y, boolean white) {

        super.white = white;

        Coord c = new Coord(x, y);

        super.c = c;

        if (white) {

            super.letter = 'P';

        } else {

            super.letter = 'p';

        }

        this.firstMove = true;
        this.enPassant = false;

    }


    public Pawn (String s, boolean white) {

        Coord c = new Coord(s);

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'P';

        } else {

            super.letter = 'p';

        }

        this.firstMove = true;
        this.enPassant = false;

    }

    @Override
    public MoveList getMoveList (Board b) {

        MoveList m = new MoveList();

        if (super.white) {
            int testX = super.c.x;
            int testY = super.c.y;

            if (testY != 7) {
                testY++;
                if (b.isEmpty(testX, testY)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }

            // moving two up
            if (this.c.y == 1) {
                testY++;
                if (b.isEmpty(testX, testY) && b.isEmpty(testX, testY - 1)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }

            // testing for diagonal eating
            if (testX != 0) {
                testY--;
                testX--;

                if (!b.isSameColourPiece(testX, testY, this.white) && !b.isEmpty(testX, testY)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }

            testX++;
            if (testX != 7) {
                testX++;
                if (!b.isSameColourPiece(testX, testY, this.white) && !b.isEmpty(testX, testY)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }
        }

        else {
            int testX = super.c.x;
            int testY = super.c.y;

            if (testY != 0) {
                testY--;
                if (b.isEmpty(testX, testY)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }

            // moving two up
            if (this.c.y == 6) {
                testY--;
                if (b.isEmpty(testX, testY) && b.isEmpty(testX, testY + 1)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }

            // testing for diagonal eating
            if (testX != 0) {
                testY++;
                testX--;

                if (!b.isSameColourPiece(testX, testY, this.white) && !b.isEmpty(testX, testY)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }

            testX++;
            if (testX != 7) {
                testX++;
                if (!b.isSameColourPiece(testX, testY, this.white) && !b.isEmpty(testX, testY)) {
                    Coord c = new Coord(testX, testY);
                    m.addMove(super.c, c);
                }
            }
        }



        return m;

    }

}
