import java.io.*;
import java.util.*;

public class Reader{

  public final static int Default_Capacity = 256; //Max ASCII chars
	private BufferedReader textReader;
	private String fileText;

	public Reader(String file){
		try{
			textReader = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e){
			System.out.println("File failed to open");
		}finally{
        try{
        String str = "";
        String line;
        while((line = textReader.readLine()) != null){
          str = str + line;	
        }
        fileText = str;
        }catch(IOException e){
          System.out.println("Reading Error");
        }
	  }
  }

  public String getFileText(){
    return fileText;
  }
}