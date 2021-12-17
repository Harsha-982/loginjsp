package com.loginjsp;

import com.google.cloud.datastore.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LikePage extends HttpServlet
{  private static int count =0;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            PrintWriter out= response.getWriter();

            HttpSession session= request.getSession();
            String username=session.getAttribute("username").toString();

            Datastore datastore= DatastoreOptions.getDefaultInstance().getService();
            Query<Entity> entityQuery=Query.newEntityQueryBuilder().setKind("LoginToLike").build();
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
//            if(admin.equals(username) && feedback.equals("like")) {
//                if (count < 1) {
//                    count = count + 1;
//                } else if (count == 1) {
//                    count = count;
//                }
//                out.println(count);
//// out.print("You have "+(likecount-count)+" more likes");
//            }
//            else if (admin.equals(username) && feedback.equals("disLike")) {
//                if (count < 1) {
//                    count = count;
//                } else if (count == 1) {
//                    count = count - 1;
//                }
//                out.println(count);
//            }

            if(admin.equals(username)){
                if(count<1){
                    count=count+1;
                }
                else if(count==1){
                    count=count-1;
                }
                out.print(count);
            }
    }
}
