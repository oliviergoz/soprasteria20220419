/**
 * 
 */

let nombre = Math.floor(Math.random() * 100) + 1;
let tentative = 0;
alert(nombre);
function proposition() {
	let input = document.querySelector('#proposition');
	tentative++;
	if (input.value == nombre) {
		fin(`bravo c'est gagne en ${tentative} tentatives`,input);
	} else if (tentative == 10) {
		fin(`perdu le nombre etait ${nombre}`,input);
	} else if (input.value < nombre) {
		//c'est plus grand'
		document.querySelector('#message').innerHTML = "c'est plus grand";
		input.value = '';
	} else {
		//c'est plus petit'
		document.querySelector('#message').innerHTML = "c'est plus petit";
		input.value = '';
	}
}

function fin(texte,input) {
	alert(texte);
	input.disabled = "disabled";
	document.querySelector('#bouton').disabled = "disabled";
	document.querySelector('#rejouer').className = "visible";
}

function rejouer(){
	window.location.reload();
}