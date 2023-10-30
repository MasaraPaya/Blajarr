 public class DemoConv {

    public static double convCM(double mm) {
        return mm / 10.0;
    }

    public static double convMM(double cm) {
        return cm * 10.0;
    }

    public static void dispConv(double value, String fromUnit, String toUnit, double result) {
        System.out.printf("%.2f %s = %.2f %s\n", value, fromUnit, result, toUnit);
    }

    public static void main(String[] args) {
        double value = 20;
        double cmValue = convCM(value);
        dispConv(value, "mm", "cm", cmValue);

        double mmValue = convMM(cmValue);
        dispConv(cmValue, "cm", "mm", mmValue);
    }
}
