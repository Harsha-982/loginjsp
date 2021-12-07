
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"type="text/javascript"></script>
  </head>
  <body>
  <span id="result"></span>
  <span id="status"> </span>
<div id ="form">
      Username : <input type="text" id="username"><br>
      Password : <input type="text" id="password"><br>
      <button type="button" id="btnSubmit">Login</button>
</div>
  <div id="image">
      <img src="5342169.jpg" style="width:400px; height: 260px">
      <input type="button" id="Likebutton" value="Like"><p><br></p>
  </div>
  </body>
<script>
    $(document).ready(function (){
        alert("document loaded")
        $("#image").hide();
        $("#btnSubmit").click(function (){
            alert("request to validate")
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
                       $("#result").html("Username or Password is wrong");

                   }
                   else{
                       alert("validation successful")
                       $("#form").hide();
                       $("#result").html(data);
                       $("#image").show(data);
                       $("#Likebutton").on("click", function (){
                           alert("like button has been clicked")
                           $.ajax({
                               type : 'GET',
                               url : 'like',
                               success : function(data){
                                   if(data!="error"){
                                       $("p").html(data);
                                   }
                               }
                           })

                       });

                   }
               }
           });
       });
        /*$("#Likebutton").on("click", function (){
            $.ajax({
                type : 'GET',
                url : 'like',
                success : function(data){
                    if(data!="error"){
                        $("p").html(data);
                    }
                }
            })

        });*/
    });
</script>

</html>
