package calculator;


import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private LinkedList<Pattern> tokenRegex;
    private LinkedList<String> tokens;
    public Tokenizer() {
        this.tokenRegex = new LinkedList<Pattern>();
        this.tokens = new LinkedList<String>();
    }


    private void add(String regex) {
        tokenRegex.add(Pattern.compile("^(" + regex + ")"));
    }

    private void createExpressionTokenizer() {
        this.add("[+-]");
        this.add("[*/]");
        this.add(",");
        this.add("(sin|cos|tg|cotg|log|pow|sqrt)");
        this.add("\\(");
        this.add("\\)");
        this.add("\\d+");
        this.add("(pi|PI|e|E)");
    }

    public String[] tokenize(String input) {
        this.createExpressionTokenizer();
        String s = input.trim();
        while (!s.equals("")) {
            boolean match = false;
            for (Pattern info : tokenRegex ) {
                Matcher m = info.matcher(s);
                boolean x= m.find();
                if (x) {
                    match = true;
                    String tok = m.group().trim();
                    s = m.replaceFirst("").trim();
                    tokens.add(tok);
                    break;
                }
            }
            if (!match) 
            {
                throw new IllegalArgumentException("Unexpected character in input");
            }
        }
        String[] x = new String[tokens.size()];
        return tokens.toArray(x);
    }
}
