package ph.nextbank;

import lombok.Data;

@Data
public class Node {
    private String key;
    private Object value;
    private Node next;
}