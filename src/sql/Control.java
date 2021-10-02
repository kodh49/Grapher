package sql;

import numjv.linreg;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

            public class Control {

                static ArrayList<Double> xData = Stream.of(50.1, 48.3, 45.2, 44.7, 44.5, 42.7, 39.5, 38.0).collect(Collectors.toCollection(ArrayList::new));
                static ArrayList<Double> yData = Stream.of(178.5, 173.6, 164.8, 163.7, 168.3, 165.0, 155.4, 155.8).collect(Collectors.toCollection(ArrayList::new));

                public static void main(String[] args) {
                    DBA t = new DBA();
                    // start linear regression
                    linreg.Execute(xData, yData);
                    t.tableCreate(); // 테이블 리셋
                    System.out.print("chart 테이블 접속 : ");
                    for (int i=0; i<xData.size(); i+=1) {
                        t.tableInsert("chart", xData.get(i), linreg.hypothesis(xData.get(i), linreg.getWeight(), linreg.getBias()));
                    }
                    System.out.print("성공");

                    // Web page Loading
                    try {
            Desktop.getDesktop().browse(new URI("http://localhost/index.php"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
