/* SCRIPT ANIMAÇÃO */
var btnSignin = document.querySelector("#signin");
var btnSignup = document.querySelector("#signup");
var body = document.querySelector("body");

btnSignin.addEventListener("click", function () {
    body.className = "sign-in-js";
});

btnSignup.addEventListener("click", function () {
    body.className = "sign-up-js";
})
/* FIM SCRIPT ANIMAÇÃO */

/* SCRIPT MÁSCARA INPUT TELEFONE */
const tel = document.getElementById('telefone') // SELETOR DO CAMPO TELEFONE

tel.addEventListener('keypress', (e) => mascaraTelefone(e.target.value)) // DISPARA QUANDO DIGITADO NO CAMPO
tel.addEventListener('change', (e) => mascaraTelefone(e.target.value)) // DISPARA QUANDO AUTOCOMPLETADO O CAMPO

const mascaraTelefone = (valor) => {
    valor = valor.replace(/\D/g, "")
    valor = valor.replace(/^(\d{2})(\d)/g, "($1) $2")
    valor = valor.replace(/(\d)(\d{4})$/, "$1-$2")
    tel.value = valor // INSERE O(S) VALOR(ES) NO CAMPO
}
/* FIM SCRIPT MÁSCARA INPUT TELEFONE */

/* SCRIPT MÁSCARA INPUT CPF */
function mascaraCPF(i) {
    var v = i.value;

    if (isNaN(v[v.length - 1])) { // IMPEDE ENTRAR OUTRO CARACTERE QUE NÃO SEJA NÚMERO
        i.value = v.substring(0, v.length - 1);
        return;
    }

    i.setAttribute("maxlength", "14");
    if (v.length == 3 || v.length == 7) i.value += ".";
    if (v.length == 11) i.value += "-";
}
/* FIM SCRIPT MÁSCARA INPUT CPF */

/* VALIDAÇÃO DE CADASTRO (NOME) */
function validarNomeDesenvolvedor() {
    let nome = document.getElementById('nome');
    if ((nome.value).length < 3) {
        nome.style = `border-color: red`;
    } else {
        nome.style = `border-color: green`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (NOME) */

/* VALIDAÇÃO DE CADASTRO (CIDADE) */
function validarCidadeDesenvolvedor() {
    let cidade = document.getElementById('cidade');
    if ((cidade.value).length < 3) {
        cidade.style = `border-color: red`;
    } else {
        cidade.style = `border-color: green`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (CIDADE) */

/* VALIDAÇÃO DE CADASTRO (TELEFONE) */
function validarTelefoneDesenvolvedor() {
    if ((telefone.value).length == 15) {
        telefone.style = `border-color: green`;
    } else {
        telefone.style = `border-color: red`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (TELEFONE) */

/* VALIDAÇÃO DE CADASTRO (SENHA) */
function validarSenha1() {
    var senha_1 = senha1.value;
    if (senha_1.length >= 5) {
        senha1.style = `border-color: green`;
    } else {
        senha1.style = `border-color: red`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (SENHA) */

/* VALIDAÇÃO DE CADASTRO (CONFIRMAR SENHA) */
function validarSenha2() {
    var senha_2 = senha2.value;
    if (senha_2 == senha1.value) {
        senha2.style = `border-color: green`;
    } else {
        senha2.style = `border-color: red`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (CONFIRMAR SENHA) */

/* VALIDAÇÃO DE CADASTRO (CPF) */
function validarCPFDesenvolvedor() {
    if ((cpf.value).length == 14) {
        cpf.style = `border-color: green`;
    } else {
        cpf.style = `border-color: red`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (CPF) */

/* VALIDAÇÃO DE CADASTRO (E-MAIL) */
function validarEmailDesenvolvedor() {
    var email1 = email.value;
    if (email1.includes('@') == true && email1.includes('.com') == true) {
        email.style = `border-color: green`;
    } else {
        email.style = `border-color:red`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (E-MAIL) */

/* VALIDAÇÃO DE CADASTRO (COMPETÊNCIA) */
function validarCompetenciaDesenvolvedor() {
    let competencia = document.getElementById('competencia');
    if ((competencia.value).length < 5) {
        competencia.style = `border-color: red`;
    } else {
        competencia.style = `border-color: green`;
    }
}
/* FIM VALIDAÇÃO DE CADASTRO (COMPETÊNCIA) */

/* VALIDAÇÃO DE LOGIN (E-MAIL) */
function validarEmailDesenvolvedorLogin() {
    var email2 = emailLogin.value;
    if (email2.includes('@') == true && email2.includes('.com') == true) {
        emailLogin.style = `border-color: green`;
    } else {
        emailLogin.style = 'border-color:red';
    }
}
/* VALIDAÇÃO DE LOGIN (E-MAIL) */

/* VALIDAÇÃO DE LOGIN (SENHA) */
function validarSenhaLogin() {
    var senha_3 = senhaLogin.value;
    if (senha_3.length >= 5) {
        senhaLogin.style = `border-color: green`;
    } else {
        senhaLogin.style = `border-color:red`;
    }
}
/* FIM VALIDAÇÃO DE LOGIN (SENHA) */

/* FUNÇÃO EXIBIR E OCULTAR SENHA (CADASTRO) */
const password = document.getElementById('senha1');
const toggle = document.getElementById('toggle');

function showHide() {
    if (password.type === 'password') {
        password.setAttribute('type', 'text');
        toggle.classList.add('hide')
    } else {
        password.setAttribute('type', 'password');
        toggle.classList.remove('hide')
    }
}
/* FIM FUNÇÃO EXIBIR E OCULTAR SENHA (CADASTRO) */

/* FUNÇÃO EXIBIR E OCULTAR, CONFIRMAR SENHA (CADASTRO) */
const passwordd = document.getElementById('senha2');
const togglee = document.getElementById('toggle-confirmar');

function showHidee() {
    if (passwordd.type === 'password') {
        passwordd.setAttribute('type', 'text');
        togglee.classList.add('hide')
    } else {
        passwordd.setAttribute('type', 'password');
        togglee.classList.remove('hide')
    }
}
/* FIM FUNÇÃO EXIBIR E OCULTAR, CONFIRMAR SENHA (CADASTRO) */

/* FUNÇÃO EXIBIR E OCULTAR SENHA (LOGIN) */
const passworddd = document.getElementById('senhaLogin');
const toggleee = document.getElementById('toggle-login');

function showHideee() {
    if (passworddd.type === 'password') {
        passworddd.setAttribute('type', 'text');
        toggleee.classList.add('hide')
    } else {
        passworddd.setAttribute('type', 'password');
        toggleee.classList.remove('hide')
    }
}
/* FIM FUNÇÃO EXIBIR E OCULTAR SENHA (LOGIN) */

/* FUNÇÃO PARA ENVIAR O CADASTRO AO BD (AZURE) */
function cadastrar() {
    var entrar = new URLSearchParams(new FormData(formulario));
    console.log("cheguei aqui", entrar);
    fetch("/usuarios/cadastrar", {
        method: "POST",
        body: entrar
    }).then(function (response) {
        if (response.ok) {
            window.location.href = 'login_cadastro_desenvolvedor.html';
        } else {
            console.log('Erro de cadastro!');
            response.text().then(function (resposta) {
                div_erro.innerHTML = resposta;
            });
        }
    });
    return false;
}
/* FIM FUNÇÃO PARA ENVIAR O CADASTRO AO BD (AZURE) */