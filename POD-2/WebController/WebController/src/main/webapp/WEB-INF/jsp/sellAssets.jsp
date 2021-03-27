<%@ page language="java" contentType="text/html;  charset=UTF-8"
import="java.util.*"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/sellAssets-style.css">
    <title>View Networth</title>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="#" style="margin-left: 20px;">
          <img src="https://images.vexels.com/media/users/3/136559/isolated/preview/624dd0a951a1e8a118215b1b24a0da59-pharmacy-logo-by-vexels.png" width="30" height="30" class="d-inline-block align-top" alt="">
          Portfolio Manager
        </a>
        <form action="/Home"><button type="button float-right" style="margin-right: 20px;" class="btn btn-outline-light">Home</button></form>
      </nav>
      <br>
      <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 ">
                <div class="card text-center shadow-lg">
                    <img class="card-img-top img-fluid" src="http://ukbusinessbrokers.com/wp-content/uploads/asset-share-sale.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell Assets</h4>
                        <p class="card-text">Select the assets which you want to sell.</p><br><br>
                     <!--   	<select id="lstFruits" multiple="multiple">
                      	<c:forEach items="${asset}" var="temp">
                        <option>${temp.assetid}</option>
                        <p> ${ fn:length(assets)}</p>
                        </c:forEach>
                        </select>    -->
                        
                        
                     <%--    
                        <% Map<String,Integer> stockIdList=new HashMap<String,Integer>();
                        Map<String,Integer> mfAssetList=new HashMap<String,Integer>();                        
                        %>
                        <% if(${temp.type}=="MF"){
                        	stockIdList.put(temp.assetid,temp.units);
                        }
                        else{stockIdList.put(temp.assetid,temp.units);}
                        %> 
                        --%>
                     <!--    <form:form action="/viewNetworth" method="POST" modelAttribute="SellObjectMap">
                         <c:forEach items="${asset}" var="temp" >
                         <input type="checkbox" id="${temp.assetid}" name="${temp.assetid}">${temp.assetid } &nbsp;&nbsp;&nbsp;<input type="number" id="quantity" name="quantity" min="1" max="${temp.units}"><br> 
                         </c:forEach>
                         
                         
                         </form:form> --> 
                         <%-- List<String> l=new ArrayList<>(); --%>
                         <form method="post" onSubmit=" return checker();" action="/viewNetworth" >
                         <table border="1" class=table style="margin-left: auto;margin-right: auto;">
                			<tr>
                    			<th scope=col>Asset Name</th>
                    			<th scope=col>Units to be sold</th>
                         	<tr>
                         	<c:forEach items="${asset}" var="temp" >
                        <tr>
                         <td scope=row><input type="checkbox" value="${temp.assetid}" name="selected">${temp.assetid } </td>
                         <td scope=row><input  type="number" id="quantity" name="quantity" value="0" min="0" max="${temp.units}"></td> 
                         </c:forEach>
                         </tr>
                         </table>
                         <button type="submit" name="submit"  class="btn btn-black btn-primary"> NetWorth</button>
                         </form>     
       
                         
                         
                         
                    </div>
                </div>
            </div>
            <script type="text/javascript" >
            	var a=document.getElementById("quantity")
            	function checker(){
                	var count=0;
					var l = document.getElementsByName("selected");
					for(var i=0;i<l.length;i++){
						if(l[i].checked)count++;
					}
					//console.log(count);
					 if(count==0){
						alert("Please select a value");
						return false;
					}else return true; 	
                }
            </script>
</body>
</html>