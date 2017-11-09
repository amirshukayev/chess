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

        return m;

    }

}
