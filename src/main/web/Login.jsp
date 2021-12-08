
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"type="text/javascript"></script>
  </head>
  <body>
  <span id="result"></span>

  <div id ="signUpForm">
      Username : <input type="text" id="signUpUser"><br>
      Password : <input type="text" id="signUpPassword"><br>
      Confirm Password : <input type="text" id="confirm">
      <button type="button" id="Register">SignUp</button>
  </div>
     <a href="#">Return to home page</a>


<div id ="form" name="myform">
      Username : <input type="text" id="username" name="user"><br>
      Password : <input type="text" id="password" name="pass"><br>
      <button type="button" id="btnSubmit">Login/SignIn</button><br>
      <button type="button" id="SignUp">SignUp</button>
</div>
  <div id="image">
      <img src="5342169.jpg" style="width:400px; height: 260px"><br>
      <input type="button" id="Likebutton" value="like">
      <input type="button" id="disLikebutton" value="disLike"><br>
      <p></p>
  </div>
  </body>
  <script src="validations.js"></script>
  <script src="loginOrSignup.js" ></script>

</html>
