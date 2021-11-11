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
  //BOTÃO CURTIDA
  $(document).ready(function() {
      $('.contentButton').click(function() {
          $('.contentButton').toggleClass("heartButton-active")
          $('.textButton').toggleClass("heartButton-active")
          $('.heartButton').toggleClass("heartButton-active")
      });
  });

  //CARROSEL IMAGEM PROJETOS
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
      imagem.style.marginLeft = -49 * atual + 'vw';
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