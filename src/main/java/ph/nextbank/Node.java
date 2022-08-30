package ph.nextbank;

import lombok.Data;

@Data
public class Node {
    private int hash;
    private String key;
    private Object value;
    private Node next;

    @SuppressWarnings("unused")
    public boolean hasNext() {
        return next != null;
    }
}