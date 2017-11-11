public class Bishop extends Piece {

    public Bishop (Coord c, boolean white) {

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'B';

        } else {

            super.letter = 'b';

        }

    }

    public Bishop (String s, boolean white) {

        Coord c = new Coord(s);

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'B';

        } else {

            super.letter = 'b';

        }

    }

    public Bishop (int x, int y, boolean white) {

        super.white = white;

        Coord c = new Coord(x, y);

        super.c = c;

        if (white) {

            super.letter = 'B';

        } else {

            super.letter = 'b';

        }

    }

    public MoveList getMoveList (Board b) {

        MoveList m = new MoveList();

        int testX = super.c.x;
        int testY = super.c.y;
        testX++;
        testY++;
        while (testX < 8 && testY < 8 && testX > -1 && testY > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)){
                m.addMove(super.c, c);
                if (!b.isEmpty(c)){
                    break;
                }
            } else {
                break;
            }
            testX++;
            testY++;
        }


        testX = super.c.x;
        testY = super.c.y;
        testX++;
        testY--;
        while (testX < 8 && testY < 8 && testX > -1 && testY > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)){
                m.addMove(super.c, c);
                if (!b.isEmpty(c)){
                    break;
                }
            } else {
                break;
            }
            testX++;
            testY--;
        }



        testX = super.c.x;
        testY = super.c.y;
        testX--;
        testY++;
        while (testX < 8 && testY < 8 && testX > -1 && testY > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)){
                m.addMove(super.c, c);
                if (!b.isEmpty(c)){
                    break;
                }
            } else {
                break;
            }
            testX--;
            testY++;
        }


        testX = super.c.x;
        testY = super.c.y;
        testX--;
        testY--;
        while (testX < 8 && testY < 8 && testX > -1 && testY > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)){
                m.addMove(super.c, c);
                if (!b.isEmpty(c)){
                    break;
                }
            } else {
                break;
            }
            testX--;
            testY--;
        }


        return m;

    }

}
