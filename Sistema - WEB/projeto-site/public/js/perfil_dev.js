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
    let devEspecialidade = JSON.parse(usuario).especialidade;
    let emailUsuario = JSON.parse(usuario).email;
    let telefoneUsuario = JSON.parse(usuario).telefone;
    let cidadeUsuario = JSON.parse(usuario).cidade;
    let estadoUsuario = JSON.parse(usuario).estado;
    let biografiaUsuario = JSON.parse(usuario).biografia;
    msgSaudacao.innerHTML = `<p style="color:black">${nomeUsuario}!</p>`;
    nomeDoDev.innerHTML = `<p style="color:black">${nomeUsuario}!</p>`;
    especialidadeMsg.innerHTML = `<p style="color:black">${devEspecialidade}!</p>`;
    campoEmail.innerHTML = `<p style="color:black">${emailUsuario}!</p>`;
    campoTelefone.innerHTML = `<p style="color:black">${telefoneUsuario}!</p>`;
    campoCidade.innerHTML = `<p style="color:black">${cidadeUsuario}!</p>`;
    campoEstado.innerHTML = `<p style="color:black">${estadoUsuario}!</p>`;
    biografiaDoDev.innerHTML = `<p style="color:black">${biografiaUsuario}!</p>`;
}
/* FIM FUNÇÃO MENSAGEM DE SAUDAÇÃO */