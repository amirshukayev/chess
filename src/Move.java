public class Move {

    public Coord start;
    public Coord end;

    public Move (Coord start, Coord end) {

        this.start = start;
        this.end = end;

    }

    public Move (String s1, String s2) {

        Coord c1 = new Coord(s1);
        Coord c2 = new Coord(s2);

        this.start = c1;
        this.end = c2;

    }

}
