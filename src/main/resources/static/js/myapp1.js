var app = angular.module("myapp",[]);
app.controller('conect',function($scope,$http){
	$scope.user = {};
	$scope.choix = "";
	$scope.listeprod = [];
	$scope.tab = [];
	$scope.produit = {};
	$scope.users = {};
	$scope.produits = {};
	$scope.prod = {};
	$scope.cmds = {};
	$scope.cadre_update = false;
	$scope.message = "";
	var i = 0;
	
	$scope.panelnew = false;
	$scope.acceuil = false;
	$scope.panellogin = true;
	$scope.panel_cmd = false;
	$scope.panel_updade = false;
	
	// Affichage du panel pour cree un Compte
	$scope.new = function(){
		$scope.panellogin = false;
		$scope.panelnew = true;
	};
	
	$scope.cancelCMD = function(){ $scope.panel_cmd = false;};
	$scope.cancelAllCmd = function(){ $scope.tab = [];};
	
	// Affichage du panel de  Connexion
	$scope.login = function(){
		$scope.panelnew = false;
		$scope.panellogin = true;
		
	}
	
	$scope.addcmd = function(){
		$scope.panel_cmd = true;
	}
	
	// Creation d un utilisateur 
	$scope.SaveUser = function(){
		$http.post("/pressing/client/save?nom="+$scope.nom+"&tel="+$scope.tel+"&email="+$scope.email+"&adresse="+$scope.adresse)
		      .success(function(data){
		    	  $scope.message= "VOTRE COMPTE A ETE CREE AVEC SUCCESS";
		    	  $scope.login();
		    	  
		      });
				
	};
	
	//Connection avec nom et telephone
	$scope.valider = function(){
		$http.get("/pressing/client/login?nom="+$scope.nom+"&tel="+$scope.tel)
		  .success(function(data){
			  $scope.user = data;
			
			  if(data.nom_cli == $scope.nom && data.tel_cli){
				  $scope.user = data;
				  console.log($scope.user);
				  $scope.panellogin = false;
			      $scope.acceuil = true;
	    	 
				  
			  }else{
				  $scope.message = " NOM OU TELEPHONE INVALIDE";
			  }
			  
			  
		  }).error(function(data,status){
			  $scope.message = "NOM OU NUMERO TELEPHONE INVALIDE";
		  });
	};
	
	$scope.allProduits = function(){
		$http.get("/pressing/allProduits")
		   .success(function(data){
			   $scope.produits = data;
			   
		   });
	};
	
	$scope.getProduitByCat = function(){
		$http.get("/pressing/produit/categorie?categorie="+$scope.choix)
		 .success(function(data){
			 $scope.produit = data;
			 console.log($scope.produit);
			
			
		 });
	};
	
	$scope.refreshCMD = function(){
		$http.get("/pressing/allCommande")
		.success(function(data){
			var temp = $scope.tab;
			var resultat = data;
			var bool = false;
			for(var i = 0; i<temp.length;i++){
				for(var j = 0;j<resultat.length;j++){
					if(temp[i].id_cmd == resultat[j].id_cmd){
						bool = true;
					}
					
				}
				if(bool == false){
					var pos=i;var sorti =[];
					for(var l = 0;l<temp.length;l++){
						if(l != pos){sorti.push(temp[l]);}
					}
				}
				bool = false;
			}
			$scope.tab = sorti;
			console.log("resultat apressupression");
			console.log(sorti);
			console.log("Fin");
		});
	}
	
	$scope.liste_commandes = function(){
		$http.get("/pressing/allCommande")
		 .success(function(data){
			 $scope.cmds = data;
			// console.log(data);
			 var taille = $scope.tab.length;
			 var elt = {};
			 var all = $scope.cmds;
			// console.log("la taille est :"+taille);
			 //////
			 if(taille == 0){
					for(var cmd in all){
				
						commande = all[cmd];
						elt.id_cmd = commande.id_cmd;
						elt.qte = commande.qte;
						elt.categorie = $scope.produit.categorie;
						//alert("scope:"+$scope.produit.categorie);
						//alert("var:"+elt.categorie);
						elt.prix = $scope.produit.prix;
						elt.total = commande.total;
						
						//console.log("DEBUT");
						//console.log(elt);
						//console.log("fin");
						$scope.tab.push(elt);
						//console.log("commande A afficher !!!!");
						//console.log($scope.tab);
						elt = {};
								
					}
				}else if(taille >= 1){
					//console.log("taille superieur a 0"+taille);
					for(var cmd in all){
						
						//console.log("val I :"+i);
						
						if(i == taille){
							commande = all[cmd];
							elt.id_cmd = commande.id_cmd;
							elt.qte = commande.qte;
							elt.categorie = $scope.produit.categorie;
							elt.prix = $scope.produit.prix;
							elt.total = commande.total;
							$scope.tab.push(elt);
							
						   					
						}
						i  = i + 1;
						
					}
					
					i = 0;
				}
			 
		 });
	};
	
	
	$scope.saveProduit = function(){		
		$http.post("/pressing/commande/save?qte="+$scope.qte+"&idclient="+$scope.user.id_cli+"&idproduit="+$scope.produit.id_prod)
		.success(function(data){
			
			//$scope.getcmds();
			$scope.liste_commandes();
			
			$scope.panel_cmd = false;	
			$scope.qte="";  
			
		});
	};
	
	
	
	$scope.del = function(id){
		$http.delete("/pressing/commande/delete/"+id)
		.success(function(data){
			$scope.refreshCMD();
			
		});
		
	};
	
	$scope.aficher = function(x,y,z){
		//$scope.panel_updade = true;
	
		$scope.cadre_update = true;
		$scope.panel_cmd = false;
		$scope.idcmd = x;
		$scope.qtecme = y;
		$scope.cate = z;
		$scope.element = $scope.prod;
		console.log($scope.element);
			
	};
	

	
	
	
	

	
	
	$scope.allProduits();
	//$scope.allClients();
	//$scope.getcmds();
	$scope.liste_commandes();
	
});