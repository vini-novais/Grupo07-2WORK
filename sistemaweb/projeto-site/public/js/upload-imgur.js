function reportInfo(vars, showType = false) {
    if (showType === true) console.log(typeof vars);
    console.log(vars);
}

function addImg(ele, content) {
    var myDIV = document.querySelector(ele);
    var newContent = document.createElement('div');
    newContent.innerHTML = content;

    while (newContent.firstChild) {
        myDIV.appendChild(newContent.firstChild);
    }
}

var content = "";
console.log(content);
var feedback = function (res) {
    reportInfo(res, true);
    if (res.success === true) {
        var get_link = res.data.link.replace(/^http:\/\//i, 'https://');
        // document.querySelector('.status').classList.add('bg-success');
        content = get_link;
        addImg(content);
        // imgProjeto.src = content;
    }
};

function publicarProjeto() {
    var nomeProjeto = document.getElementById("nomeProjeto").value;
    var descricao = document.getElementById("descricao").value;

    sessionStorage.id1 = nomeProjeto;
    sessionStorage.id2 = descricao;
    sessionStorage.id = content;

    document.getElementById('nomeProjeto').value = '';
    document.getElementById('descricao').value = '';

    alert('Projeto Postado com sucesso!');
    // sessionStorage.descricao = descricao;
    // sessionStorage.nomeProjeto = nomeProjeto;

}

new Imgur({
    clientid: 'ed26193d18ed971', //You can change this ClientID
    callback: feedback
});