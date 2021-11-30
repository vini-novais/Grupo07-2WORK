/* FIM FUNÇÃO MENU */
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active');
}
/* FIM FUNÇÃO MENU */

/* FUNÇÃO MENSAGEM DE SAUDAÇÃO */
var usuario = sessionStorage.usuario_dev;
console.log(usuario);
if (sessionStorage == null) { } else {
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

/* FUNÇÃO PARA EDITAR E SALVAR BIOGRAFIA */
publicar.addEventListener('click', () => {

})

function salvarBiografia() {
    console.log("entrou na função");

    var textAreaBiografia = document.getElementById("biografia").value;

    axios.post(`http://localhost:8080/2work/login-dev`, {
        headers: { "Access-Control-Allow-Origin": "*", "crossorigin": true },
        "textAreaBiografia": biografia,
    }).then(response => {
        console.log('entrou' + response);
        sessionStorage.usuario_dev = JSON.stringify(response.data);
        console.log(sessionStorage.usuario_dev);
        // Session storage cache do navegador, stringify ta convertendo o json pra uma string
        // enquanto a sessionStorage estiver vazia, significa que o usuário não está autenticado
    }).catch(function (error) {
        console.log(error)
    })
}
/* FIM FUNÇÃO PARA EDITAR E SALVAR BIOGRAFIA */