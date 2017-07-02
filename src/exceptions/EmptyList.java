package exceptions;

/**
 * Created by seeme on 6/18/2017.
 */
public class EmptyList extends Exception{
    public EmptyList() {
        super();
    }

    public EmptyList(String msg) {
        super(msg);
    }
}
