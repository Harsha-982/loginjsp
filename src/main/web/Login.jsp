
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"type="text/javascript"></script>
  </head>
  <body>
  <span id="result"> </span>
<div id ="form">
      Username : <input type="text" id="username"><br>
      Password : <input type="text" id="password"><br>
      <button type="button" id="btnSubmit">Login</button>
</div>
  </body>
<script>
    $(document).ready(function (){
       $("#btnSubmit").click(function (){
           var username =$('#username').val();
           var password=$('#password').val();
           $.ajax({
               type :'POST',
               url:'validate',
               data:{ 'username' : username ,
                   'password' : password
               },
               success: function (data){
                   if(data=="error"){
                       $("#result").html("Username or Password is wrong ");
                   }
                   else{
                       $("#form").hide();
                       $("#result").html(data);
                   }
               }
           });
       });
    });
</script>

</html>
