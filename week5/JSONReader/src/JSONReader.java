

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class JSONReader
 */
@WebServlet("/JSONReader")
public class JSONReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONReader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        String jsonURL = request.getParameter("json");	        
	        String result = getContent(jsonURL);
	        
/*	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	       // Gson gson = new Gson();
	        JsonParser jp = new JsonParser();
	        JsonElement je = jp.parse(result);
	        String prettyJsonString = gson.toJson(je);
	        response(response, prettyJsonString);*/
	       
	        response(response, result);
	}
	
	private void response(HttpServletResponse resp, String msg)
            throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<t1>" + msg + "</t1>");

        out.println("</body>");
        out.println("</html>");
    }

    public String getContent(String link) throws IOException {
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

}
