import java.util.ArrayList;

public class Board extends Game {

    public Piece[][] board = new Piece[8][8];
    public boolean whiteTurn;

    private Coord whiteKing;
    private Coord blackKing;

    private ArrayList<Piece> whitePieces = new ArrayList();
    private ArrayList<Piece> blackPieces = new ArrayList();

    private int whiteMoves;
    private int blackMoves;

    public Board () {
        resetBoard();


    }
    
    /* IPE --------- IMMEDIATE POSITION EVALUATOR

       the IPE is a position evaluator that doesn't take into account future moves

       MATERIAL:
           Pawn: 1
           Isolated Pawn: 0.8

           Knight: 3
           Bishop: 3 (with 2 of them)
           Bishop: 2.8 (individual)
           Rook: 5
           Queen: 9

           King: 40 (check mate)

       POSSIBLE MOVES:

             Each move: 0.05

       TO ADD:

          King being castled: 0.2 (need to add castling)
          Passed pawns: every pawn past all enemy pawns is 1.5 (add promotion and en Passent)

     */
    public double IPE () {

        this.whiteTurn = !this.whiteTurn;
        if (this.whiteTurn) {
            blackMoves = this.allLegalMoves().moves.size();
        } else {
            whiteMoves = this.allLegalMoves().moves.size();
        }
        this.whiteTurn = !this.whiteTurn;

        double total = 0;

        total += whiteMoves * 0.05;
        total -= blackMoves * 0.05;

        for (int i = 0; i < whitePieces.size(); i++) {
            char c = whitePieces.get(i).letter;

            if (c == 'Q'){
                total += 9;
            }
            else if (c == 'R'){
                total += 5;
            }
            else if (c == 'B'){
                total += 3;
            }
            else if (c == 'N'){
                total += 3;
            }
            else if (c == 'P'){
                total += 1;
            }
            else if (c == 'K'){
                total += 40;
            }
        }

        for (int i = 0; i < blackPieces.size(); i++) {
            char c = blackPieces.get(i).letter;

            if (c == 'q'){
                total -= 9;
            }
            else if (c == 'r'){
                total -= 5;
            }
            else if (c == 'b'){
                total -= 3;
            }
            else if (c == 'n'){
                total -= 3;
            }
            else if (c == 'p'){
                total -= 1;
            }
            else if (c == 'k'){
                total -= 40;
            }
        }

        return total;

    }










    public void addPiece (Piece p){

        board[p.c.x][p.c.y] = p;

        if (p.letter == 'K'){
            whiteKing = p.c;
        } else if (p.letter == 'k') {
            blackKing = p.c;
        }

        if (p.white) {
            whitePieces.add(p);
        } else {
            blackPieces.add(p);
        }

    }

    public void addPiece (int x, int y, char a) {

        Coord c = new Coord(x, y);

        this.addPiece(c, a);

    }


    public void addPiece (String s, char a) {

        Coord c = new Coord(s);

        this.addPiece(c, a);

    }


    public void addPiece (Coord c, char a) {

        if (a == 'n') {
            Piece p = new Knight(c, false);
            this.addPiece(p);
        } else if (a == 'N') {
            Piece p = new Knight(c, true);
            this.addPiece(p);
        } else if (a == 'b') {
            Piece p = new Bishop(c, false);
            this.addPiece(p);
        } else if (a == 'B') {
            Piece p = new Bishop(c, true);
            this.addPiece(p);
        } else if (a == 'p') {
            Piece p = new Pawn(c, false);
            this.addPiece(p);
        } else if (a == 'P') {
            Piece p = new Pawn(c, true);
            this.addPiece(p);
        } else if (a == 'q') {
            Piece p = new Queen(c, false);
            this.addPiece(p);
        } else if (a == 'Q') {
            Piece p = new Queen(c, true);
            this.addPiece(p);
        } else if (a == 'r') {
            Piece p = new Rook(c, false);
            this.addPiece(p);
        } else if (a == 'R') {
            Piece p = new Rook(c, true);
            this.addPiece(p);
        } else if (a == 'k') {
            Piece p = new King(c, false);
            this.addPiece(p);
        } else if (a == 'K') {
            Piece p = new King(c, true);
            this.addPiece(p);
        }
    }


    // only do this if its legal
    public void move (Coord start, Coord end) {

        Piece p  = board[start.x][start.y];

        if (p.letter == 'K'){
            whiteKing = end;
        } else if (p.letter == 'k') {
            blackKing = end;
        }

        board[start.x][start.y] = new Empty(start.x, start.y);
        board[end.x][end.y] = p;

    }

    public Board moveBoard (Coord start, Coord end) {
        Board b = this;

        Piece p  = b.board[start.x][start.y];

        if (p.letter == 'K'){
            whiteKing = end;
        } else if (p.letter == 'k') {
            blackKing = end;
        }

        b.board[start.x][start.y] = new Empty(start.x, start.y);
        b.board[end.x][end.y] = p;


        //flips the turn
        b.whiteTurn = !this.whiteTurn;

        return b;
    }


