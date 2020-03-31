package core_problem2;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


//counts the amount of unique words and stores it into wordCounter
public class DuplicateCounter {
	HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
	public void count(String dataFile) {
		try(FileInputStream fis = new FileInputStream(dataFile);
				Scanner sc = new Scanner(fis);){
			while (sc.hasNext()) {
				String word = sc.next();
				word = word.toLowerCase();
				if(wordCounter.containsKey(word)) {
					int number = wordCounter.get(word);
					wordCounter.put(word, number + 1);
				}
				else {
					wordCounter.put(word, 1);
				}
			}
			sc.close();
			}
		catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }catch (IOException exc) {
            exc.printStackTrace();
        } 
	}
	public void write(String outputFile) {
		//Outputs the stored data in wordCounter into a new text file
		try{
			BufferedWriter bwr = new BufferedWriter(new FileWriter(outputFile));
			for(Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
				bwr.write(entry.getKey() + ":" + entry.getValue());
				bwr.newLine();
			}
			bwr.close();
		}
		catch (IOException exc) {
            exc.printStackTrace();
		}
	}
}

