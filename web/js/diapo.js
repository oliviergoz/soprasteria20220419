/**
 * 
 */
let images = ['carre', 'cercle', 'parallelo', 'rectangle'];

let index = 0;

let id = getInterval();


function getInterval() {
	return setInterval(() => {
		if (index + 1 == images.length) {
			index = 0;
		} else {
			index++;
		}
		loadImage(index);
	}, 3000);
}

function loadImage(i) {
	document.querySelector('#img').src = `./images/${images[i]}.gif`;
}

function changeImage(param) {
	clearInterval(id);
	if (param == undefined) {
		index = images.length - 1;
	} else if (param == 0) {
		index = 0;
	} else if (param == 1) {
		if (index + 1 == images.length) {
			index = 0;
		} else {
			index++;
		}
	} else {
		if (index - 1 < 0) {
			index = images.length-1;
		} else {
			index--;
		}
	}

	loadImage(index);
	id = getInterval();
}