<%-- 
    Document   : Vue
    Created on : 7 nov. 2018, 13:58:03
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edition des taux de remise</h1>
        
        <form method="GET">
            Code : 
            <input name="code" size="1" maxlength="1" >
            <br>
            Taux : 
            <input name="taux" step="0.01" min="0.0" max="99.99" size="5" type="number" >
            <br>
            <input name="action" value="ADD" type="hidden">
            <input value="Ajouter" type="submit">
        </form>
        
        <table border="1">
            <tbody>
                <tr>
                    <th>Code</th>
                    <th>Taux</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="Listdiscount" items="${Listdiscount}">
                    <tr>
                        <td>${Listdiscount.code}</td>
                        <td>${Listdiscount.rate}</td>
                        <td> <a href="?action=DELETE&code=${Listdiscount.code}">delete</a> </td>
                    </tr>    
                </c:forEach>


            </tbody>
        </table>
        
    </body>
</html>
