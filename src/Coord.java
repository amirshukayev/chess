public class Coord {
    public static int x;
    public static int y;

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    // converts algebraic notation to coordinates
    // A1, a1, h5, etc...
    
    public void setCoords(String str){
        char a = str.charAt(0);

        if (a < 73 && a > 64) {
            this.x = a - 65;
        }
        else if (a < 105 && a > 96){
            this.x = a - 97;
        }

        this.y = str.charAt(1) - 1;
    }
}
