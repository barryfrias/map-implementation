package ph.nextbank;

public class Main {
    public static void main(String[] args) {
        BlfriasMap map = new BlfriasMap();
        map.put("test", "test");
        map.put("test", "test2");
        System.out.println(map.get("test"));
        /*
        PLS RUN THE JUNIT TEST ph.nextbank.tests.BlfriasMapTest
        */
    }
}