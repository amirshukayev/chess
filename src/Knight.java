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
        if (testY > -1 && testX < 8) {
            System.out.println("Worked 1");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }



        testX = super.c.x;
        testY = super.c.y;
        testX+=2;
        testY++;
        c.setCoords(testX, testY);
        if (testY < 8 && testX < 8) {
            System.out.println("Worked 2");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }


        testX = super.c.x;
        testY = super.c.y;
        testX--;
        testY+=2;
        c.setCoords(testX, testY);
        if (testY < 8 && testX > -1) {
            System.out.println("Worked 3");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }



        testX = super.c.x;
        testY = super.c.y;
        testX--;
        testY-=2;
        c.setCoords(testX, testY);
        if (testY > -1 && testX > -1) {
            System.out.println("Worked 4");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }


        testX = super.c.x;
        testY = super.c.y;
        testX++;
        testY+=2;
        c.setCoords(testX, testY);
        if (testY < 8 && testX < 8) {
            System.out.println("Worked 5");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;
        testX++;
        testY-=2;
        c.setCoords(testX, testY);
        if (testY > -1 && testX < 8) {
            System.out.println("Worked 6");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;
        testX-=2;
        testY++;
        c.setCoords(testX, testY);
        if (testY < 8 && testX > -1) {
            System.out.println("Worked 7");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }

        testX = super.c.x;
        testY = super.c.y;
        testX-=2;
        testY--;
        c.setCoords(testX, testY);
        if (testY > -1 && testX > -1) {
            System.out.println("Worked 8");
            if (!b.isSameColourPiece(c, super.white)) {
                m.addMove(super.c, c);
            }
        }


        return m;

    }

}
