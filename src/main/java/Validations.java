import com.google.cloud.datastore.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Validations extends HttpServlet {
    final String Admin="Harsha";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        HttpSession session= request.getSession();

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();//datastore instance

        Query<Entity> entityQuery=Query.newEntityQueryBuilder().setKind("LoginUser").build();//fetch data
        QueryResults<Entity> entityQueryResults = datastore.run(entityQuery);// store in iterator
        while(entityQueryResults.hasNext()) {
            Entity entity = entityQueryResults.next();
            String name = entity.getString("username");// get username

            if (name.equals(username)) {
                session.setAttribute("username", username);

//            KeyFactory keyFactory = datastore.newKeyFactory().setKind("LoginUser");
//
//            Entity LoginEntity = Entity.newBuilder(keyFactory.newKey(2))
//                    .set("username", username)
//                    .set("likecount",10)
//                    .build();
//            datastore.put(LoginEntity);


                out.print("Welcome " + entity.getString("username") + "You have logged in Successfully!");
                break;
            }

        }
    }
}
