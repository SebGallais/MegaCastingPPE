

var http_request = new XMLHttpRequest();
try {
    // Opera 8.0+, Firefox, Chrome, Safari
    http_request = new XMLHttpRequest();
} catch (e) {
// Internet Explorer Browsers
    try {
        http_request = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {

        try {
            http_request = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
// Something went wrong
            alert("Your browser broke!");
        }

    }
    }
function listoffresdix() {
    
  
    http_request.onreadystatechange = function () {

        if (http_request.readyState == 4) {

            var jsonTab = JSON.parse(http_request.responseText);
            

            var ul = "";
            for (var i = 0; i < jsonTab.offres.length; i++) {

                    ul+= "<a href=\"offre.html?offreid="+ jsonTab.offres[i].Identifiant +"\"class=\"list-group-item\">"
                  +"<h4 class=\"list-group-item-heading\">"+ jsonTab.offres[i].Intitule +"</h4>"
                  +"<p class=\"list-group-item-text\"><b>Reference :  </b>" + jsonTab.offres[i].Reference + "</p>"
                  +"<p class=\"list-group-item-text\"><b>Debut du contrat : </b>" + jsonTab.offres[i].DateDebutContrat + "</p>"
                  +"<p class=\"list-group-item-text\"><b>Nombre de poste : </b>"+jsonTab.offres[i].NombresPoste+"</p>"
                  +"<p class=\"list-group-item-text\"><b>Ville : </b> " +jsonTab.offres[i].VilleEntreprise+"</p>";
                  +"</a>";
                  

        
            }
            
             if( jsonTab.infoauth.connecter == "true" ){
                
                document.getElementById("authContainer").innerHTML = "<div class=\"col-md-1\" > <span class=\"glyphicon glyphicon-user\"></span></br>"+jsonTab.infoauth.Prenom+" "+jsonTab.infoauth.Nom +"</div>"
                +"<div class=\"col-md-1\" ><a class=\"btn btn-danger\"  href=\"servletdeconnexion\" role=\"button\">Se déconnecter</a></div>";

                
              }
            
            document.getElementById("listgroup").innerHTML = ul;
        }
    };

    http_request.open("GET", "/MegaCastingPPE/servletoffres", true);
    http_request.send();
}


function listoffrelib() {
    
  
    http_request.onreadystatechange = function () {

        if (http_request.readyState == 4) {

            var jsonTab = JSON.parse(http_request.responseText);
            

            var ul = "";
            for (var i = 0; i < jsonTab.offres.length; i++) {

                    ul+= "<a href=\"offre.html?offreid="+ jsonTab.offres[i].Identifiant +"\"class=\"list-group-item\">"
                  +"<h4 class=\"list-group-item-heading\">"+ jsonTab.offres[i].Intitule +"</h4>"
                  +"<p class=\"list-group-item-text\"><b>Reference :  </b>" + jsonTab.offres[i].Reference + "</p>"
                  +"<p class=\"list-group-item-text\"><b>Debut du contrat : </b>" + jsonTab.offres[i].DateDebutContrat + "</p>"
                  +"<p class=\"list-group-item-text\"><b>Nombre de poste : </b>"+jsonTab.offres[i].NombresPoste+"</p>"
                  +"<p class=\"list-group-item-text\"><b>Ville : </b> " +jsonTab.offres[i].VilleEntreprise+"</p>";
                  +"</a>";
                  

        
            }
            
            
            if( jsonTab.infoauth.connecter == "true" ){
                
                document.getElementById("authContainer").innerHTML = "<div class=\"col-md-1\" > <span class=\"glyphicon glyphicon-user\"></span></br>"+jsonTab.infoauth.Prenom+" "+jsonTab.infoauth.Nom +"</div>"
                +"<div class=\"col-md-1\" ><a class=\"btn btn-danger\" href=\"servletdeconnexion\" role=\"button\">Se déconnecter</a></div>";

                
              }
            
            
            
            document.getElementById("listgroup").innerHTML = ul;
            document.getElementById("titreoffre").innerHTML = "Les offres correspondant à la recherche : \"<b>"+ jsonTab.container_search +"</b>\"";
        }
    }

    http_request.open("GET", "/MegaCastingPPE/servletloadoffreview", true);
    http_request.send();
}

function loadfluxview(){
    
    http_request.onreadystatechange = function () {

        if (http_request.readyState == 4) {
             var jsonTab = JSON.parse(http_request.responseText);
            if( jsonTab.infoauth.connecter == "true" ){
                
                document.getElementById("authContainer").innerHTML = "<div class=\"col-md-1\" > <span class=\"glyphicon glyphicon-briefcase\"></span></br>"+jsonTab.infoauth.Entreprise +"</div>"
                +"<div class=\"col-md-1\" ><a class=\"btn btn-danger\" href=\"servletdeconnexion\" role=\"button\">Se déconnecter</a></div>";

                
              }
              
            if(jsonTab.infoauth.connecter == "false" || jsonTab.infoauth.connecter == null ){
                  
                  document.getElementById("listflux").innerHTML= "<li class=\"list-group-item list-group-item-success\">Vous n'êtes pas connecté</li>"
                  
              }
            
        }
    
    };
    
    
    
    http_request.open("GET", "/MegaCastingPPE/servletloadpageflux", true);
    http_request.send();
}

function AfficherOffre()
{
 
    var param = "offreid";
    var url = document.URL;
    var u = url == undefined ? document.location.href : url;
    var reg = new RegExp('(\\?|&|^)' + param + '=(.*?)(&|$)');
    matches = u.match(reg);
    var Id = matches[2] != undefined ? decodeURIComponent(matches[2]).replace(/\+/g, ' ') : '';

    $.post("servletoffre", {identifiant_offre: Id}, function (data) {
        
  ul="<div class=\"row\" >"
        +"<div class=\"col-md-3\" >Reference de l'offre : <b>" + data.Reference +"</b> </div>"
        +"<div class=\"col-md-2\" >  </div>"
        +"<div class=\"col-md-2\" id='datepublication'>publié le : <b>"+data.DateDebutPublication+"</b></div> "
        +"<div class=\"col-md-5\" >  </div>"
    +"</div>"
    +"</br>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-6\" ><div id='intituleOffre' >"+ data.Intitule +"</div>  </div>"
        +"<div class=\"col-md-1\" ><div id=\"candidaterbouton\"></div></div> "
        +"<div class=\"col-md-5\" ></div>"
    +"</div>"
   +" </br>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" ><b>Description du profil recherché </b>  </div>"
    +"</div>"
    +"</br>"
   +"<div class=\"row\" >"
        +"<div class=\"col-md-7\" >"
       +""+ data.DescriptionProfil+""
       +" <hr>"
        +"</div>"
        
        +"<div class=\"col-md-5\" ></div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" ><b>Poste</b>  </div>"
    +"</div>"
    +"</br>"
    +"<div class=\"row\" >"
       +" <div class=\"col-md-7\" >" + data.DescriptionPoste +""
        
        
        +"<hr>"
        +"</div>"
        
        
        +"<div class=\"col-md-5\" ></div>"
    +"</div>"
   
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" ><b>Détail de l'offre</b></div>"  
    +"</div>"
    +"</br>"
        
    
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Debut du contrat : <b>"+ data.DateDebutContrat   +"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Fin du contrat : <b>"+ data.DateFinContrat +"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Nombre de poste : <b>"+ data.NombresPoste +"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Metier : <b>"+ data.Metier  +"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Contrat : <b>"+ data.Contrat  +"</b> </div>"
        +"</br>"
        +"<hr>"
    +"</div>"
    
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" ><b>Informations sur l'entreprise</b>  </div>"
    +"</div>"
    +"</br>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Entreprise : <b>"+ data.NomEntreprise+"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Nom du responsable recrutement : <b>" + data.NomResponsable+ " "+data.PrenomResponsable+"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Adresse <b>"+ data.RueEntreprise +"</b> </div>"
     +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Code Postal : <b>"+ data.CpEntreprise + "</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Ville : <b>"+ data.VilleEntreprise +"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Mail : <b>"+ data.MailEntreprise +"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
        +"<div class=\"col-md-12\" >  Téléphone : <b>"+ data.TelephoneEntreprise +"</b> </div>"
    +"</div>"
    +"<div class=\"row\" >"
       +"<div class=\"col-md-12\" >  Fax : <b>"+ data.FaxEntreprise +"</b> </div>"
   +"</div>"
    +"</br>"
   +"</br>"
   
   +"</br>";
    
    document.getElementById("containeroffre").innerHTML = ul;
    
    if( data.infoauth.connecter == "true" ){
                
                document.getElementById("authContainer").innerHTML = "<div class=\"col-md-1\" > <span class=\"glyphicon glyphicon-user\"></span></br>"+data.infoauth.Prenom+" "+data.infoauth.Nom +"</div>"
                +"<div class=\"col-md-1\" ><a class=\"btn btn-danger\" href=\"servletdeconnexion\" role=\"button\">Se déconnecter</a></div>";
        
        if(data.infoauth.CandidaterOk == "false"){
                document.getElementById("candidaterbouton").innerHTML = "<a class=\"btn btn-warning\" onclick=\"candidater("+data.Identifiant +")\" role=\"button\">Candidater</a>";
            }
    }
    
    

    }, "json");

    

}

function candidater(identifiantOffre){

    $.post("servletcandidater", {identifiant_offre: identifiantOffre});
 
}

function PageAuthCandidat(){
    
        http_request.onreadystatechange = function () {

        if (http_request.readyState == 4) {

            var jsonTab = JSON.parse(http_request.responseText);
            
            
           if(jsonTab.candidatAutherreur != null){
               
               alert( jsonTab.candidatAutherreur);
           };
            
            
    
        };
        };
    
    
    
    
    http_request.open("GET", "/MegaCastingPPE/servletpageerror", true);
    http_request.send();
    
}





function PageAuthDiffuseur(){
    
        http_request.onreadystatechange = function () {

        if (http_request.readyState == 4) {

            var jsonTab = JSON.parse(http_request.responseText);
            
            
           if(jsonTab.diffuseurAutherreur != null){
               
               alert( jsonTab.diffuseurAutherreur);
           };
            
            
    
            };
        };
    
    
    
    
    http_request.open("GET", "/MegaCastingPPE/servletpageerror", true);
    http_request.send();
    
};

function PageInscription(){
    
        http_request.onreadystatechange = function () {

        if (http_request.readyState == 4) {

            var jsonTab = JSON.parse(http_request.responseText);
            
            
           if(jsonTab.Inscriptionerreur != null){
               
               alert( jsonTab.Inscriptionerreur);
           };
            
            
    
            };
        };
    
    
    
    
    http_request.open("GET", "/MegaCastingPPE/servletpageerror", true);
    http_request.send();
    
};