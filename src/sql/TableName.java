package sql;

public class TableName {
    double xval;
    double yval;

    // Constructor
    public TableName() {}

    public TableName(double xval, double yval) {
        super();
        this.xval = xval;
        this.yval = yval;
    }

    public double getXval() {
        return xval;
    }

    public void setXval(double xval) {
        this.xval = xval;
    }

    public double getYval() {
        return yval;
    }

    public void setYval(double yval) {
        this.yval = yval;
    }
}
