<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
 <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "springform"%>


  <!doctype html>
  <html lang="en">
    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
         <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script src="/SearchEngine/ext/jquery/js/jquery.js"></script>
         <script type="text/javascript">
                 $(document).ready(function() {
                     $('#searchBar').on('change keyup paste',function ()
                     {
                         console.log("hey jqeryyyy");
                         $.ajax({
                               type: "post",
                              url: "/SearchEngine/searchSuggestions", //this is my servlet
                               data: {
                                  searchQuery: $('input').val(),

                                 },
                              success: function(result){

                               $( "#result" ).html(result)
                               }
                             });
                     });

                 });
             </script>




<style>


html, body {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    display: table
}
.searchBar{
    display: table-cell;
    text-align: center;
    vertical-align: middle;
}

#result{
   border-radius:5px;
   border:2px solid #f6f6f6;
   cursor:pointer;
   max-height:150px;
   overflow:scroll

   }

p:hover {
  background-color: #f1f3f8;
}
</style>
   </head>
   <body>
<div class="searchBar">
 <h1 class="display-2" style="color:#0F9D58">NUCOOGLE</h1>

 <springform:form  action="/SearchEngine/Engine" commandName="sf" method="post" >
 <springform:input style="width:100%" id="searchBar" class="searchBar"  type="text" path="keyword" placeholder="Search Here"  autocomplete="off" />
  <div id="result" ></div>
 <button type="button" class="btn btn-success"> <input style="background-color:inherit;border:none;color:white" type="submit" value="Search" /></button>
 </springform:form>

</div>

     <script>
     function clickHandler(element){
     console.log(document.getElementById("searchBar"));
        document.getElementById("searchBar").value=element.innerHTML;

     }
     </script>


       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>

  </html>

