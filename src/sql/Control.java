package sql;

import numjv.ndarray;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Control {
    public static void main(String[] args) {
        DBA t = new DBA();
        double[] x = numjv.ndarray.linspace(0, 2*ndarray.pi, 100);
        System.out.println(Arrays.toString(x));
        double[] y = numjv.ndarray.sin(x);
        t.tableCreate(); // 테이블 리셋
        for (int i=0; i<x.length; i+=1) {
            t.tableInsert("chart", x[i], y[i]);
        }
        System.out.println("chart 데이터 수정 : 성공");

        // Web page Loading
        try {
            Desktop.getDesktop().browse(new URI("http://localhost/index.php"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
