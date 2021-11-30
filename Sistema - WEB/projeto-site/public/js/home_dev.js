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
    window.location.href = 'login_cadastro_desenvolvedor.html';
} else {
    let nomeUsuario = JSON.parse(usuario).nome; // o Parse serve para pegar apenas um campo do JSON 
    msgSaudacao.innerHTML = `<p style="color:black">Olá, ${nomeUsuario.split(" ")[0]}!</p>`;
    nomeMenu.innerHTML = `${nomeUsuario.split(" ")[0]}`;
}
/* FIM FUNÇÃO MENSAGEM DE SAUDAÇÃO */

/* FUNÇÃO SISTEMA DE BUSCA */
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
/* FUNÇÃO SISTEMA DE BUSCA */

/* FUNÇÃO MODAL PROJETOS */
// Get DOM Elements
const modal = document.querySelector('#my-modal');
const modalBtn = document.querySelector('#modal-btn');
const closeBtn = document.querySelector('.close');

// Events
modalBtn.addEventListener('click', openModal);
closeBtn.addEventListener('click', closeModal);
window.addEventListener('click', outsideClick);

// Open
function openModal() {
    modal.style.display = 'block';
}

// Close
function closeModal() {
    modal.style.display = 'none';
}

// Close If Outside Click
function outsideClick(e) {
    if (e.target == modal) {
        modal.style.display = 'none';
    }
}
// BOTÃO CURTIDA
$(document).ready(function () {
    $('.contentButton').click(function () {
        $('.contentButton').toggleClass("heartButton-active")
        $('.textButton').toggleClass("heartButton-active")
        $('.heartButton').toggleClass("heartButton-active")
    });
});

// CARROSEL IMAGEM PROJETOS
var balls = document.querySelector('.balls');
var quant = document.querySelectorAll('.slides .image');
var atual = 0;
var imagem = document.getElementById('atual');
var avancar = document.getElementById('avancar');
var voltar = document.getElementById('voltar');
var rolar = true;

for (let i = 0; i < quant.length; i++) {
    var div = document.createElement('div');
    div.id = i;
    balls.appendChild(div);
}
document.getElementById('0').classList.add('imgAtual');

var pos = document.querySelectorAll('.balls div')

for (let i = 0; i < pos.length; i++) {
    pos[i].addEventListener('click', () => {
        atual = pos[i].id
        slide()
        rolar = false
    })
}

voltar.addEventListener('click', () => {
    atual--
    slide()
    rolar = false
})

avancar.addEventListener('click', () => {
    atual++
    rolar = false
    slide();
})

function slide() {
    if (atual >= quant.length) {
        atual = 0;
    } else if (atual < 0) {
        atual = quant.length - 1;
    }
    document.querySelector('.imgAtual').classList.remove('.imgAtual');
    imagem.style.marginLeft = -48.7 * atual + 'vw';
    document.getElementById(atual).classList.add('imgAtual');
}

setInterval(() => {
    if (rolar) {
        atual++
        slide()
    } else {
        rolar = true
    }
}, 4000)
/* FIM FUNÇÃO MODAL PROJETOS */