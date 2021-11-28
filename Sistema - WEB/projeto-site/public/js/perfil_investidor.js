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
    let emailUsuario = JSON.parse(usuario).email;
    let telefoneUsuario = JSON.parse(usuario).telefone;
    let cidadeUsuario = JSON.parse(usuario).cidade;
    let estadoUsuario = JSON.parse(usuario).estado;
    let biografiaUsuario = JSON.parse(usuario).biografia;

    nomeMenu.innerHTML = `${nomeUsuario.split(" ")[0]}`;
    nomeDoInv.innerHTML = `${nomeUsuario}`;
    campoEmailInv.innerHTML = `${emailUsuario}`;
    campoTelefoneInv.innerHTML = `${telefoneUsuario}`;
    campoCidadeInv.innerHTML = `${cidadeUsuario}`;
    campoEstadoInv.innerHTML = `${estadoUsuario}`;
    biografiaDoInv.innerHTML = `<p style="color:black">${biografiaUsuario}</p>`;
    msgSaudacao.innerHTML = `<span style="color:black">Olá, ${nomeUsuario.split(" ")[0]}!</span>`;
}
/* FIM FUNÇÃO MENSAGEM DE SAUDAÇÃO */