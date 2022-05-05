/**
 * 
 */

let personnes = [];


function list() {
	fetch('http://localhost:3000/personnes')
		.then(response => response.json())
		.then(resultat => {
			personnes = resultat;
			console.log(personnes);
		})
		.catch(err => console.log(err));


	console.log(personnes);
}

function search() {
	console.log(personnes);
	let id = document.querySelector('#id').value;
	fetch(`http://localhost:3000/personnes/${id}`)
		.then(response => response.json())
		.then(personne => {
			document.querySelector('#p').innerHTML = `id=${personne.id}, prenom=${personne.prenom}, nom=${personne.nom}`;
		}).catch(err => console.log(err));
}

function del() {
	let id = document.querySelector('#id').value;
	fetch(`http://localhost:3000/personnes/${id}`, { method: 'DELETE' }).then(ok => list());
}

function add() {
	fetch('http://localhost:3000/personnes', 
	{ 
		method: 'POST', 
		headers: { 'Content-Type': 'application/json' }, 
		body: JSON.stringify({ 'prenom': 'olivier', 'nom': 'gozlan' }) })
	.then(ok => list());
}

