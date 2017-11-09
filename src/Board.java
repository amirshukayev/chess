public class Board extends Game {

    public Piece[][] board = new Piece[8][8];

    public Board () {

    }

    public void addPiece (Piece p){

        board[p.c.x][p.c.y] = p;

    }

    // only do this if its legal
    public void move (Coord start, Coord end) {

        Piece p  = board[start.x][start.y];

        board[start.x][start.y] = null;
        board[end.x][end.y] = p;

    }

    public Piece getPiece(String s) {

        Coord c = new Coord(s);

        return board[c.x][c.y];

    }

    public Piece getPiece(Coord c) {

        return board[c.x][c.y];

    }

    public void resetBoard(){

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

        for (int i = 0; i < 8; i++) {

            for (int j = 2; j < 6; j++) {

                board[i][j] = new Empty(i, j);

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

}