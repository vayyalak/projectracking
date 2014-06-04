<%@page import="com.eng.gp.project.domain.ProjectType"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import=" com.gridpoint.energy.domainmodel.Tenant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta name="decorator" content="app" />
<title>Alarm Library</title>

<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>



<link rel="stylesheet" href="jquery-ui.css" />
<link rel="stylesheet" href="bootstrap.css" />
<link rel="stylesheet" href="styles.css" />

<script src="jquery-ui-1.9.2.custom.min.js"></script>
<script src="jquery-ui.js"></script>

<script type="text/javascript">
	$("select").multiselect({
	   selectedText: "# of # selected"
	});
</script>

<script type="text/javascript">

function hasOptions(obj) {
       if(obj!=null && obj.options!=null) {
              return true;
       }
       return false;
}

       function moveSelectedOptions(from,to) {
              if(!hasOptions(from)) {
                     return;
              } 
              for(var i=0;i<from.options.length;i++) {
                     var o = from.options[i];
                     if(o.selected) {
                           if(!hasOptions(to)){
                                  var index = 0;
                           } else {
                                  var index=to.options.length;
                           }
                           to.options[index] = new Option( o.text, o.value);
                     }
              }
              for(var i=(from.options.length-1);i>=0;i--) {
                     var o = from.options[i];
                     if(o.selected) {
                           from.options[i] = null;
                     }
              }
              from.selectedIndex = -1;
              to.selectedIndex = -1;
       }

       function moveAllSelectedOptions(from,to) {
           if(!hasOptions(from)) {
                  return;
           } 
           for(var i=0;i<from.options.length;i++) {
                  var o = from.options[i];
                  
                        if(!hasOptions(to)){
                               var index = 0;
                        } else {
                               var index=to.options.length;
                        }
                        to.options[index] = new Option( o.text, o.value);
                  
           }
           for(var i=(from.options.length-1);i>=0;i--) {
                  var o = from.options[i];
                  
                        from.options[i] = null;
                  
           }
           from.selectedIndex = -1;
           to.selectedIndex = -1;
    }

	 function setLenderValues(from) {
    	  if(!hasOptions(from)) {
               return;
        } 
    	  var channels = "";
      	for(var i=0;i<from.options.length;i++) {
                variables = from.options[i];
               channels += variables.value + ",";
             	alert(channels);
        }
      	if(channels.length>0){
      	document.getElementById("hiddenFormFieldName").value=channels.toString()
      	}
      	else{
            alert('Please select atleast one Channel');
            return false;
           }
      }
</script>

<script>
$(function() {
$( "#dialog-form" ).dialog({
autoOpen: false,
 height: 500,
 width: 1000,
 });

 $( "#create-user" )
.button()
.click(function() {
$( "#dialog-form" ).dialog( "open" );
});

$("#cancelbu").click(function() {
	 $( "#dialog-form" ).dialog( "close" );
	 });



 
 $("#datepicker" ).datepicker({
showOn: "button",
buttonImage: "dateicon.png",
buttonImageOnly: true,
minDate: 0,
dateFormat:'yy-mm-dd'
}).val();;



 $( "#tdatepicker" ).datepicker({
	 showOn: "button",
	 buttonImage: "dateicon.png",
	 buttonImageOnly: true,
	 minDate: 0,
	 dateFormat:'yy-mm-dd'
	 });

 
});


$("#datepicker" ).datepicker({
	showOn: "button",
	buttonImage: "dateicon.png",
	buttonImageOnly: true,
	minDate: 0,
	dateFormat:'yy-mm-dd'
	});

</script>
<style type="text/css">

	    #menu5 {
    width: 200px;
    margin: 10px;
    }
    #menu5 li a {
    height: 32px;
    voice-family: "\"}\"";
    voice-family: inherit;
    height: 24px;
    text-decoration: none;
    }	
    #menu5 li a:link, #menu5 li a:visited {
    color: #FFF;
    display: block;
    background: url(menu5.gif);
    padding: 8px 0 0 10px;
    }
    #menu5 li a:hover {
    color: #FFF;
    background: url(menu5.gif) 0 -32px;
    padding: 8px 0 0 10px;
    }
    #menu5 ul {
    list-style: none;
    margin: 0;
    padding: 0;
    }
    
    .well1 {
    background-color: #F5F5F5;
    border: 1px solid #E3E3E3;
    border-radius: 4px 4px 4px 4px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05) inset;
    margin-bottom: 20px;
    min-height: 980;
    padding: 19px;
}

div.ul-dynatree-container {
    background-color: white;
    border: 1px dotted gray;
    font-family: tahoma,arial,helvetica;
    font-size: 10pt;
    height: 50%;
    margin: 0;
    overflow: scroll;
    padding: 3px;
    white-space: nowrap;
     max-height: 680px;
}

</style>

