package origin.util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleIO {
    public static final String DATA_PATH = "C:\\Users\\Administrator\\Desktop\\zhengxin\\" +
            "vfgs_origin_data\\shenzhen\\szScore.txt";
    public static final String OUT_PATH = "C:\\Users\\Administrator\\Desktop\\zhengxin\\" +
            "vfgs_origin_data\\shenzhen\\sz_score.txt";

    public static void main(String[] args) throws IOException {
        File theFile = new File(DATA_PATH);
        LineIterator it = FileUtils.lineIterator(theFile, "UTF-8");
        int cnt = 0;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUT_PATH));
            it.nextLine();      // skip first line
            while (it.hasNext()) {
                writer.write(it.nextLine());
                writer.newLine();
                cnt++;
            }
            writer.close();
        } finally {
            LineIterator.closeQuietly(it);
            System.out.println(cnt);
        }
        System.out.println("Processing done");
    }
}
