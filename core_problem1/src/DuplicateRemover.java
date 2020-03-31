import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;



//Removes any duplicate words and stores the unique words into uniqueWords
public class DuplicateRemover {
	Set<String> uniqueWords = new HashSet<String>();
	public void remove(String dataFile) {
		try(FileInputStream fis = new FileInputStream(dataFile);
				Scanner sc = new Scanner(fis);){
			while (sc.hasNext()) {
				String word = sc.next();
				word = word.toLowerCase();
				uniqueWords.add(word);
			}
			sc.close();
			}
			catch (FileNotFoundException exc) {
	            exc.printStackTrace();
	        }catch (IOException exc) {
	            exc.printStackTrace();
	        } 
		}
//Outputs the stored data in uniqueWords into a new text file
	public void write(String outputFile) {
		try {
			BufferedWriter bwr = new BufferedWriter(new FileWriter(outputFile));
			Iterator<String> out = uniqueWords.iterator();
			while(out.hasNext()) {
				bwr.write(out.next());
				bwr.newLine();
			}
			bwr.close();
		}
		
		catch (IOException exc) {
            exc.printStackTrace();
		}
	}
}
