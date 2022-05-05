/**
 * 
 */


let personnes = [{ id: 0, prenom: 'olivier', nom: 'gozlan' }, { id: 1, prenom: 'jordan', nom: 'abid' }, { id: 2, prenom: 'hamza', nom: 'T' }];
let cpt = 3;
initTable();

function initTable() {
	for (let p of personnes) {
		document.querySelector('#tbody').appendChild(createTr(p));
	}
}

function createTr(personne) {
	let tr = document.createElement('tr');
	if (personne.id) {
		tr.setAttribute('id', `tr${personne.id}`);
	} else {
		tr.setAttribute('id', `tr${cpt}`);
		cpt++;
	}

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
		let tr = event.path[2];
		let idPersonne = tr.id.substr(2);
		let i = searchPersonne(idPersonne);
		document.querySelector('#prenom').value = personnes[i].prenom;
		document.querySelector('#nom').value = personnes[i].nom;
		document.querySelector('#id').value = personnes[i].id;
		//document.querySelector('#enregistrer').removeEventListener
		showForm();
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
	return tr;
}

function deletePersonne(event) {
	let tr = event.path[2];
	let idPersonne = tr.id.substr(2);
	let i = searchPersonne(idPersonne);
	personnes.splice(i, 1);
	let tbody = event.path[3];
	tbody.removeChild(tr);
}

function showForm() {
	document.querySelector('#divForm').className = "d-block";
}

function save() {
	let inputPrenom = document.querySelector('#prenom');
	let inputNom = document.querySelector('#nom');
	let inputId = document.querySelector('#id');
	let error = false;
	if (!inputPrenom.value) {
		console.log('prenom')
		show(document.querySelector('#prenomErr'));
		error = true;
	} else {
		hide(document.querySelector('#prenomErr'));
	}
	if (!inputNom.value) {
		show(document.querySelector('#nomErr'));
		error = true;
	} else {
		hide(document.querySelector('#nomErr'));
	}
	if (!error) {
		if (inputId.value) {
			//update
			let idPersonne = inputId.value;
			let i = searchPersonne(idPersonne);
			personnes[i].prenom = inputPrenom.value;
			personnes[i].nom = inputNom.value;
			let trARemplacer = document.querySelector(`#tr${idPersonne}`);
			let nouveauTr = createTr(personnes[i]);
			document.querySelector('#tbody').replaceChild(nouveauTr, trARemplacer);

		} else {
			//creation
			let personne = { id: cpt, prenom: inputPrenom.value, nom: inputNom.value };
			document.querySelector('#tbody').appendChild(createTr(personne));
			personnes.push(personne);
		}
		clearForm();
		hideForm();
	}


}

function searchPersonne(idRecherche) {
	let i = 0;
	while (personnes[i].id != idRecherche) {
		i++;
	}
	return i;
}

function cancleSubmit() {
	return false;
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