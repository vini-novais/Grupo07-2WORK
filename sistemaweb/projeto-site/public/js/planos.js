/* FIM FUNÇÃO MENU */
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active');
}

var usuario = sessionStorage.usuario_dev;
let nomeUsuario = JSON.parse(usuario).nome; // o Parse serve para pegar apenas um campo do JSON

nomeMenu.innerHTML = `${nomeUsuario.split(" ")[0]}`;
/* FIM FUNÇÃO MENU */