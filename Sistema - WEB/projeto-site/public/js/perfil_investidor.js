/* FIM FUNÇÃO MENU */
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active');
}
/* FIM FUNÇÃO MENU */

/* FUNÇÃO MENSAGEM DE SAUDAÇÃO */
var usuario = sessionStorage.usuario_dev;
console.log(usuario);
if (sessionStorage == null) {
} else {
    let nomeUsuario = JSON.parse(usuario).nome; // o Parse serve para pegar apenas um campo do JSON
    let emailUsuario = JSON.parse(usuario).email;
    let telefoneUsuario = JSON.parse(usuario).telefone;
    let cidadeUsuario = JSON.parse(usuario).cidade;
    let estadoUsuario = JSON.parse(usuario).estado;
    let biografiaUsuario = JSON.parse(usuario).biografia;
    
    msgSaudacao.innerHTML = `<p style="color:black">Olá, ${nomeUsuario.split(" ")[0]}!</p>`;
    nomeMenu.innerHTML = `<p style="color:black">Olá, ${nomeUsuario.split(" ")[0]}!</p>`; 
    nomeDoInv.innerHTML = `<p style="color:black">Olá, ${nomeUsuario.split(" ")[0]}!</p>`;
    campoEmailInv.innerHTML = `<p style="color:black">${emailUsuario}!</p>`;
    campoTelefoneInv.innerHTML = `<p style="color:black">${telefoneUsuario}!</p>`;
    campoCidadeInv.innerHTML = `<p style="color:black">${cidadeUsuario}!</p>`;
    campoEstadoInv.innerHTML = `<p style="color:black">${estadoUsuario}!</p>`;
    biografiaDoInv.innerHTML = `<p style="color:black">${biografiaUsuario}!</p>`;
}
/* FIM FUNÇÃO MENSAGEM DE SAUDAÇÃO */
