package wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCountResult {
    private int lines;
    private int words;
    private int characters;
    private File file;
    
    WordCountResult(){
        this.file = null;
        this.lines = 0;
        this.words = 0;
        this.characters = 0;
    }
    
    WordCountResult(File file){
        this.file = file;
        this.lines = 0;
        this.words = 0;
        this.characters = 0;
    }
    public int getLineCount(){
        
        return lines;
        
    } //returns number of lines
    public int getWordCount(){
        return words;
    } 
    //returns number Of words in File
    public int getCharacterCount(){
        return characters;
    }//returns number of characters in the file.
    
    public void readFile() throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String currentLine;
        StringBuilder string = new StringBuilder();
        while ((currentLine = bf.readLine()) != null) {
            string.append(currentLine);
            this.lines++;
        }

        bf.close();
        this.words = string.toString().split(" ").length;
        this.characters = string.toString().toCharArray().length;
        
    }
    
}
