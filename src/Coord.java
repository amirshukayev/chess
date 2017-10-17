import java.lang.IllegalArgumentException;

public class Coord {

    public static int x;
    public static int y;

    public Coord (int x, int y){

        this.x = x;
        this.y = y;

    }

    public Coord (){

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

    public void setCoords(String str) {
        
        char c = str.charAt(0);

        // make sure input is 1 Letter (A-H or a=h) followed by 1 number(1-8)
        if (str.length() == 2 && ( (c <= 'H' && c >= 'A') || (c < 'h' && c > 'a') ) &&  ('0' < str.charAt(1) && str.charAt(1) < '9') ) {

            if (c <= 'H' && c >= 'A') {

                // char to int (0-7)
                this.x = c - 'A';

            } else if (c <= 'h' && c >= 'a') {

                // char to int (0 - 7)
                this.x = c - 'a';

            }

            this.y = str.charAt(1) - '1';

        } else {

            throw new IllegalArgumentException("setCoords() didn't get Letter-Number");

        }
    }
}
