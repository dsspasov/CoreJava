package REST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private static Map<String, Boolean> links = new HashMap<String, Boolean>();

    public static String getContent(String link) throws IOException {
        URL oracle = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream(), "UTF-8"));

        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }

    private static List<String> getAllLinks(String content, String currentLink) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String link = matcher.group(1);
            while (link.contains("../")) {
                link = link.replace("../", "");
            }
            String newLink = "";
            if (currentLink.endsWith(".html")) {
                newLink = currentLink.replace(
                        currentLink.substring(currentLink.lastIndexOf("/") + 1, currentLink.length()), "");
                resultList.add(newLink + '/' + link);
            } else {
                // System.out.println(currentLink + '/' + link);
                resultList.add(currentLink + '/' + link);
            }
        }
        return resultList;
    }

    public static void createMap(List<String> urls) {
        for (String link : urls) {
            if (!links.containsKey(link)) {
                if (link.contains("youtube")) {
                    links.put(link, true);
                } else {
                    links.put(link, false);
                }
            }

        }
    }

    public static String crawler(String currentLink, String needle) throws IOException {
        String content = getContent(currentLink);
        // System.out.println(currentLink);
        if (content.indexOf(needle) != -1) {
            links.put(currentLink, true);
            // System.out.println("1");
            return currentLink;
        } else {
            List<String> urls = getAllLinks(content, currentLink);
            // System.out.println("urls:" + urls);

            createMap(urls);

            // String newlink = "";
            // System.out.println("links:" + links);

            for (String url : links.keySet()) {
                // System.out.println("123456");
                if (links.get(url)) {
                    continue;
                } else {

                    // if (currentLink.endsWith(".html")) {
                    // newlink =
                    // currentLink.replace(currentLink.substring(currentLink.lastIndexOf("/")
                    // + 1, currentLink.length()), url);
                    // System.out.println(newlink + "-*-" + needle);
                    // links.put(currentLink, true);
                    // return crawler(newlink, needle);
                    // } else {

                    // System.out.println(url + "--" + needle);
                    links.put(url, true);
                    return crawler(url, needle);
                    // return crawler(currentLink + "/" + url, needle);
                    // }

                }
            }
            return "i could not find " + needle + "in the site";
            // return "llllll";
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            // URL link = new URL("http://ebusiness.free.bg/index.html");
            System.out.println(crawler("http://ebusiness.free.bg", "Ô.Í. 24422"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /*
         * 
         * URL oracle = new URL("http://ebusiness.free.bg"); BufferedReader in =
         * new BufferedReader( new InputStreamReader(oracle.openStream()));
         * 
         * String inputLine; while ((inputLine = in.readLine()) != null)
         * System.out.println(inputLine); in.close();
         */
    }

}
