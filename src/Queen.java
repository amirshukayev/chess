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

        return m;

    }

}
