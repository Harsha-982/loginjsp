import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Validations extends HttpServlet {
    final String Admin="Harsha";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        if(Admin.equals(username)){

            KeyFactory keyFactory = datastore.newKeyFactory()
                    .setKind("LoginUser");
            Entity LoginEntity = Entity.newBuilder(keyFactory.newKey(1))
                    .set("username", username)
                    .build();
            datastore.put(LoginEntity);

            Entity entity=datastore.get(keyFactory.newKey(1));
            out.print("Welcome "+entity.getString("username")+"You have logged in Successfully!");
        }
        else{
             out.print("error");
        }


    }
}
