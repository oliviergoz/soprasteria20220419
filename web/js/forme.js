/**
 * 
 */
 
function changeForme(){
	let forme=document.querySelector('#select').value;
	document.querySelector('#img').src=`./images/${forme}.gif`;	
	document.querySelector('#h1').innerHTML=`Aire du ${(forme=='parallelo')?'parallelogramme':forme}`
}