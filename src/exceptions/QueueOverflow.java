package exceptions;

/**
 * Created by seeme on 6/11/2017.
 */
public class QueueOverflow extends RuntimeException{

    public QueueOverflow()
    {
        super();
    }

    public QueueOverflow(String message)
    {
        super (message);
    }

}
