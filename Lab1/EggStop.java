
public class EggStop {
    public static void main(String[] args){
        tegg();
        begg();
        System.out.println();
        tegg();
        begg();
        sym();
        System.out.println();
        tegg();
        stop();
        begg();
        sym();
    }
    
    public static void tegg() {
        System.out.println("  ______");
        System.out.println(" /      \\");
        System.out.println("/        \\");
    }
    
    public static void begg() {
        System.out.println("\\        /");
        System.out.println(" \\______/");
    }
    
    public static void sym() {
        System.out.println("+--------+");
    }
    
    public static void stop() {
        System.out.println("|  STOP  |");
    }
}
