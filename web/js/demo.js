/*// alert("Hello");
console.log("log...");
console.debug("Debug...");
let retour = mafonction('julie');
console.log('le retour '+ retour);

let fonction = function(){
	console.log('fontion variable');
}

fonction(); // affiche fonction variable

console.log(mafonction()); // affiche retour

console.log(mafonction); // affiche la fonction (le code)


function mafonction(param){
	console.log('fonction '+param);
	return 'retour';
}*/

/*console.log('log');
console.debug('debug');
console.warn('warning');
console.error('error');

function demoCallBack(param, fonction){
	fonction(param);
}

// demoCallBack('julie', alert);
demoCallBack('julie', console.log);*/

//function demoCallBack(param, fonction) {
//	fonction(param);
//}
//
//demoCallBack('olivier', console.log);
//
//demoCallBack(123, function(param) {
//	console.debug(param);
//});

// --- Exo cours

//let id=setTimeout(()=>{
//	alert('mon alert');
//},5000);
//
//clearTimeout(id);

let id=setInterval((param)=>{
	console.log('log...'+param)
},2000,'olivier');

//clearInterval(id);


function getTypeClient(nombre, fct) {
	if (nombre < 0) {
		fct("nombre invalide");
	} else if (nombre <= 200) {
		fct("Petit client");
	} else if (nombre <= 2000) {
		fct("Client");
	} else if (nombre <= 10000) {
		fct("Client à potentiel");
	} else {
		fct("Client à Grand Compte");
	}
}

let tab = [100, 1000, 5000, 3000];


tab.forEach(function(contenu, indice) {
	console.log(contenu);
	console.log(indice);
	getTypeClient(contenu, function(text) {
		console.log(text);
	});
});

tab.forEach((contenu, indice) => {
	console.log(contenu);
	console.log(indice);
	getTypeClient(contenu, (text) => {
		console.log(text);
	});
});


//var bouton= document.getElementById("bouton");

// getTypeClient(100, function(text){
//     console.log(text);
// });
// getTypeClient(1000, function(text){
//     console.log(text);
// });
// getTypeClient(5000, function(text){
//     console.log(text);
// });
// getTypeClient(300000, function(text){
//     console.log(text);
// });

let variable=10;

function changementNomBouton(nom) {
	alert(variable);
	let bouton = document.querySelector("#bouton");
	console.log(bouton);
	bouton.innerHTML = nom;
	let input = document.querySelector("#ca");
	console.log(input.value);
	//  getTypeClient(input.value, (ca) => {
	//    alert(ca);
	//  });
	//getTypeClient(input.value, maFonction);
	getTypeClient(input.value, (typeClient) => {
		alert(typeClient);
		console.log(typeClient);
		let input = document.querySelector("#copie");
		input.value = typeClient;
	});
}

function maFonction(param) {
	alert(param);
	console.log(param);
	let input = document.querySelector("#copie");
	input.value = param;
}
