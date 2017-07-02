package exceptions;

/**
 * Created by seeme on 6/18/2017.
 */
public class ElementNotExist extends Exception{
    public ElementNotExist() {
        super();
    }

    public ElementNotExist(String msg) {
        super(msg);
    }
}
