/* FUNÇÃO MENU */
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active');
}
/* FIM FUNÇÃO MENU */

/* FUNÇÃO MENSAGEM DE SAUDAÇÃO */
var usuario = sessionStorage.usuario_dev;
console.log(usuario);
if (sessionStorage == null) {
    alert("Você não está logado, faça seu login!");
    window.location.href = 'login_cadastro_investidor.html';
} else {
    let nomeUsuario = JSON.parse(usuario).nome; // o Parse serve para pegar apenas um campo do JSON 
    msgSaudacao.innerHTML = `<p style="color:black">Olá, ${nomeUsuario.split(" ")[0]}!</p>`;
}
/* FIM FUNÇÃO MENSAGEM DE SAUDAÇÃO */