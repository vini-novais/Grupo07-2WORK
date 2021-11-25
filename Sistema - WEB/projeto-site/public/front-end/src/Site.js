$(window).scroll(function () {
    var scroll = $(window).scrollTop();

    if (scroll > 500) {
        $('.header2Work').css('background-color', '#08376B')
        $('.header2Work').css('box-shadow', '0px 4px 4px rgba(0, 0, 0, 0.25');
    } else {
        $('.header2Work').css('background-color', 'transparent', 'box-shadow', 'none');
        $('.header2Work').css('box-shadow', 'none');
    }
});

const pInicio = function () {
    if (pInicio && section_welcome) {
        navbar.style.backgroundColor = `transparent`;
        navbar.style.transition = `0.5s`;
    }
}

const pProjetos = function () {
    navbar.style.backgroundColor = `#08376B`;
    navbar.style.transition = `0.5s`;
}

const SobreNos = function () {
    navbar.style.backgroundColor = `#08376B`;
    navbar.style.transition = `0.5s`;
}