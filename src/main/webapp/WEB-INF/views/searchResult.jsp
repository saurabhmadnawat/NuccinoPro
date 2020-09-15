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
                                       console.log(result);
                                      $( "#result" ).html( result )
                                      }
                                    });
                            });

                        });
        </script>


    <style>
      .nobr { display:inline-block }

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
     <br/>
   <div style="width:100%">

    <div  >
   <h4 style="color:#0F9D58">NUCOOGLE</h4>
   </div>

     <div  >
  <springform:form  action="/SearchEngine/Engine" commandName="sf" method="post" >
  <springform:input type="text" style="width:80%"  id="searchBar" path="keyword" placeholder="Search Here" autocomplete="off"  />
   <div id="result" ></div>
  <button type="button" class="btn btn-success"> <input style="background-color:inherit;border:none;color:white" type="submit" value="Search" /></button>
  </springform:form>

</div>

</div>

<hr>
  <br/>
    <div>
    <p>Showing <strong>${numResults}</strong> result for <strong>${searchQuery}</strong> in  <strong>${timeTaken}</strong> seconds </p>
    <core:choose>
        <core:when test="${searchResult.size()>=1}">
          <core:forEach items="${searchResult}" var="list">
             <div style="border:solid 2px #dddddd ; border-radius:5px ; padding:12px;margin-left:15px ; width:50%">

             <p> <strong>${list[0]}</strong> <p>
              <p > ${list[1]} </p>
             </div>
              <br/>
              </core:forEach>
        </core:when>
        <core:otherwise>
            Nothing to show

        </core:otherwise>
    </core:choose>

    </div>

       <script>
            function clickHandler(element){
               document.getElementById("searchBar").value=element.innerHTML;

            }
            </script>
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>

  </html>

