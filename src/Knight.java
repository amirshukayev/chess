public class Knight extends Piece {

    public Knight (Coord c, boolean white) {

        super.c = c;
        super.white = white;

        if (white) {

            super.letter = 'N';

        } else {

            super.letter = 'n';

        }

    }

    public Knight (String s, boolean white) {

        Coord c = new Coord(s);

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'N';

        } else {

            super.letter = 'n';

        }

    }

    public Knight (int x, int y, boolean white) {

        super.white = white;

        Coord c = new Coord(x, y);

        super.c = c;

        if (white) {

            super.letter = 'N';

        } else {

            super.letter = 'n';

        }

    }

    @Override
    public MoveList getMoveList (Board b) {

        MoveList m = new MoveList();

        int testX = super.c.x;
        int testY = super.c.y;
        testX+=2;
        testY--;
        if (testY > -1 && testX < 8) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }



        testX = super.c.x;
        testY = super.c.y;
        testX+=2;
        testY++;
        if (testY < 8 && testX < 8) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }


        testX = super.c.x;
        testY = super.c.y;
        testX--;
        testY+=2;
        if (testY < 8 && testX > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }



        testX = super.c.x;
        testY = super.c.y;
        testX--;
        testY-=2;
        if (testY > -1 && testX > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }


        testX = super.c.x;
        testY = super.c.y;
        testX++;
        testY+=2;
        if (testY < 8 && testX < 8) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }



        testX = super.c.x;
        testY = super.c.y;
        testX++;
        testY-=2;
        if (testY > -1 && testX < 8) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;
        testX-=2;
        testY++;
        if (testY < 8 && testX > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;
        testX-=2;
        testY--;
        if (testY > -1 && testX > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        return m;

    }

}
