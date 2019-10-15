<%--
  Created by IntelliJ IDEA.
  User: OY
  Date: 10/15/2019
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileupload</title>
</head>
<body>
<h4>File Upload</h4>
<form action="upload" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Please select the uploaded file:</td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="upload"></td>
        </tr>
    </table>
</form>
</body>
</html>
