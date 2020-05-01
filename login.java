import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class login extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
PrintWriter out=response.getWriter();

String s1=request.getParameter("un");
String s2=request.getParameter("up");



try
{
Class.forName("com.mysql.jdbc.Driver");
String db_url="jdbc:mysql://localhost:3306/online?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false";
String db_un="root";
String db_up="root";
Connection con=DriverManager.getConnection(db_url,db_un,db_up);
Statement st=con.createStatement();
String q="select * from reg where name='"+s1+"' AND pass='"+s2+"'";
ResultSet rs=st.executeQuery(q);
if(rs.next())
{
	response.sendRedirect("exam.html");
}
else
{
	out.println("<html><body>alert('Incorrect Password and username')</body></html>");
}
con.close();
}
catch(Exception e)
{
	out.println(e);
}
//out.println("</body>");
//out.println("</html>");
out.close();
}
}
