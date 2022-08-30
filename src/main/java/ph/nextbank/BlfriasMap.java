package ph.nextbank;

public class BlfriasMap {

    private final int bucketSize = 100;
    Node[] storage = new Node[bucketSize];

    private int actualSize = 0;
    public int size() {
        return actualSize;
    }

    public boolean isEmpty() {
        return actualSize == 0;
    }

    public boolean containsKey(String key) {
        return key != null && storage[deriveIndex(key.hashCode())] != null;
    }

    public Object get(String key) {
        Node value = storage[deriveIndex(key.hashCode())];
        if(value == null) return null;

        if(value.getKey().equals(key)) {
            return value.getValue();
        }

        while(value != null) {
            if(value.getKey().equals(key)) {
                return value.getValue();
            }
            value = value.getNext();
        }

        return null;
    }

    public void put(String key, Object value) {
        if(key == null) {
            throw new IllegalArgumentException("null key not allowed");
        }
        int hash = key.hashCode();
        int index =  deriveIndex(hash);
        Node n = new Node();
        n.setKey(key);
        n.setValue(value);

        Node existing = storage[index];
        if(existing == null) {
            storage[index] = n;
            actualSize++;
            return;
        }

        while(existing != null) {
            if(n.getKey().equals(existing.getKey())) {
                existing.setValue(n.getValue());
                return;
            }
            Node next = existing.getNext();
            if(next == null) {
                existing.setNext(n);
                actualSize++;
                return;
            }
            existing = next;
        }
    }

    private int deriveIndex(int hash) {
        return hash & (bucketSize - 1);
    }

    public Object remove(String key) {
        if(key == null) return null;
        int index = deriveIndex(key.hashCode());
        Node val = storage[index];
        if(val == null) {
            return null;
        }

        if(key.equals(val.getKey())) {
            storage[index] = null;
            actualSize--;
            return val.getValue();
        }

        Node current = val.getNext();
        while(current != null) {
            if(key.equals(current.getKey())) {
                actualSize--;
                val.setNext(null);
                return val.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public void clear() {
        this.storage = new Node[bucketSize];
        actualSize = 0;
    }
}