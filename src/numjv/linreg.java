package numjv;
import java.util.ArrayList;

public final class linreg {

    public static final double pi = 3.14;

    public static double[] linspace(double start, double stop, double num) {
        ArrayList<Double> list = new ArrayList<>();
        double inv = Math.abs(stop-start)/num;
        if (stop > start) {
            for (double i=start; i<=stop; i+=inv) {
                list.add(i);
            }
        } else if (start > stop) {
            for (double i=start; i>=stop; i-=inv) {
                list.add(i);
            }
        }
        return list.stream().mapToDouble(i -> i).toArray();
    }

    public static double[] tan(double[] x) {
        double[] y = new double[x.length];
        for (int i=0; i<x.length; i++) {
            y[i]=Math.tan(x[i]);
        }
        return y;
    }

    public static double[] sin(double[] x) {
        double[] y = new double[x.length];
        for (int i=0; i<x.length; i++) {
            y[i]=2*Math.sin(x[i])+1;
        }
        return y;
    }
}