<script language="javascript">
	function validate() {
		var chks = document.getElementsByName('premisesid');
		var hasChecked = false;
		for ( var i = 0; i < chks.length; i++) {
			if (chks[i].checked) {
				hasChecked = true;
				break;
			}
		}
		if (hasChecked == false) {
			alert("Please select at least one.");
			return false;
		}
		return true;
	}
</script>

<style>
div.ex
{
border: 1px solid #AAAAAA;
width:862px;
padding:10px;
border:3px solid gray;
margin:0px;
height: 400px;
}
</style>

<style>
div.ex2
{
width:162px;
padding:10px;
border:3px solid gray;
margin:0px;
}
</style>

<script type="text/javascript">
function showDiv() {
	   document.getElementById('site_content').style.display = "block";
	}
	
function hideDiv() {
	   document.getElementById('site_content').style.display = "none";
	}
</script>
</head>
<body>
	<div id="main">
	<header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <img src="<%=request.getContextPath()%>/static/img/gridpoint_logo_1_0.gif" alt="GridPoint" />
          <h1><a href="index.html">Project<span class="logo_colour">Tracking</span></a></h1>
          <h2>Submetering data collection to customers..</h2>
        </div>
      </div>
      <nav>
        <div id="menu_container">
          <ul id="nav">
            <li><button id="create-project" class="btn btn-small ui-button  ui-button-text-only" onclick="showDiv()">Createnewproject</button></li>
            </ul>
            </div>
            </nav>
     </header>

 <form name='projectrackform' action="createProject" method="post" style="height: 650px;">
	
		<div style="margin-left: 1262px; font-size: 12px; color: blue;" >
			<%Tenant tenant = (Tenant)request.getAttribute("tenant");%>
			<p>Welcome "${tenant.name}"</p>
		</div>
        <div class="sidebar" style="overflow: scroll;">
				<c:forEach var="premises" items="${PremisesList}">
					<input id="pcheckbox" type="checkbox" name="premisesid"
						value="${premises.id}"/>${premises.name}</br>
					</c:forEach>
			</div>
	  
	
	<div id="site_content" style="margin-left: 300px; margin-top: -500px; display: none;" title="Create new Project">
	<div style="border: solid; border-color: gray; border-style:groove;">
	 <div style="margin-top: 20px;">
				Name the Project:<input type="text" name="projectname" id="name"
					class="text ui-widget-content ui-corner-all" required="required" />
				Select Project type:<select name="projecttype"
					class="text ui-widget-content ui-corner-all" required="required">
					<option value="">
						<strong>Select a ProjectType:</strong>
					</option>
					<c:forEach var="projecttypes" items="${allProjectstypes}">
						<option value=${projecttypes.projectTypeId}>${projecttypes.projectType}</option>
					</c:forEach>
				</select><br> <br>
				 Start Date: <input type="text" id="datepicker" name="start" /> 
				 End Date: <input type="text" id="tdatepicker" name="end" /> <br> <br>
				 <label >Channels(s) <br>
				  KW channels at site: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Channel(s)associated with project &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp; Description(optional) </label>
						<select id = "channelsnames" name="attributes" property="attributes" multiple="true" size="20"
							style="width: 220px; height: 120px;
							onDblClick="moveSelectedOptions(this.form['attributes'],this.form['selectedAttributes'])">
								<c:forEach var="channel" items="${allChannels}">
									<option value="${channel.displayName}">${channel.displayName}</option>
								</c:forEach>
						</select>
						 <input type="button" name="right" value="Add"
							style="margin-left: 33px; height: 25px; width: 45px; margin-top: -50px;"
							onclick="moveSelectedOptions(this.form['attributes'],this.form['selectedAttributes'])"><br>
							<br>
							 <input type="button" name="left" value="Remove"
							style="margin-left: 273px; height: 25px; width: 70px; margin-top: -193px;"
							onclick="moveSelectedOptions(this.form['selectedAttributes'],this.form['attributes'])">
							<input type="button" name="right" value="Add all channels"
							style="margin-left: -90px; height: 25px; width: 116px; margin-top: -120px;"
							onclick="moveAllSelectedOptions(this.form['attributes'],this.form['selectedAttributes'])"><br>
						<select 
							name="selectedAttributes" id="selectedAttributesId"
							multiple="multiple" size="4" 
							style="width: 220px; margin-left: 395px; height: 120px; margin-top: -234px;"
							onDblClick="moveSelectedOptions(this.form['selectedAttributes'],this.form['attributes'])">
						</select>
						<textarea rows="4" cols="50" name="description"  style="margin-top: -166px; margin-left: 10px;">
						</textarea>
				<input type="hidden" name="channelDisplayNames" value="" 
					id="hiddenFormFieldName" /> <br> <br>
					 <input type="submit" value="save" class="btn btn-medium" style="margin-top: -109px;margin-left: 20px"/>
			</div>
			</div>	
			</form>	
			 <input type="button" value="cancle" id="cancel_id" class="btn btn-medium" onclick="hideDiv()" style="margin-top: -157px;margin-left: 99px"/>
			 </div>	
  		
</body>
</html>