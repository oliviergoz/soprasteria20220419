/**
 * 
 */

let personnes = [];

fetch('http://localhost:3000/personnes')
	.then(resp => resp.json())
	.then(result => {
		personnes = result;
		personnes.forEach((p, i) => {
			document.querySelector('#tbody').appendChild(createTr(p));
		});
	})



function createTr(personne) {
	let tr = document.createElement('tr');
	let tdId = document.createElement('td');
	tdId.innerHTML = personne.id;
	tr.appendChild(tdId);
	let tdPrenom = document.createElement('td');
	tdPrenom.innerHTML = personne.prenom;
	tr.appendChild(tdPrenom);
	let tdNom = document.createElement('td');
	tdNom.innerHTML = personne.nom;
	tr.appendChild(tdNom);
	let edit = document.createElement('button');
	edit.setAttribute('id', `e${personne.id}`);
	edit.setAttribute('name', personne.id);
	edit.innerHTML = "edition";
	edit.className = "btn btn-outline-primary"
	edit.addEventListener('click', editPersonne);
	let tdEdit = document.createElement('td');
	tdEdit.appendChild(edit);
	tr.appendChild(tdEdit);
	let del = document.createElement('button');
	del.innerHTML = "supprimer";
	del.classList.add('btn', 'btn-outline-danger');
	del.addEventListener('click', deletePersonne);
	del.setAttribute('name', personne.id);
	let tdDel = document.createElement('td');
	tdDel.appendChild(del);
	tr.appendChild(tdDel);
	return tr;
}

function editPersonne() {
	fetch(`http://localhost:3000/personnes/${event.target.name}`)
		.then(resp => resp.json())
		.then(personne => {
			let inputPrenom = document.querySelector('#prenom');
			let inputNom = document.querySelector('#nom');
			let inputId = document.querySelector('#id');
			inputId.value = personne.id;
			inputPrenom.value = personne.prenom;
			inputNom.value = personne.nom;
			showForm();
		});
}

function deletePersonne(event) {
	fetch(`http://localhost:3000/personnes/${event.target.name}`, { method: 'DELETE' }).then(() => window.location.reload());
}

function showForm() {
	document.querySelector('#divForm').className = "d-block";
}


function cancel() {
	clearForm();
	hideForm();
}

function clearForm() {
	let inputPrenom = document.querySelector('#prenom');
	let inputNom = document.querySelector('#nom');
	let inputId = document.querySelector('#id');
	inputId.value = '';
	inputNom.value = '';
	inputPrenom.value = '';

}

function show(element) {
	element.classList.add("d-block");
	element.classList.remove("d-none");
}

function hideForm() {
	hide(document.querySelector('#divForm'));
}

function hide(element) {
	element.classList.remove("d-block");
	element.classList.add("d-none");
}

function save() {
	let inputId = document.querySelector('#id');
	let inputPrenom = document.querySelector('#prenom');
	let inputNom = document.querySelector('#nom');
	let error = false;
	if (!prenom) {
		error = true;
		show(document.querySelector('#prenomErr'));
	}
	if (!nom) {
		error = true;
		show(document.querySelector('#nomErr'));
	}
	if (!error) {
		if (inputId.value) {
			let personne = {
				id: inputId.value,
				prenom: inputPrenom.value,
				nom: inputNom.value
			};
			fetch(`http://localhost:3000/personnes/${personne.id}`, {
				method: 'PUT',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify(personne)
			}).then(() => window.location.reload());

		} else {
			//creation
			let personne = {
				prenom: inputPrenom.value,
				nom: inputNom.value
			}
			fetch('http://localhost:3000/personnes', {
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify(personne)
			}).then(() => window.location.reload());
		}
	}
}

