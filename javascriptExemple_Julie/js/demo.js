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
function getTypeClient(nombre, fct){
    if(nombre<0){
        fct('nombre invalide');
   } else if ( nombre <= 200) {
        fct('Petit client');
    } else if (nombre <= 2000){
        fct('Client');
    } else if (nombre <= 10000){
        fct('Client à potentiel');
    } else {
        fct('Client à Grand Compte');
    } 
}


let tab=[100,1000,5000,3000];


tab.forEach(function(contenu,indice){
    console.log(contenu);
    console.log(indice);
    getTypeClient(contenu, function(text){
        console.log(text);
    });
});

tab.forEach(function(contenu,indice){
    console.log(contenu);
    console.log(indice);
    getTypeClient(contenu, function(text){
        console.log(text);
    });
});

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

