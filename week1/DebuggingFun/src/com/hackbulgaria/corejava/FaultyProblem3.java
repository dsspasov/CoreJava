package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        StringBuilder x = new StringBuilder();
        for (String word: words){
            
            x.append(reverse(word) + " ");
            //sentence = sentence.replace(word, reverse(word));
        }
        return x.toString().trim();
        //return sentence;
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
