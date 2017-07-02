package exceptions;

/**
 * Created by seeme on 6/11/2017.
 */
public class QueueUnderflow extends RuntimeException {
    public QueueUnderflow()
    {
        super();
    }

    public QueueUnderflow(String message)
    {
        super (message);
    }

}
