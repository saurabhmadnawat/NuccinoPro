<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
 <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "springform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

  <!doctype html>
  <html lang="en">
    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 <style>
 .nobr { display:inline-block }
 </style>


   </head>
   <body>
<br/>

<div style="display:inline-block" >
<h4 style="color:#0F9D58">NUCOOGLE</h4>
</div>
<div style="display:inline-block">
 <springform:form  action="/SearchEngine/Engine" commandName="sf" method="post" >
<springform:input  type="text" path="keyword" placeholder="Search Here" />
  <button type="button" class="btn btn-success"> <input style="background-color:inherit;border:none;color:white" type="submit" value="Search" /></button>
</springform:form>
</div>
<hr>
  <br/>
    <div>
    <core:choose>
        <core:when test="${searchResult.size()>=1}">
          <core:forEach items="${searchResult}" var="list">
             <div style="border:solid 2px #dddddd ; border-radius:5px ; padding:12px;margin-left:15px ; width:50%">
              <a href=${list[1]} > ${list[1]} </a>
             <p> ${list[0]} <p>
             </div>
              <br/>
              </core:forEach>
        </core:when>
        <core:otherwise>
            Nothing to show

        </core:otherwise>
    </core:choose>

    </div>

   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>

  </html>

