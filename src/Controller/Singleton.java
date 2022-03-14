package Controller;

public class Singleton {
    private static Singleton single_instance = null;
    protected Singleton() {
    }
    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
}
