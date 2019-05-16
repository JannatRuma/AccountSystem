import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {
	BufferedReader br;
	File f = new File("input.txt");

	void load() {
		try {
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String readFile() {

		String s = null;
		try {

			s = br.readLine();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
