<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>


  <!doctype html>
  <html lang="en">
    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



   </head>
   <body>


<core:if test="${suggestions!=null}">

        <core:if test="${suggestions.size()>=1}">


                                  <core:forEach items="${suggestions}" var="question">
                                                 <p onClick="clickHandler(this)">${question}</p>


                                 </core:forEach>




         </core:if>


    </core:if>




</body>

  </html>

