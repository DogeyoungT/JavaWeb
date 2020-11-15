<%--
  Created by IntelliJ IDEA.
  User: Iray
  Date: 2017/7/10
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>约吧Together登录</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function signUp(){
//            self.location="register.jsp";
            window.location="/register.jsp";
        }
        function load(){
            $("#myCarousel").carousel('cycle');
        }
    </script>
    <style type="text/css">
        .input-group-lg{
            margin-bottom: 5px;
        }
    </style>
</head>
<body onload="load()">
<div id="myCarousel" data-interval=6000 class="carousel slide" style="z-index:-1;position: absolute;height: 800px;">
    <element></element>
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
        <li data-target="#myCarousel" data-slide-to="5"></li>
        <li data-target="#myCarousel" data-slide-to="6"></li>
        <li data-target="#myCarousel" data-slide-to="7"></li>
        <li data-target="#myCarousel" data-slide-to="8"></li>
        <li data-target="#myCarousel" data-slide-to="9"></li>
        <li data-target="#myCarousel" data-slide-to="10"></li>
    </ol>

    <div class="carousel-inner">
        <div class="item active">
            <img src="Resource/bg/32.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="Resource/bg/1.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="Resource/bg/2.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="Resource/bg/6.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="Resource/bg/9.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="Resource/bg/20.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="Resource/bg/23.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="Resource/bg/29.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="Resource/bg/31.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="Resource/bg/41.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="Resource/bg/43.jpg" alt="Third slide">
        </div>
    </div>

</div>

<div class="container" >
    <div class="row" style="margin: 10% auto">
        <div class="col-md-3">
        </div>
        <div class="col-md-6" style="background-color: rgba(86,83,76,0.35);
            box-shadow: inset 1px -1px 1px rgba(208,214,192,0.6), inset -1px 1px 1px rgba(208,214,192,0.61);">
            <div calss = "head">
                <img src="Resource/logo.png" style="padding: 30px 60px 20px;" >
            </div>
        <div style="padding: 30px 100px 10px;">

        <form name="login" class="form-horizontal" action="/Login" method="post">
            <div class="input-group-lg">
            <input type="text" name="username" class="form-control" placeholder="Username" >
            </div>
                <div class="input-group-lg">
            <input type="password"  name ="password" class="form-control" placeholder="Password">
            </div>
            <br>
            <br>
            <div class="input-group-lg">
            <button type="submit" class="btn btn-success btn-lg btn-block" name="submitButton">LOGIN</button>
            <button type="button" class="btn btn-primary btn-lg btn-block" name="signUpButton" onclick="signUp()">SIGN UP</button>
            </div>
        </form>
    </div>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>
</body>
</html>
