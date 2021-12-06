import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Validations extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");

        if(username.equals("Harsha")){
           out.print(username+ " you have logged in succesfully ");
        }
        else{
            out.print("error");
        }
    }
}
