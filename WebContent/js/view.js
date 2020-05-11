function pgvgchange() {
    var pg = document.getElementById("pgvg").value;
    var vg = 100 - pg;
    document.getElementById("pgvgval").innerHTML="PG " + pg + "/" + vg + " VG";
 }

 function strenghtchange() { 
    document.getElementById("strenghtval").innerHTML=document.getElementById("strenght").value;
 }
 
 function addvolofflud() {
	 if(document.getElementById("volofliq").value < 100) {
    document.getElementById("volofliq").value=Number(document.getElementById("volofliq").value) + 1;
 	}
 }
 
 function removevolofflud() {
	 if(document.getElementById("volofliq").value > 0) {
    document.getElementById("volofliq").value=Number(document.getElementById("volofliq").value) - 1;
	 }
 }
 
 function addwater() {
	 if(document.getElementById("water").value < 100) {
    document.getElementById("water").value=Number(document.getElementById("water").value) + 1;
	 }
 }
 
 function removewater() {
	 if(document.getElementById("water").value > 0) {
    document.getElementById("water").value=Number(document.getElementById("water").value) - 1;
	 }
 }
 
 function addnico() {
	 if(document.getElementById("nico").value < 100) {
    document.getElementById("nico").value=Number(document.getElementById("nico").value) + 1;
	 }
 }
 
 function removenico() {
	 if(document.getElementById("nico").value > 0) {
    document.getElementById("nico").value=Number(document.getElementById("nico").value) - 1;
	 }
 }
