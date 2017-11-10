import java.util.ArrayList;

public class MoveList
{

    public ArrayList<Move> moves = new ArrayList();

    public MoveList(){

    }

    public void addMove (Coord start, Coord end){

        Move m = new Move(start, end);

        moves.add(m);

    }

    public void addMove (Move m) {

        moves.add(m);

    }

    public Move getMove (int i) {

        return moves.get(i);

    }

    public void printMoves () {

        System.out.println(moves.size());

        for (int i = 0; i < moves.size(); i++) {

            Move m = moves.get(i);

            System.out.print(m.start.x);
            System.out.print(",");
            System.out.print(m.start.y);
            System.out.print(" ");
            System.out.print(m.end.x);
            System.out.print(",");
            System.out.println(m.end.y);

        }

    }

}
