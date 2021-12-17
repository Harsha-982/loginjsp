package com.loginjsp;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterCheck extends HttpServlet {
    static int count=0;
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String newUserName = request.getParameter("signUpUser");
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        String admin = "";
        Query<Entity> entityQuery = Query.newEntityQueryBuilder().setKind("LoginToLike").build();
        QueryResults<Entity> entityQueryResults = datastore.run(entityQuery);
        while (entityQueryResults.hasNext()) {
            Entity entity = entityQueryResults.next();
            admin = entity.getString("username");
            if(newUserName.equals(admin)){
                admin=admin;
                break;
            }
        }
        if(newUserName.equals(admin)){
            out.print("uerror");
        }
        out.print("");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/plain");
        String newUserName = request.getParameter("username");
        String password = request.getParameter("signUpPassword");
        String confirmPass = request.getParameter("confirm");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();//datastore instance

        KeyFactory keyFactory= datastore.newKeyFactory().setKind("LoginToLike");

        Query<Entity> entityQuery = Query.newEntityQueryBuilder().setKind("LoginToLike").build();
        QueryResults<Entity> entityQueryResults = datastore.run(entityQuery);

        String admin = "";
        while (entityQueryResults.hasNext()) {
            Entity entity = entityQueryResults.next();
            admin = entity.getString("username");
            count=count+1;
            if(newUserName.equals(admin)){
                admin=admin;
                break;
            }
        }
        if(newUserName.equals(admin)){
            out.print("uerror");
        }
        else{
            if(password.equals(confirmPass)){

                FullEntity messageEntity = Entity.newBuilder(keyFactory.newKey(++count))
                        .set("username",newUserName)
                        .set("password",password)
                        .build();
                datastore.put(messageEntity);
                datastore.delete(keyFactory.newKey(6));
                session.setAttribute("username",newUserName);
                out.print("SUCCESS");
            }
            else{
                out.print("perror");
            }
        }

    }
}
