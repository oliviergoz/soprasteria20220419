/**
 * 
 */


let personnes = [{ id: 0, prenom: 'olivier', nom: 'gozlan' }, { id: 1, prenom: 'jordan', nom: 'abid' }, { id: 2, prenom: 'hamza', nom: 'T' }];
let cpt = 0;
initTable();

function initTable() {
	for (let p of personnes) {
		createTr(p);
	}
}

function createTr(personne) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', `tr${cpt}`);
	let tdPrenom = document.createElement('td');
	tdPrenom.innerHTML = personne.prenom;
	tr.appendChild(tdPrenom);
	let tdNom = document.createElement('td');
	tdNom.innerHTML = personne.nom;
	tr.appendChild(tdNom);
	let edit = document.createElement('button');
	edit.innerHTML = "edition";
	edit.className = "btn btn-outline-primary"
	edit.addEventListener('click', (event) => {
		console.log('click edition');
	})

	let tdEdit = document.createElement('td');
	tdEdit.appendChild(edit);
	tr.appendChild(tdEdit);

	let del = document.createElement('button');
	del.innerHTML = "supprimer";
	del.classList.add('btn', 'btn-outline-danger');
	del.addEventListener('click', deletePersonne);

	let tdDel = document.createElement('td');
	tdDel.appendChild(del);
	tr.appendChild(tdDel);
	document.querySelector('#tbody').appendChild(tr);
	cpt++;

}

function deletePersonne(event) {
	let tr = event.path[2];
	let idPersonne = tr.id.substr(2);
	let i = 0;
	while (personnes[i].id != idPersonne) {
		i++;
	}
	personnes.splice(i, 1);
	let tbody = event.path[3];
	tbody.removeChild(tr);
	console.log(personnes);
}

function showForm() {
	document.querySelector('#divForm').className = "d-block";
}

function save() {
	let inputPrenom = document.querySelector('#prenom');
	let inputNom = document.querySelector('#nom');
	let error = false;
	if (!prenom.value) {
		console.log('prenom')
		show(document.querySelector('#prenomErr'));
		error = true;
	} else {
		hide(document.querySelector('#prenomErr'));
	}
	if (!nom.value) {
		show(document.querySelector('#nomErr'));
		error = true;
	} else {
		hide(document.querySelector('#nomErr'));
	}
	if (!error) {
		let personne = { id: cpt, prenom: prenom.value, nom: nom.value };
		createTr(personne);
		clearForm();
		hideForm();
	}


}

function cancel() {
	clearForm();
	hideForm();
}

function clearForm() {
	let inputPrenom = document.querySelector('#prenom');
	let inputNom = document.querySelector('#nom');
	inputNom.value = '';
	inputPrenom.value = '';

}

function hideForm() {
	hide(document.querySelector('#divForm'));
}


function show(element) {
	element.classList.add("d-block");
	element.classList.remove("d-none");
}

function hide(element) {
	element.classList.remove("d-block");
	element.classList.add("d-none");
}