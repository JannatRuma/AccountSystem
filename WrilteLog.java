import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WrilteLog {
	void writer(String s) {
		File f = new File("log.txt");
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			s=dtf.format(now)+"  :  "+s;
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(s);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
