public class King extends Piece {

    public King (Coord c, boolean white) {

        super.c = c;
        super.white = white;

        if (white) {

            super.letter = 'K';

        } else {

            super.letter = 'k';

        }

    }

    public King (String s, boolean white) {

        Coord c = new Coord(s);

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'K';

        } else {

            super.letter = 'k';

        }

    }

    public King (int x, int y, boolean white) {

        super.white = white;

        Coord c = new Coord(x, y);

        super.c = c;

        if (white) {

            super.letter = 'K';

        } else {

            super.letter = 'k';

        }

    }

    @Override
    public MoveList getMoveList (Board b) {

        MoveList m = new MoveList();

        int testX = super.c.x;
        int testY = super.c.y;

        if (testX != 0) {
            testX--;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;

        if (testX != 0 && testY != 0) {
            testX--;
            testY--;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;

        if (testX != 0 && testY != 7) {
            testX--;
            testY++;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;

        if (testY != 7) {
            testY++;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;

        if (testX != 7 && testY != 7) {
            testX++;
            testY++;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;

        if (testX != 7) {
            testX++;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;

        if (testX != 7 && testY != 0) {
            testX++;
            testY--;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;

        if (testY != 0) {
            testY--;
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        return m;

    }

}
