package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class ServletJson
 */
public class ServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletJson() {
		// TODO Auto-generated constructor stub
	}
	
	// Exemplo e de requisicao post usando o arduino
	// "http://192.168.43.213:8080/JsonServletPost/ServletJson "
	// "{\"data1\":\"teste\",\"data2\":\"120\"

	protected void processRequestPost1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		BufferedReader reader = request.getReader();
		String buff = reader.readLine();
		System.out.println(buff);

		JSONObject my_obj = new JSONObject(buff);

		String data1 = my_obj.getString("data1");
		String data2 = my_obj.getString("data2");

		System.out.println("data1: " + data1);
		System.out.println("data2: " + data2);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		processRequestPost1(request, response);
		response.getWriter().append("JSon processado !");
	}
}
