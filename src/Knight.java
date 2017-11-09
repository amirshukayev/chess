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

        Coord c = new Coord(0,0);

        int testX = super.c.x;
        int testY = super.c.y;
        testX+=2;
        testY--;
        c.setCoords(testX, testY);
        if (testY > -1 && testX < 8 && !b.isSameColourPiece(c, super.white)) {
            System.out.println("Worked 1");
            m.addMove(super.c, c);
        }



        testX = super.c.x;
        testY = super.c.y;
        testX+=2;
        testY++;
        c.setCoords(testX, testY);
        if (testY > -1 && testX < 8 && !b.isSameColourPiece(c, super.white)) {
            System.out.println("Worked 2");
            m.addMove(super.c, c);
        }


        testX = super.c.x;
        testY = super.c.y;
        testX--;
        testY+=2;
        c.setCoords(testX, testY);
        if (testY > -1 && testX < 8 && !b.isSameColourPiece(c, super.white)) {
            m.addMove(super.c, c);
        }


        testX = super.c.x;
        testY = super.c.y;
        testX++;
        testY+=2;
        c.setCoords(testX, testY);
        if (testY > -1 && testX < 8 && !b.isSameColourPiece(c, super.white)) {
            m.addMove(super.c, c);
        }

        return m;

    }

}
