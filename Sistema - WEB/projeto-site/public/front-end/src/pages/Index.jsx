import React from "react";
import Site from '../Site';
import logo from '../img/White on Transparent.png';

function Index() {
    return (
        <>
            <div onClick="teste()" id="teste">
                Precisa de ajuda?
            </div>
            <script src="https://cdn.botframework.com/botframework-webchat/latest/webchat.js"></script>
            <iframe
                src='https://webchat.botframework.com/embed/qnabot2work-bot?s=Fm_wfhy4ygI.ZKK9SfZ1_l9zNEER1xMS0Qi7KUSwGykyR0lznh_oiw0'
                id="webchat" role="main">
            </iframe>
            <div id="navbar" class="header2Work">
                <div class="container2Work">
                    <div class="logo-header">
                        <a href="#section_welcome"><img src={logo} class="logo" /></a>
                    </div>
                    <div class="nav2Work">
                        <ul>
                            <li><a onclick="pInicio()" href="#section_welcome">Início</a></li>
                            <li><a onclick="pProjetos()" href="#section_projetos">Projetos</a></li>
                            <li><a onclick="SobreNos()" href="#section_sobreNos">Sobre Nós</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <section class="section_welcome" id="section_welcome">
                <div class="container2Work">
                    <div class="content2Work">
                        <h1>BEM VINDO A 2WORK</h1>
                        <p>Projetos são bem mais do que apenas linhas de código, são sonhos, acredite em seus sonhos! <br /> Venha
                            fazer parte dessa comunidade.
                        </p>
                        <div class="camposInfCorp">
                            <div class="camposInf">
                                <h2>Voce é um Desenvolvedor?</h2>
                                <div class="cardInf">
                                    <div class="imgBx">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    );
}

export default Index;