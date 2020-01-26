package sql;

public class Control {
    public static void main(String[] args) {
        DBA t = new DBA();
        double[] x = {9.1, 2.2, 4.3, 10.2, 7.08, 0.12, 8.93, 5.12, 1.817, 6.28};
        double[] y = {1.9, 4.2, 20.1, 47.2, 1.28, 8.62, 4.19, 8.15, 7.80, 3.14};
        t.tableCreate(); // 테이블 리셋
        for (int i=0; i<x.length; i++) {
            t.tableInsert("chart", x[i], y[i]);
        }
        t.tableSelect("chart");
    }
}
