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
const tel = document.getElementById('tel') // SELETOR DO CAMPO TELEFONE

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

/* SCRIPT MÁSCARA INPUT CNPJ */
function mascaraCNPJ(i) {
    var v = i.value;

    if (isNaN(v[v.length - 1])) { // IMPEDE ENTRAR OUTRO CARACTERE QUE NÃO SEJA NÚMERO
        i.value = v.substring(0, v.length - 1);
        return;
    }

    i.setAttribute("maxlength", "18");
    if (v.length == 2 || v.length == 6) i.value += ".";
    if (v.length == 10) i.value += "/";
    if (v.length == 15) i.value += "-";
}
/* FIM SCRIPT MÁSCARA INPUT CNPJ */