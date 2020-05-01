import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class regis extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
PrintWriter out=response.getWriter();
out.println("<html>");
out.println("<body>");
String s1=request.getParameter("un");
String s2=request.getParameter("up");
String s3=request.getParameter("ue");
String s4=request.getParameter("uc");
String s5=request.getParameter("ub");


try
{
Class.forName("com.mysql.jdbc.Driver");
String db_url="jdbc:mysql://localhost:3306/online?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false";
String db_un="root";
String db_up="root";
Connection con=DriverManager.getConnection(db_url,db_un,db_up);
Statement st=con.createStatement();
String q="insert into reg values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
st.executeUpdate(q);
response.sendRedirect("login.html");
con.close();
}
catch(Exception e)
{
	out.println(e);
}
out.println("</body>");
out.println("</html>");
out.close();
}
}
