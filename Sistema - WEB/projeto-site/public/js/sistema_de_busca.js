for (i of document.querySelectorAll('[search]')) {
    try {
        busca(i, document.querySelector("#" + i.getAttribute('search')))
    } catch (e) { }
}

function busca(input_field, div) {
    input_field.onkeyup = function (e) {
        for (di of div.children) {
            r = new RegExp(this.value, "g")
            if (di.getAttribute("nome").toLowerCase().match(r) != null) {
                di.style.removeProperty('display');
                di.style.transition = "all 200ms ease-in-out";
            } else {
                di.style.display = "none";
                di.style.transition = "all 200ms ease-in-out";
            }
        }
    }
}