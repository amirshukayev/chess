public class Empty extends Piece {

    public Empty (Coord c) {

        super.c = c;

        // not really needed
        super.white = true;

        super.letter = ' ';

    }

    public Empty (int x, int y) {

        Coord c = new Coord(x, y);

        super.c = c;

        super.white = white;

        super.letter = ' ';

    }

}
