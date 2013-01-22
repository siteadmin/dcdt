<%@ page session="false"%>
<jsp:include page="ajaxCall.jsp" flush="true">
  	<jsp:param name="title"
		value="Home Page" />
	<jsp:param name="pgDesc"
		value="Direct Certificate Discovery Testing Tool - Header" />
	<jsp:param name="pgKey"
		value="Direct Certificate Discovery Testing Tool - Header" />
	<jsp:param name="header" value="" />
</jsp:include>

<head>
<meta name="ROBOTS" content="none,noindex,nofollow" />
<meta http-equiv="Content-Language" content="en-US" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Expires" content="Sat, 01 Jan 2000 23:59:00 GMT" />
<meta http-equiv="PRAGMA" content="NO-CACHE"/>
<title>Direct Certificate Discovery Tool</title>
<link rel="stylesheet" href="images/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="images/css/msp3.css" type="text/css" />
<link rel="image" href="images/img/glyphicons-halflings-white.png" type="image" />
<link rel="image" href="images/img/glyphicons-halflings.png" type="image" />
<link rel="shortcut icon" href="images/favicon.ico" />
</head>

<!-- TOP NAVIGATION -->
  <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                  <a href="home.jsp"><img src="images/DCDT_logo.png" class="brand" title="DCDT logo image"></a>
                <ul class="nav">
                    <li class="active" id ="home"><a href="home.jsp"><i class="icon-home icon-white"></i> Home</a></li>
                    <li id="hosting"><a href="dns.jsp">Hosting</a></li>
                    <li id="discovery"><a href="download.jsp">Discovery</a></li>  
                    </ul>
                       <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b></a>
                      <ul class="dropdown-menu">
                        <li><a tabindex="-1" target="_blank" href="http://code.google.com/p/direct-certificate-discovery-tool/wiki/User_Guide">User's Guide</a></li>
                        <li><a tabindex="-1" target="_blank" href="http://www.youtube.com/watch?v=ceDlKvpvdnE&feature=youtu.be">Video Demo</a></li>
                        <li><a tabindex="-1" target="_blank" href="http://code.google.com/p/direct-certificate-discovery-tool/wiki/Frequently_Asked_Questions">FAQ</a></li>
                        <li class="divider"></li>
                        <li><a tabindex="-1" target="_blank" href="http://code.google.com/p/direct-certificate-discovery-tool/">Code Repository</a></li>
                      </ul>
                    </li>
                   </ul>
            </div>
        </div>
    </div>  
    <br /><br /><br /><br /> 

 