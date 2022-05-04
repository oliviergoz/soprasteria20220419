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




let obj = {
	prenom: 'olivier',
	nom: 'gozlan',
	adresse: { rue: 'chez olivier' }
};

//let id = setInterval((param) => {
//	console.log('log...' + param)
//}, 2000, 'olivier');

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

let variable = 10;

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

function demoCreateElement() {
	let div = document.querySelector('#div1');
	let nouvelleDiv = document.createElement('div');
	nouvelleDiv.innerHTML = "contenu de la nouvelle";
	div.appendChild(nouvelleDiv);
	let autreDiv = document.createElement('div');
	autreDiv.innerHTML = "<b>autre div</b>";
	div.appendChild(autreDiv);

	let p = document.createElement("p");
	p.innerText = "du texte dans un p";
	let divAvecP = document.createElement("div");
	divAvecP.appendChild(p);
	let button = document.createElement('button');
	button.innerHTML = "nouveau bouton";
	button.id = "newBouton";
	//button.onclick = clickNouveauBouton;
	//	button.addEventListener('click',(event)=>{
	//		console.log(event);
	//	})
	button.addEventListener('click', clickNouveauBouton);
	divAvecP.appendChild(button);
	div.appendChild(divAvecP);



	createUl();
}


function clickNouveauBouton(event) {
	console.log(event);
}

let tableau = ['olivier', 'jordan'];

function createUl() {

	let ul = document.querySelector('#ul');
	tableau.forEach((e, i) => {
		let li = document.createElement('li');
		li.innerText = e;
		ul.appendChild(li);
	});
}




function add() {
	let formateur = document.querySelector('#formateur').value;
	tableau.push(formateur);
	let ul = document.querySelector('#ul');
	let li = document.createElement('li');
	li.innerText = formateur;
	ul.appendChild(li);
}
