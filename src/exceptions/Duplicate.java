package exceptions;

/**
 * Created by seeme on 6/17/2017.
 */
public class Duplicate extends Exception{
    public Duplicate() {
        super();
    }

    public Duplicate(String msg) {
        super(msg);
    }
}