    public Board moveBoard (Move m) {
        Board b = moveBoard(m.start, m.end);
        return b;
    }

    public Piece getPiece(String s) {

        Coord c = new Coord(s);

        return board[c.x][c.y];

    }

    public Piece getPiece(Coord c) {

        return board[c.x][c.y];

    }

    public Piece getPiece(int x, int y){

        return board[x][y];

    }

    public void resetBoard(){

        this.whiteTurn = true;

        board[0][0] = new Rook(0,0,true);
        board[1][0] = new Knight(1, 0, true);
        board[2][0] = new Bishop(2, 0, true);
        board[3][0] = new Queen(3, 0, true);
        board[4][0] = new King(4, 0, true);
        board[5][0] = new Bishop(5, 0, true);
        board[6][0] = new Knight(6, 0, true);
        board[7][0] = new Rook(7,  0, true);

        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(i, 1, true);
            board[i][6] = new Pawn(i, 6, false);
        }

        board[0][7] = new Rook(0,7,false);
        board[1][7] = new Knight(1, 7, false);
        board[2][7] = new Bishop(2, 7, false);
        board[3][7] = new Queen(3, 7, false);
        board[4][7] = new King(4, 7, false);
        board[5][7] = new Bishop(5, 7, false);
        board[6][7] = new Knight(6, 7, false);
        board[7][7] = new Rook(7, 7, false);

        whiteKing = new Coord(4, 0);
        blackKing = new Coord(4, 7);

        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                board[i][j] = new Empty(i, j);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!this.isEmpty(i, j)) {
                    this.addPiece(board[i][j]);
                }
            }
        }

    }

    public boolean isSameColourPiece (String s, boolean white) {

        Coord c = new Coord(0, 0);
        c.setCoords(s);

        return isSameColourPiece(c, white);

    }

    public boolean isSameColourPiece (int x, int y, boolean white) {

        Coord c = new Coord(x, y);

        return isSameColourPiece(c, white);

    }

    public boolean isSameColourPiece (Coord c, boolean white) {

        if (board[c.x][c.y].letter == ' '){

            return false;

        } else {

            return (board[c.x][c.y].isWhite() == white);

        }

    }


    public boolean isEmpty (Coord c) {

        if (board[c.x][c.y].letter == ' ') {

            return true;

        } else {

            return false;

        }

    }

    public boolean isEmpty (String s) {

        Coord c = new Coord(s);
        return isEmpty(c);

    }

    public boolean isEmpty (int x, int y) {

        Coord c = new Coord(x, y);
        return isEmpty(c);

    }

    public void printBoard () {

        for (int i = 7; i >= 0; i--) {

            for (int j = 0; j < 8; j++) {

                // j and i are flipped so its not arranged horizontally
                System.out.print(board[j][i].letter);
                System.out.print(" ");

            }

            System.out.println();

        }

    }

    public MoveList allLegalMoves (){
        MoveList m = allLegalishMoves();
        m = trimChecks(m);

        if (whiteTurn){
            this.whiteMoves = m.moves.size();
        } else {
            this.blackMoves = m.moves.size();
        }

        return m;
    }

    public MoveList allLegalishMoves () {

        MoveList m = new MoveList();

        // if oppositeTurn is passed it gets other sides moves

        if (this.whiteTurn) {
            for (int i = 0; i < this.whitePieces.size(); i++) {
                Piece p = this.whitePieces.get(i);
                m.addAll(p.getMoveList(this));
            }
        }
        else {
            for (int i = 0; i < this.blackPieces.size(); i++) {
                Piece p = this.blackPieces.get(i);
                m.addAll(p.getMoveList(this));
            }
        }
        return m;
    }

    public MoveList trimChecks(MoveList m) {

        // go through each move in the list, see if opposite colour has any moves hitting this king
        for (int i = 0; i < m.moves.size(); i++) {

            MoveList tempM;
            Move move = m.getMove(i);

            // now Board is the board after the move has been made, whether legal or not
            Board board = this.moveBoard(move);

            // gets all legal moves for opposite colour now.
            tempM = board.allLegalishMoves();

            // checks all of those moves to see if one of them hits the king
            if (this.whiteTurn) {
                for (int j = 0; j < tempM.moves.size(); j++) {
                    Move tempMove = tempM.getMove(j);
                    if (tempMove.end.equals(whiteKing)) {

                        // break because any move that hits king means that move shouldn't be legal
                        m.removeMove(i);
                        break;
                    }
                }
            } else {
                for (int j = 0; j < tempM.moves.size(); j++) {
                    Move tempMove = tempM.getMove(j);
                    if (tempMove.end.equals(blackKing)) {

                        m.removeMove(i);
                        break;
                    }
                }
            }
        }

        return m;
    }

}
