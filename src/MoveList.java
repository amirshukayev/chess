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

    public void addAll (MoveList m) {

        moves.addAll(m.moves);

    }

    public void removeMove (int i) {

        moves.remove(i);

    }

    public void printMoves () {

        System.out.println("Number of Legal Moves: " + moves.size());

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

    public void printMovesAN () {

        System.out.println("Number of Legal Moves: " + moves.size());

        for (int i = 0; i < moves.size(); i++) {

            Move m = moves.get(i);

            System.out.print((char)(m.start.x + 'a'));
            System.out.print(m.start.y + 1);
            System.out.print(" to ");
            System.out.print((char)(m.end.x + 'a'));
            System.out.println(m.end.y + 1);

        }

    }

}
