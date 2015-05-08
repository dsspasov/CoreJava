/*You can do :

1) javac -cp /path/to/jar/file Myprogram.java

2) java -cp .:/path/to/jar/file Myprogram

So, lets suppose your current working directory in terminal is src/Report/

javac -cp src/external/myfile.jar Reporter.java

java -cp .:src/external/myfile.jar Reporter


/********************************************************************************/
/*
String pathToFile = C:/Users/user/Documents/eclipse/Week4/src/Jtoaster.java

javac -cp "../lib/JavaSyntaxHighlighter-1.2.0/JavaSyntaxHighlighter-1.2.0.jar" QuickCodeInspector.java
java -cp ".;../lib/JavaSyntaxHighlighter-1.2.0/JavaSyntaxHighlighter-1.2.0.jar" QuickCodeInspector pathToFile
*/

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.brush.*;
import syntaxhighlighter.SyntaxHighlighterParser;
//import syntaxhighlighter.theme.ThemeRDark;
import syntaxhighlighter.theme.*;

public class QuickCodeInspector {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // the SyntaxHighlighter parser
                SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushXml());
                // turn HTML script on
                parser.setHtmlScript(true);
                // set HTML Script brushes
                parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp()));

                // initialize the highlighter and use RDark theme
                SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeMidnight());
                // set the line number count from 10 instead of 1
                highlighter.setFirstLine(10);
                // set to highlight line 13, 27, 28, 38, 42, 43 and 53
                highlighter.setHighlightedLineList(Arrays.asList(12, 13, 27, 28, 38, 42, 43, 53));
                try {
                    highlighter.setContent(new File(args[0].toString()));
                } catch (IOException ex) {
                    Logger.getLogger(QuickCodeInspector.class.getName()).log(Level.SEVERE, null, ex);
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(highlighter);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
