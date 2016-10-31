<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 10/28/16
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        td, th {
            border: 2px solid ;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(odd){
            background: saddlebrown;
        }
        tr:nth-child(even) {
            background-color: sandybrown;
        }
    </style>
</head>
<body background="https://s-media-cache-ak0.pinimg.com/originals/04/e0/34/04e034bf76ff7130e40f5e5f4dbb9a04.jpg">
<center><h1><u><b><font face="Century Gothic">Create Your Character</font></b></u></h1></center>
<br>
<br>
<center><img src="http://i.skyrock.net/0223/59080223/pics/2386606377_small_1.jpg"></center>
<br>
<center><table border="2" >
    <tr><th>Name</th><th>Class</th><th>Level</th></tr>
    <c:forEach items="${Sheet}" var="aSheet">
    <tr>
        <td scope="row"><c:out value="${aSheet.name}"/></td>
        <td><c:out value="${aSheet.aClass}"/></td>
        <td><c:out value="${aSheet.level}"/></td>
        </c:forEach>
    </tr>
</table>
</center>
<center><a href="/character/skills">Skills</a></center>
</body>