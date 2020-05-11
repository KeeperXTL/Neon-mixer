function removeFlavor() {
    var flavorContainer = document.getElementById("flavorContainer");
    var lastChild = flavorContainer.lastChild;
    while (lastChild && lastChild.nodeType != 1) {
        lastChild = lastChild.previousSibling;
    }
    if (flavorContainer.children.length > 1) {
        lastChild.parentNode.removeChild(lastChild);
    }
}