<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

    <!DOCTYPE html>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <% String id = request.getParameter("searchQuery");
       out(id);
       %>
    <body> </body> </html>