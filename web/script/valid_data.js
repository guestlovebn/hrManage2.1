function check_valid(check, value)
{
    xmlHttp=GetXmlHttpObject()
    if (xmlHttp==null)
        alert ("Your Browser not support AJAX!");
    var url="CheckValid?check="+check +"&value="+value;
    xmlHttp.onreadystatechange=function()
    {
        if (xmlHttp.readyState==4)
        {
            var result = xmlHttp.responseText;
            if(check=="first")
                document.getElementById("lblFirstName").innerHTML=result;
            if(check=="last")
                document.getElementById("lblLastName").innerHTML=result;
            if(check=="birth")
                document.getElementById("lblBirthDate").innerHTML=result;
            if(check=="hire")
                document.getElementById("lblHireDate").innerHTML=result;
            if(check=="home")
                document.getElementById("lblHomePhone").innerHTML=result;
            if(check=="mobile")
                document.getElementById("lblMobile").innerHTML=result;
            if(check=="email")
                document.getElementById("lblEmail").innerHTML=result;
        }
    }
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}

function check_submit(){
    var ok=true;
    if(document.getElementById("lblFirstName").innerHTML!="" ||
        document.getElementById("lblLastName").innerHTML!="" ||
        document.getElementById("lblBirthDate").innerHTML!="" ||
        document.getElementById("lblHireDate").innerHTML!="" ||
        document.getElementById("lblHomePhone").innerHTML!="" ||
        document.getElementById("lblMobile").innerHTML!="" ||
        document.getElementById("lblEmail").innerHTML!=""){
        ok=false;
    }
    return ok;
}

function GetXmlHttpObject()
{
    var xmlHttp=null;
    try // Firefox, Opera 8.0+, Safari
    {
        xmlHttp=new XMLHttpRequest();
    }
    catch (e)
    {
        try // Internet Explorer
        {
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e)
        {
            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}