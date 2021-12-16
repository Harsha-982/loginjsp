$(document).ready(function (){
    $("#image").hide();
    $("#signUpForm").hide();

    $("#SignUp").on("click", function (){
        $("#form").hide();
        $("#signUpForm").show();
        $("#image").hide();
        $("a").hide();
    });
    $("a").on("click", function (){
        $("#form").show();
        $("#signUpForm").hide();
    });

    $("#signUpUser").on("blur",function (){
        var signUpUser = $("#signUpUser").val();
       $.ajax({
           type:'GET',
           url:'registerCheck',
           data:{
               'signUpUser' :signUpUser
           },
           success:function (data){
               if(data=="uerror"){
                   alert("Username has already exist!! please enter another name");
               }
           }
       })
       }) ;
    });

    $("#Register").on("click", function () {
            var signUpPassword =$('#signUpPassword').val();
            var confirm = $('#confirm').val();
            var signUpUser = $("#signUpUser").val();
            var user = document.getElementById('signUpUser').value;
            var pass = document.getElementById('signUpPassword').value;
            var confirmPass = document.getElementById('confirm').value;

            if (user == "" ||  pass == "" || confirmPass == "") {
                alert("Username and Password should not be empty!!");
            } else {
                $.ajax({
                    type: 'POST',
                    url: 'registerCheck',
                    data: {
                        'signUpPassword': signUpPassword,
                        'confirm': confirm,
                        'username': signUpUser
                    },
                    success: function (data) {
                        if (data == "uerror") {
                            $("#result").html("Username is already exists please enter other one..");
                        }
                        else if (data == "perror") {
                            $("#result").html("Password Mismatch");
                        } else {
                            alert("You have been registered Successfully!!! Redirecting you to the home page")
                            $("#form").hide();
                            $("#signUpForm").hide();
                            $("#image").show();
                            $("#Likebutton").on("click", function () {
                                $.ajax({
                                    type: 'GET',
                                    url: 'like',
                                    success: function (data) {
                                        if (data == 1) {
                                            $("p").html(data);
                                            document.getElementById("Likebutton").style.backgroundColor = "blue";
                                        }
                                        if (data == 0) {
                                            $("p").html(data);
                                            document.getElementById("Likebutton").style.backgroundColor = "red";
                                        }
                                    }
                                })

                            });
                        }
                    }
                });
            }
        });
// our login call reaches her on clicking on the "Login" button
    $("#btnSubmit").click(function (){
        $("a").hide();
        var username =$('#username').val();
        var password=$('#password').val();

        if (username==null || username=="" || password==null || password==""){
            alert("Username and Password should not be empty!!");
        }
        else {

            $.ajax({
                type: 'POST',
                url: 'validate',
                data: {
                    'username': username,
                    'password': password
                },
                success: function (data) {
                    if (data == "error") {
                        alert("Username or Password is wrong!!!")

                    } else {
                        $("#form").hide();
                        $("#result").html(data);
                        $("#image").show(data);

                        $("#Likebutton").on("click", function () {
                            $.ajax({
                                type: 'GET',
                                url: 'like',
                                success: function (data) {
                                    if (data ==1) {
                                        $("p").html(data);
                                        document.getElementById("Likebutton").style.backgroundColor="blue";
                                    }
                                    if(data ==0){
                                        $("p").html(data);
                                        document.getElementById("Likebutton").style.backgroundColor="red";
                                    }
                                }
                            })

                        });
                        // $("#disLikebutton").on("click", function () {
                        //     var dislike = $("#disLikebutton").val();
                        //     $.ajax({
                        //         type: 'GET',
                        //         url: 'like',
                        //         data: {"feedback": dislike},
                        //         success: function (data) {
                        //             if (data != "error") {
                        //                 $("p").html(data);
                        //             }
                        //         }
                        //     })
                        //
                        // });

                    }
                }
            });
        }
});