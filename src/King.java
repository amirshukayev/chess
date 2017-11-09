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

        return m;

    }

}
