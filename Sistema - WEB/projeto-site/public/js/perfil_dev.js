/* FIM FUNÇÃO MENU */
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active');
}
/* FIM FUNÇÃO MENU */

/* FUNÇÃO MENSAGEM DE SAUDAÇÃO */
var usuario = sessionStorage.getItem('nome');
console.log(usuario);
if (usuario == null) {
    alert("Você não está logado, faça seu login!");
} else {
    msgSaudacao.innerHTML = `<p style="color:black">${usuario}</p>`;
}
/* FIM FUNÇÃO MENSAGEM DE SAUDAÇÃO */