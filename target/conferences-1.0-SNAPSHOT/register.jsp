<%--
  Created by IntelliJ IDEA.
  User: mejlk
  Date: 8/17/2021
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
    <div>
        <h1>User Register Form</h1>
        <form action="<%= request.getContextPath() %>/Servlet" method="post">
            <table style="width: 80%">
                <tr>
                    <td>Username</td>
                    <td><label>
                        <input type="text" name="username" />
                    </label></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><label>
                        <input type="text" name="email" />
                    </label></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><label>
                        <input type="text" name="password" />
                    </label></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
