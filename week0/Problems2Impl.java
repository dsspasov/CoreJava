package com.hackbulgaria.corejava;

import java.util.Arrays;
import java.lang.String;
import java.lang.StringBuilder;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        if (number % 2 == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        } else if (number % 2 == 0 || number % 3 == 0 || number == 1) {
            return false;
        } else {
            for (int i = 5; i * i <= number; i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int min(int... array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        } else {
            Arrays.sort(array);
            return array[0];
        }

        /*
         * if (length == 0) { return 0; } else if (length == 1) { return
         * array[0]; } else { int min = array[0]; for (int i = 1; i < length;
         * i++) { if (array[i] < min) { min = array[i]; } } return min; }
         */
    }

    @Override
    public int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k - 1];
        // return 0;
    }

    @Override
    public float getAverage(int[] array) {
        int length = array.length;
        float sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
        }
        float result = (sum / length);
        return result;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        long result = 1;

        for (int i = 2; i <= upperBound; i++) {
            if (result % i != 0) {
                if (isPrime(i)) {
                    result *= i;
                } else {
                    long tempResult = result;
                    int end = i;
                    for (int factor = 2; factor <= end; factor++) {
                        while ((end % factor == 0) && (tempResult % factor == 0)) {
                            end /= factor;
                            tempResult /= factor;
                        }
                        if (tempResult % factor != 0) {
                            result *= end;
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public long getLargestPalindrome(long N) {
        for(; N>=1; N--){
            if(isPalindrome(Long.toString(N))){
                return N;
            }else{
                continue;
            }
        }
        return 0;
    }

    @Override
    public int[] histogram(short[][] image) {
        int[] result = new int[256];
        for (short row = 0; row < image.length; row++) {
            for (short col = 0; col < image[row].length; col++) {
                short index = image[row][col];
                result[index]++;
            }
        }
        return result;
    }

    @Override
    public long doubleFac(int n) {
        byte i = 0;
        long fact = n;
        while (i < 2) {
            for (long start = fact - 1; start > 1; start--) {
                fact *= start;
            }
            i++;
        }
        return fact;
    }

    @Override
    public long kthFac(int k, int n) {
        long fact = 1;
        if (n <= k) {
            return n;
        } else {
            for (long start = n; start >= k + 1; start = start - k) {
                fact = fact * start;
            }
            return fact;
        }
    }

    @Override
    public int getOddOccurrence(int[] array) {
        Arrays.sort(array);
        int length = array.length;
        short count = 1;
        int currentOddElement = array[0];
        for (short i = 1; i < length; i++) {
            while (array[i] == currentOddElement && i < length) {
                count++;
                i++;
            }
            if (count % 2 == 0) {
                currentOddElement = array[i];
                count = 1;
            } else {
                break;
            }
        }
        return currentOddElement;
    }

    @Override
    public long pow(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b % 2 == 0) {
            long aToHalfb = pow(a, b / 2);
            return aToHalfb * aToHalfb;
        }
        return a * pow(a, b - 1);
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result + a[i] * b[i];
        }
        return result;
    }

    @Override
    public int maxSpan(int[] array) {
        int bestSpan = 0;
        int currentSpan = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int j = length - 1;
            while (j >= i) {
                if (array[i] == array[j]) {
                    currentSpan = j - i + 1;
                    break;
                }
                j--;
            }
            if (currentSpan > bestSpan) {
                bestSpan = currentSpan;
                currentSpan = 0;
            }
        }
        return bestSpan;
    }

    @Override
    public boolean canBalance(int[] array) {
        int leftSum = 0;
        int sum = 0;
        int i = 0;
        int length = array.length;
        for (; i < length; i++) {
            sum += array[i];
        }
        if (sum % 2 == 0) {
            i = 0;
            while (leftSum != sum / 2 && i < length) {
                leftSum += array[i];
                i++;
            }
            if (leftSum == sum / 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int originalWidth = original[0].length;
        int originalHeight = original.length;

        int stepX = originalWidth / newWidth;
        int stepY = originalHeight / newHeight;

        int[][] newImage = new int[newHeight][newWidth];

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                newImage[y][x] = original[y * stepY][x * stepX];
            }
        }
        return newImage;
    }

    @Override
    public String reverseMe(String argument) {
        StringBuilder string = new StringBuilder();
        string.append(argument);
        return string.reverse().toString();

        /*
         * int length = argument.length(); StringBuilder string = new
         * StringBuilder(); for(int i = 0; i<length; i++){
         * string.append(argument.charAt(i)); } return
         * string.reverse().toString();
         */

        /*
         * int length = argument.length(); StringBuilder reversedString = new
         * StringBuilder(); char[] argumentArray = argument.toCharArray();
         * for(int index = length - 1; index >= 0; index--){
         * reversedString.append(argumentArray[index]); } return
         * reversedString.toString();
         */
    }

    @Override
    public String copyEveryChar(String input, int k) {
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            for(int j = 1; j<= k; j++){
                newString.append(input.charAt(i));
            }
        }
        return newString.toString();
    }

    @Override
    public String reverseEveryWord(String arg) {
        String[] arrayOfWords = arg.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (int i = 0; i < arrayOfWords.length; i++) {
            reversedString.append(reverseMe(arrayOfWords[i]) + " ");
        }
        return reversedString.toString().trim();
    }

    @Override
    public boolean isPalindrome(String argument) {
        int length = argument.length();
        String firstPart;
        String secondPart;
        if(length % 2 != 0){
            firstPart = argument.substring(0, length / 2);
            secondPart = argument.substring(length / 2 + 1, length);
        }
        else{
            firstPart = argument.substring(0, length / 2);
            secondPart = argument.substring(length / 2, length);
        }
        firstPart = reverseMe(firstPart);
        if (firstPart.equals(secondPart)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPalindrome(int number) {
        String arg = Integer.toString(number);
        if (isPalindrome(arg)){
            return true;
        }
        return false;
    }

    @Override
    public int getPalindromeLength(String input) {
        int asterixIndex = input.indexOf('*');
        int length = input.length();
        int i = 0;
        while(input.charAt(asterixIndex - i)==input.charAt(asterixIndex + i) && i < length/2){
            i++;
        }
        if(input.charAt(asterixIndex - i)!=input.charAt(asterixIndex + i)){
            return i-1;
        }
        return i;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {

        return (haystack.length() - haystack.replace(needle, "").length()) / needle.length();
    }

    @Override
    public String decodeURL(String input) {
        String result = input.replaceAll("%20", "").replaceAll("%3A", ":").replaceAll("%3D", "?").replaceAll("%2F", "/");
        return result;
    }

    @Override
    public int sumOfNumbers(String input) {
        String[] y= input.split("[^0-9-]");
        int sum = 0;
        for(int i = 0; i<y.length; i++){
            if(!y[i].equals("")){
                sum += Integer.parseInt(y[i]);                
            }
        }
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        A = A.replace(" ", "");
        B = B.replace(" ", "");
        if(A.length() != B.length()){
            return false;
        }
        StringBuilder x = new StringBuilder();
        for(int i = 0; i<A.length(); i++){
            x.append(A.charAt(i));
            for(int j = 0; j<B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    x.deleteCharAt(0);
                    break;
                }
            }
        }
        if(x.length() == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
       int argument1Length = string.length();
       int argument2Length = string2.length();
       int index = 0;
       while(index <= (argument2Length - argument1Length)){
           String sub = string2.substring(index, (index + argument1Length));
           if(areAnagrams(string, sub)){
               return true;
           }
           else{
               index++;
           }
       }
       return false;
    }
}
