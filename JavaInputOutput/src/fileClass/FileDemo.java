package fileClass;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] agrs) {
		File f = new File("mytex.txt");
//		try {
//			if(f.createNewFile()) {
//				FileWriter fr = new FileWriter(f);
//				fr.write("this is java file");
//				fr.close();
//			}
//			else {
//				System.out.println("File is existed");
//				FileWriter fr = new FileWriter(f);
//				fr.write("this is java file");
//				fr.close();
//			}
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		
		
		
		
		
		f.delete();
		System.out.println(f.getName()+ "Deleted");
		System.out.println(f.getPath());
	}
}
