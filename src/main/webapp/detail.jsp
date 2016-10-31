<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 10/27/16
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
<center><h1><u><b><font face="Century Gothic">Character Stats</font></b></u></h1></center>

</table>
<center><table border="1" >
    <tr><td>constitution</td><td>strength</td><td>agility</td><td>intelligence</td><td>luck</td></tr>
    <c:forEach items="${Skill}" var="aSkill">
    <tr>
        <td  scope="row"><c:out value="${aSkill.constitution}"/></td>
        <td><c:out value="${aSkill.strength}"/></td>
        <td><c:out value="${aSkill.agility}"/></td>
        <td><c:out value="${aSkill.intelligence}"/></td>
        <td><c:out value="${aSkill.luck}"/></td>
        </c:forEach>
        <br>
        <br>
        <table border="2"class="table" >
            <tr><th>Name</th><th>class</th><th>level</th></tr>
            <c:forEach items="${Sheet}" var="aSheet">
            <tr>
                <td scope="row"><c:out value="${aSheet.name}"/></td>
                <td><c:out value="${aSheet.aClass}"/></td>
                <td><c:out value="${aSheet.level}"/></td>
                </c:forEach>
            </tr>
            <!---    private int constitution;
            private int strength;
            private int agility;
            private int intelligence;
            private int luck; --->
            </table></tr></table></center>
</body><center><a href="/character/characterSkill">List</a></center>
<center><a href="/character/skills">skill</a></center>
><center><a href="/character/list">main</a></center>
</html>
