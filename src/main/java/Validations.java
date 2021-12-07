import com.google.cloud.datastore.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Validations extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");

        HttpSession session= request.getSession();
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();//datastore instance

        Query<Entity> entityQuery=Query.newEntityQueryBuilder().setKind("LoginUser").build();
        QueryResults<Entity> entityQueryResults = datastore.run(entityQuery);

        String admin="";
        while(entityQueryResults.hasNext()) {
            Entity entity = entityQueryResults.next();
            admin = entity.getString("username");
            if (admin.equals(username)) {
                admin = admin;
                break;
                }
            }
        if (admin.equals(username)) {
            session.setAttribute("username", username);
            out.print("Welcome " + admin + "You have logged in Successfully!");
        }
        else{
            out.print("error");
        }
    }
}
