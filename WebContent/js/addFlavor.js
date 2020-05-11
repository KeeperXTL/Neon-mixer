function addFlavor() {
    var div = document.createElement("div");
    div.className = "row-form-main";
    div.id = "flavorElement"
    var inputName = document.createElement("input");
    inputName.type = "text";
    inputName.name = "flavorName";
    inputName.id = "flavorName";
    inputName.style = "margin-right: 35px;";
    inputName.value = "Flavor";
    inputName.placeholder = "Flavor name";
    var inputVol = document.createElement("input");
    inputVol.type = "number";
    inputVol.name = "flavor";
    inputVol.id = "flavor";
    inputVol.value = "3";
    inputVol.style = "width: 10%;";
    inputVol.min = "0";
    inputVol.max = "100";
    var flavorContainer = document.getElementById("flavorContainer");
    flavorContainer.appendChild(div);
    div.appendChild(inputName);
    div.appendChild(inputVol);
}