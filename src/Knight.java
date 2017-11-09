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

        int testX = super.c.x;
        int testY = super.c.y;

        return m;

    }

}
