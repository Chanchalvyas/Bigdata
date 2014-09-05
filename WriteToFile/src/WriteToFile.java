
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public static void main(String args[]) throws IOException{
		try{
		// Create file
		FileWriter fstream = new FileWriter("/home/chanchal/test2");
		BufferedWriter out = new BufferedWriter(fstream);
		for(int i = 1;i<10000;i++){
		//out.write("Hello Hadoop"+"\n"+"what is the Activity we are planning for today"+"\n");
			out.write("Hello Hadoop,"+"what is the Activity we are planning for today"+"\n");
		//Close the output stream
		}
		out.close();
		}catch (Exception e){//Catch exception if any
		System.err.println("Error: " + e.getMessage());
		
		}
}
}