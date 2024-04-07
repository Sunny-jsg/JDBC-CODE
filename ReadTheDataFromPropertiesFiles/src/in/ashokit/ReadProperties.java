package in.ashokit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.print.DocFlavor.INPUT_STREAM;

public class ReadProperties {
	public static void main(String[] args) throws Exception {

		File f = new File("db.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		String uname = p.getProperty("db.username");
		String pwd = p.getProperty("db.pwd");
		System.out.println(uname);
		System.out.println(pwd);
		fis.close();

	}
}
