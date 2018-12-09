import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {
	
	public static ArrayList<ArrayList<String>> readFile() throws FileNotFoundException, IOException {
		ArrayList<ArrayList<String>> storage = new ArrayList<ArrayList<String>>();
		FileReader fr= new FileReader("accounts-db.txt");    
        BufferedReader br=new BufferedReader(fr);
        String line; 
        int[] parse = {9, 4, 15, 20, 15, 8, 10, 30, 30, 2, 5, 1};
        while ((line = br.readLine()) != null){
        	int count = 0;
        	ArrayList<String> temp = new ArrayList<String>();
        	for (int i = 0; i < 12; i++) {
        		temp.add(line.substring(count, count + parse[i]));
        		count = count + parse[i];
        	} 
        	storage.add(temp);
        }
        return storage;
	}
	
	public static void writeFile(ArrayList<ArrayList<String>> database) throws FileNotFoundException, IOException{
		PrintWriter writer = new PrintWriter("accounts-db.txt");
		writer.print("");
		writer.close();
		
		FileOutputStream fos = new FileOutputStream("accounts-db.txt");
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		
        int[] parse = {9, 4, 15, 20, 15, 8, 10, 30, 30, 2, 5, 1};
        for (int x = 0; x < database.size() ; x++){
        	for (int i = 0; i < 12; i++) {
        		bw.write(database.get(x).get(i));
        	}
        	bw.newLine();
        }
	 
		bw.close();
	}
	
    public static void main(String args[])throws Exception{
    	writeFile(readFile());
    }

}
