<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>

    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1">
       <tr>
          <th>idprodotto</th>
          <th>nome</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${list}" var="product" >
          <tr>
             <td>${product.idprodotto}</td>
             <td>${product.nome}</td>
             <td>${product.prezzo}</td>
             <td>
                <a href="editProduct?code=${product.prezzo}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${product.prezzo}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createProduct" >Create Product</a>
 
 </body>
</html>