/* FIM FUNÇÃO MENU */
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active');
}
/* FIM FUNÇÃO MENU */

/* FUNÇÃO MENSAGEM DE SAUDAÇÃO */
var usuario = sessionStorage.usuario_dev;
console.log(usuario);
if (sessionStorage == null) {} else {
    let nomeUsuario = JSON.parse(usuario).nome; // o Parse serve para pegar apenas um campo do JSON
    let devEspecialidade = JSON.parse(usuario).especialidade;
    let emailUsuario = JSON.parse(usuario).email;
    let telefoneUsuario = JSON.parse(usuario).telefone;
    let cidadeUsuario = JSON.parse(usuario).cidade;
    let estadoUsuario = JSON.parse(usuario).estado;
    let biografiaUsuario = JSON.parse(usuario).biografia;

    nomeMenu.innerHTML = `${nomeUsuario.split(" ")[0]}`;
    nomeDoDev.innerHTML = `${nomeUsuario}`;
    especialidadeMsg.innerHTML = `${devEspecialidade}.`;
    campoEmail.innerHTML = `${emailUsuario}`;
    campoTelefone.innerHTML = `${telefoneUsuario}`;
    campoCidade.innerHTML = `${cidadeUsuario}.`;
    campoEstado.innerHTML = `${estadoUsuario}.`;
    biografiaDoDev.innerHTML = `<p style="color:black">${biografiaUsuario}</p>`;
    msgSaudacao.innerHTML = `<span style="color:black">Olá, ${nomeUsuario.split(" ")[0]}!</span>`;
}
/* FIM FUNÇÃO MENSAGEM DE SAUDAÇÃO */

function editarBiografia() {
    biografiaDoInv.style.display = "block";
    editarPerfil.style.display = "none";
    salvarPerfil.style.display = "block";
}

function atualizarBiografia() {
    biografiaDoInv.style.display = "none";
    editarPerfil.style.display = "block";
    salvarPerfil.style.display = "none";
}