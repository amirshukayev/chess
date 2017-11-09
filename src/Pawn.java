public class Pawn extends Piece {

    public Pawn (Coord c, boolean white) {

        super.c = c;
        super.white = white;

        if (white) {

            super.letter = 'P';

        } else {

            super.letter = 'p';

        }

    }

    public Pawn (int x, int y, boolean white) {

        super.white = white;

        Coord c = new Coord(x, y);

        super.c = c;

        if (white) {

            super.letter = 'P';

        } else {

            super.letter = 'p';

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
