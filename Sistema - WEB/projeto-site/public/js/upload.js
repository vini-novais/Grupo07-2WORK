const form = document.querySelector("form"),
    fileInput = form.querySelector(".file-input"),
    progressArea = document.querySelector(".progress-area"),
    uploadedArea = document.querySelector(".uploaded-area");

/* QUANDO CLICAR NO ESPAÇO "Arraste e solte uma imagem" */
// ABRE O EXPLORADOR DE ARQUIVOS PARA SELECIONAR A IMAGEM ATRAVÉS DO EVENTO
// "addEvetListener"
form.addEventListener("click", () => {
    fileInput.click();
})
/* FIM EVENTO EXPLORADOR DE ARQUIVOS PARA SELECIONAR A IMAGEM */

fileInput.onchange = ({ target }) => {
    let file = target.files[0]; // ARQUIVO files[0], ISSO SIGNIFICA QUE SE O USUÁRIO SELECIONOU VÁRIOS ARQUIVOS, OBTENHA PRIMEIRO APENAS UM
    if (file) { // SE O ARQUIVO FOR SELECIONADO
        let fileName = file.name; // OBTENDO O NOME DO ARQUIVO SELECIONADO
        if (fileName.length >= 12) { // SE O COMPRIMENTO DO NOME DO ARQUIVO FOR MAIOR OU IGUAL A 12, DIVIDE O NOME E ADICIONE
            let splitName = fileName.split('.');
            fileName = splitName[0].substring(0, 12) + "... ." + splitName[1];
        }
        uploadFile(fileName); // CHAMAR uploadFile PASSANDO O NOME DO ARQUIVO COMO UM ARGUMENTO
    }
}

function uploadFile(name) {
    let xhr = new XMLHttpRequest(); // CRIANDO NOVO xml obj (AJAX)
    xhr.open("POST", "php/upload.php"); // ENVIAR SOLICITAÇÃO DE POSTAGEM PARA O URL / ARQUIVO ESPECIFICADO
    xhr.upload.addEventListener("progress", ({ loaded, total }) => {
        let fileLoaded = Math.floor((loaded / total) * 100); // OBTENDO PORCENTAGEM DO TAMANHO DO ARQUIVO CARREGADO
        let fileTotal = Math.floor(total / 1000); // OBTENDO O TAMANHO DO ARQUIVO EM KB A PARTIIR DE BYTES
        let fileSize;
        // SE O TAMANHO DO ARQUIVO FOR INFERIOR A 1024, ADICIONE APENAS KB, CASO CONTRÁRIO, CONVERTA O TAMANHO EM KB PARA MB
        (fileTotal < 1024) ? fileSize = fileTotal + "KB" : fileSize = (loaded / (1024 * 1024)).toFixed(2) + "MB";
        let progressHTML = `<li class="row">
                                <i class="fas fa-file-alt"></i>
                                <div class="content">
                                <div class="details">
                                    <span class="name">${name} ° Uploading</span>
                                    <span class="percent">${fileLoaded}%</span>
                                </div>
                                <div class="progress-bar">
                                    <div class="progress" style="width: ${fileLoaded}%"></div>
                                </div>
                                </div>
                            </li>`;
        uploadedArea.classList.add("onprogress");
        progressArea.innerHTML = progressHTML;
        if (loaded == total) {
            progressArea.innerHTML = "";
            let uploadedHTML = `<li class="row">
                                <div class="content">
                                    <i class="fas fa-file-alt"></i>
                                    <div class="details">
                                        <span class="name">${name} ° Uploaded</span>
                                        <span class="size">${fileSize}</span>
                                    </div>
                                </div>
                                <i class="fas fa-check"></i>
                            </li>`;
            uploadedArea.classList.remove("onprogress");
            uploadedArea.insertAdjacentHTML("afterbegin", uploadedHTML);
        }
    });
    let formData = new FormData(form); // formData É UM OBJETO PARA ENVIAR DADOS DE UM FORMULÁRIO FACILMENTE
    xhr.send(formData); // ENVIANDO DADOS DE UM FORMULÁRIO PARA PHP
}

/* FIM FUNÇÃO MENU */
function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active');
}
/* FIM FUNÇÃO MENU */