package numjv;
import java.util.ArrayList;

/*
From XML file, import lists of data separated by columns. The first column would be x values -input-, and the second one would be y values -output.
Next, construct a hypothesis method;
Since this will only cover linear regression, we will strict the type as y=wx+b. Here, w stands for weight, and b stands for bias of the dataset.
 */

public class linreg {

    // define weight and bias
    private static double w = 1;
    private static double b = 1;

    // define differentiation vars
    private final static double dx = Math.pow(10, -10);

    // define learning rate
    private final static double LR = 0.01;

    // define getter/setter methods for hyper-parameters
    public static double getWeight() {
        return w;
    }

    public static double getBias() {
        return b;
    }

    // define linear hypothesis function in terms of y=wx+b
    public static double hypothesis(double x, double w, double b) {
        return w*x+b;
    }

    // define Mean Squared Error cost function
    public static double cost(ArrayList<Double> xData, ArrayList<Double> yData, double w, double b) {
        double result = 0;
        int n = xData.size();
        for (int i=0; i<n; i++) {
            result += Math.pow((yData.get(i) - hypothesis(xData.get(i), w, b)), 2);
        }
        result = result * (1/(double)n);
        return result;
    }

    // define gradient function
    public static void GradientDescentOptimizer(ArrayList<Double> xData, ArrayList<Double> yData, double w_pos, double b_pos) {
        double w_grads = (cost(xData, yData,w_pos+dx, b_pos) - cost(xData, yData, w_pos-dx, b_pos))/(2*dx);
        double b_grads = (cost(xData, yData, w_pos, b_pos+dx) - cost(xData, yData, w_pos, b_pos-dx))/(2*dx);
        System.out.println("Gradient of w = "+w_grads+"     Gradient of b = "+b_grads);
        w = w - w_grads*LR;
        b = b- b_grads*LR;
    }

    public static void Execute(ArrayList<Double> xData, ArrayList<Double> yData) {
        for (int j=0; j<10000; j++) {
            // update hyper-parameters
            System.out.println("====================================================");
            GradientDescentOptimizer(xData, yData, w, b);
            System.out.println(j+" th training"+"   w = "+w+"   b = "+b+"   cost = "+cost(xData, yData, w, b));
        }
        System.out.println("Final value of w = "+w);
        System.out.println("Final value of b = "+b);
    }

}