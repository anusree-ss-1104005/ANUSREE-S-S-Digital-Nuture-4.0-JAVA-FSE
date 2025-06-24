public class SingletonPatternTest {
    public static void main(String[] args) {
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        
        
        System.out.println("logger1 and logger2 are the same instance: " + (logger1 == logger2));
        System.out.println("logger2 and logger3 are the same instance: " + (logger2 == logger3));
        
        
        logger1.log("Application started");
        logger2.error("Something went wrong");
        logger3.warn("This is a warning");
    }
}
