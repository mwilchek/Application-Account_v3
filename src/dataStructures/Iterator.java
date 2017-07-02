package dataStructures;

import java.io.Serializable;

/**
 * Created by Matt on 6/17/2017.
 */
public interface Iterator<data extends Comparable> extends Serializable {
    public void reset();
    public data getNext(data element);
}
