
//Copy the Email Address:
          $(document).ready(function() {
               $("#copyAddress").click(function(){
              //gets the items without any seperater
                var copyAdd = $('#selectEmail option:selected').text();    
                document.getElementById("seldropDown").value = copyAdd; 
                    alert("selected value " +copyAdd);
                     
                 });
               });
          
 
 //Function to set the drop down
 function setDropText(select_ele){
  // Ignore "None"
  if (select_ele.selectedIndex == 0) {
	  return;
  }
  document.getElementById("seldropDown").innerHTML = select_ele.options[select_ele.selectedIndex].text;
      
 }//End of function
 
 
function setText(select_ele){
    document.getElementById("comments").innerHTML = select_ele.options[select_ele.selectedIndex].value;
    val = select_ele.options[select_ele.selectedIndex].value;
    
     if (val == 500) {			
        document.getElementById("comments").innerHTML = 
        	"<b>Purpose/ Description:</b>" + "<br /> " + "Query DNS for X.509 individual Direct address-bound certificate where rfc822name is populated in the certificate. " + "<br /> " +
        	"<b>Target Certificate:</b> " +"<br />" + "A valid address-bound DNS certificate for the Direct address." +"<br />" +
        	"<b>Background Certificates:</b> " +"<br />" + "A valid domain-bound certificate for the Direct address in a DNS CERT Record. Valid address-bound and domain-bound certificates for the Direct address in an LDAP server with associated SRV record." +"<br />" +
       	    "<b>RTM:</b> " +"<br />" +" 1,3" +"<br />" +
       	    "<b>Underlying Specification Reference:</b> " +"<br />" +"RFC 4398: Section 2.1 - Direct Applicability Statement for Secure Health Transport: Section 5.3" ;			
    }else if (val == 501) {
       document.getElementById("comments").innerHTML =
    	   "<b>Purpose/ Description:</b>" + "<br /> " + "Query DNS for X.509 Direct domain-bound certificate where the dNSName is populated in the certificate.  " + "<br /> " +
    	   "<b>Target Certificate:</b> " +"<br />" +"A valid domain-bound certificate for the Direct address in a DNS CERT record. " +"<br />" +
    	   "<b>Background Certificate:</b> " +"<br />" +"An invalid address-bound certificate in a DNS record. Valid address-bound and domain-bound certificates in an LDAP server with associated SRV Record." +"<br />" +
    	   "<b>RTM:</b> " +"<br />" +"1, 3, 4" +"<br />" +
    	   "<b>Underlying Specification Reference:</b> " +"<br />" +" RFC 4398: Section 2.1 - Direct Applicability Statement for Secure Health Transport: Section 4.0 and 5.3";
    } else if (val == 502){
       document.getElementById("comments").innerHTML =	
    	   "<b>Purpose/ Description:</b>" + "<br /> " + "Query DNS for Direct certificate that is larger than 512 bytes. " + "<br /> " +
    	   "<b>Target Certificate:</b> " +"<br />" +"A valid address-bound certificate that is larger than 512 bytes in a DNS CERT record for the Direct address." +"<br />" +
    	   "<b>Background Certificate:</b> " +"<br />" +"None" +"<br />" +
    	   "<b>RTM:</b> " +"<br />" +" 1, 3, 4 " +"<br />" +
    	   "<b>Underlying Specification Reference:</b> " +"<br />" +" Direct Applicability Statement for Secure Health Transport: Section 5.4 - RFC 1035: Section 4.2- RFC 4298: Section 4" ;
    } else if(val == 505 ){
       document.getElementById("comments").innerHTML =
    	   "<b>Purpose/ Description:</b>" + "<br /> " + "Query DNS for LDAP SRV Resource Record and query LDAP for X.509 Cert that is bound to the rfc822name in the certificate. " + "<br /> " +
    	   "<b>Target Certificate:</b> " +"<br />" +"A valid address-bound certificate in an LDAP server with the appropriate mail attribute and InetOrgPerson Schema. An SRV Record points to the LDAP instance." +"<br />" +
    	   "<b>Background Certificate:</b> " +"<br />" +"Expired certificates in DNS CERT address-bound and domain-bound resource records for the Direct address. A valid domain-bound certificate in an LDAP server with associated SRV Record." +"<br />" +
    	   "<b>RTM:</b> " +"<br />" +" 2,3,5,7,8,9,10,11,12,13,14,15,16,17,19,20,21,22";   
    }else if (val == 515) {
       document.getElementById("comments").innerHTML =
    	   "<b>Purpose/ Description:</b>" + "<br /> " + "Query LDAP server for domain-bound certificate.  " + "<br /> " +
    	   "<b>Target Certificate:</b> " +"<br />" +"A valid domain-bound certificate in an LDAP server with the appropriate mail attribute and InetOrgPerson Schema. An SRV Record points to the LDAP instance." +"<br />" +
    	   "<b>Background Certificate:</b> " +"<br />" +"Expired certificates in DNS CERT address-bound and domain-bound resource records for a Direct address. An expired address-bound certificate " +"<br />" +
    	   "<b>RTM:</b> " +"<br />" +"22";
    } else if (val == 506){
       document.getElementById("comments").innerHTML =	
    	   "<b>Purpose/ Description:</b>" + "<br /> " + "Query for Direct address from LDAP servers based on priority value. " + "<br /> " +
    	   "<b>Target Certificate:</b> " +"<br />" +"A valid address-bound certificate in an LDAP server with the appropriate mail attribute and InetOrgPerson Schema. The associated SRV record has Priority = 0 and Weight = 0" +"<br />" +
    	   "<b>Background Certificate:</b> " +"<br />" +"A valid address-bound certificate in an LDAP server with the appropriate mail attribute and InetOrgPerson Schema. The associated SRV has Priority = 1 and Weight = 0" +"<br />" + 
    	   "<b>RTM:</b> " +"<br />" +"15,18" +"<br />" +" <b>Underlying Specification Reference:</b> " +"<br />" +
    		 "RFC 2782: Page 3, Priority Section";
    } else if(val == 507 ){
      document.getElementById("comments").innerHTML =
    	  "<b>Purpose/ Description:</b>" + "<br /> " + "Query for Direct address from LDAP servers based on priority value - One LDAP instance unavailable. " + "<br /> " +
    	  "<b>Target Certificate:</b> " +"<br />" +"A valid address-bound certificate in an LDAP server with the appropriate mail attribute and InetOrgPerson Schema. The associated SRV has Priority = 1 and Weight = 0" +"<br />" +
   	   "<b>Background Certificate:</b> " +"<br />" +"A valid address-bound certificate in an LDAP server with the appropriate mail attribute and InetOrgPerson Schema. The associated SRV Record points to an LDAP instance that is offline and not available. Its Priority = 0 and Weight = 0" +"<br />" +
    	  "<b>RTM:</b> " +"<br />" +" 15,18" +"<br />" +" <b>Underlying Specification Reference:</b> " +"<br />" +
    		 "RFC 2782: Page 3, Priority Section";
   } else if(val == 517 ){
     document.getElementById("comments").innerHTML =
    	 "<b>Purpose/ Description:</b>" + "<br /> " +  "Query for Direct address from LDAP servers based on priority value - one LDAP Instance does not return a valid certificate. " + "<br /> " +
    	 "<b>Target Certificate:</b> " +"<br />" +"A valid address-bound certificate in an LDAP server with the appropriate mail attribute and InetOrgPerson Schema. The associated SRV Record has its Priority = 1 and Weight = 0" +"<br />" +
  	   "<b>Background Certificate:</b> " +"<br />" +"An LDAP Entry with the appropriate mail attribute in the InetOrgPerson Schema, but no userCertificate attribute. The associated SRV Record has its Priority = 0 and Weight = 0" +"<br />" +
    	 "<b>RTM:</b> " +"<br />" +" 15, 18 " +"<br />" +" <b>Underlying Specification Reference:</b> " +"<br />" +"RFC 2782: Page 3, Priority Section- Applicability Statement for Secure Health Transport: Section 4";
   } else if(val == 519 ){
	     document.getElementById("comments").innerHTML =
	    	 "<b>Purpose/ Description:</b>" + "<br /> " +
	           "Query two LDAP servers - One LDAP Instance does not return a valid certificate. - " + "<br /> " +
	      	 "<b>RTM:</b> " +"<br />" +" 15, 18 " +"<br />" +" <b>Underlying Specification Reference:</b> " +"<br />" +" RFC 2782: Page 3, Priority and Weight Sections - Applicability Statement for Secure Health Transport: Section 4";
   } else if(val == 520 ){
	     document.getElementById("comments").innerHTML =
	    	 "<b>Purpose/ Description:</b>" + "<br /> " +  "No valid Certificate found in DNS CERT or LDAP instance. - "  + "<br /> " + 
	    	 "<b>Additional Info:</b> " +" <br /> " + " In order for this test case to be a success, you must NOT receive an email in response. You will need to verify that your system did NOT send an email because it could not find a certificate for the Direct address." + " <br /> " +
	           "<b>Target Certificate:</b> " +"<br />" +"None" +"<br />" +
	    	   "<b>Background Certificate:</b> " +"<br />" +"Invalid address-bound and domain-bound certificates in CERT records for the Direct address. An SRV record points to the LDAP server and is populated with invalid address-bound and domain-bound certificates for the Direct address and domain." +"<br />" +
	           "<b>RTM:</b> " +"<br />" +" 3, 22 " +"<br />";
   } else if(val == 511){
	   	document.getElementById("comments").innerHTML =
	   		"<b>Purpose/ Description:</b>" + "<br /> " + "No certificate found in DNS CERT or LDAP instance. " + "<br /> " + "<b>Additional Info:</b> " +" <br /> " + " In order for this test case to be a success, you must NOT receive an email in response. You will need to verify that your system did NOT send an email because it could not find a certificate for the Direct address." + "<br /> " + 
	   	 "<b>Target Certificate:</b> " +"<br />" +"None" +"<br />" +
  	   "<b>Background Certificate:</b> " +"<br />" +"None" +"<br />" +
	   		"<b>RTM:</b> " +"<br />" +" 1, 3, 18. " +"<br />" ;
   } else if(val == 512 ){
	   	document.getElementById("comments").innerHTML =
	   		"<b>Purpose/ Description:</b>" + "<br /> " + "No certificate found in DNS CERT and no SRV records " + "<br /> " + "<b>Additional Info:</b> " +" <br /> " + " In order for this test case to be a success, you must NOT receive an email in response. You will need to verify that your system did NOT send an email because it could not find a certificate for the Direct address." + "<br /> " +
	   	 "<b>Target Certificate:</b> " +"<br />" +"None" +"<br />" +
  	   "<b>Background Certificate:</b> " +"<br />" +"Invalid address-bound and domain-bound certificates in DNS CERT records for the Direct address." +"<br />" +
	   		
	   		"<b>RTM:</b> " +"<br />" +" 1, 3, 18.";
   } 
 }//end of function               