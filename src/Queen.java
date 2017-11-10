public class Queen extends Piece {

    public Queen (Coord c, boolean white) {

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'Q';

        } else {

            super.letter = 'q';

        }

    }

    public Queen (String s, boolean white) {

        Coord c = new Coord(s);

        super.white = white;
        super.c = c;

        if (white) {

            super.letter = 'Q';

        } else {

            super.letter = 'q';

        }

    }

    public Queen (int x, int y, boolean white) {

        super.white = white;

        Coord c = new Coord(x, y);

        super.c = c;

        if (white) {

            super.letter = 'Q';

        } else {

            super.letter = 'q';

        }

    }

    @Override
    public MoveList getMoveList (Board b) {

        MoveList m = new MoveList();

        int testX = super.c.x;
        int testY = super.c.y;

        // Rook type movement
        testX--;
        while (testX > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white) ) {
                m.addMove(super.c, c);
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
                m.addMove(super.c, c);
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
                m.addMove(super.c, c);
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
                m.addMove(super.c, c);
                if (b.getPiece(c).letter != ' ') {
                    break;
                }
            } else {
                break;
            }
            testY++;
        }


        // bishop type movement
        testX = super.c.x;
        testY = super.c.y;
        testX++;
        testY++;
        while (testX < 8 && testY < 8 && testX > -1 && testY > -1) {
            Coord c = new Coord(testX, testY);
            if (!b.isSameColourPiece(c, super.white)){
                m.addMove(super.c, c);
                if (b.getPiece(c).letter != ' '){
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
                if (b.getPiece(c).letter != ' '){
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
                if (b.getPiece(c).letter != ' '){
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
                if (b.getPiece(c).letter != ' '){
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
