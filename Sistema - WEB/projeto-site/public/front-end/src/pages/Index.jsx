import React from "react";
import logo from '../img/White on Transparent.png';
import iconCards from '../img/icon-2Work.png';
import projeto1 from '../img/projeto-1.png';
import projeto2 from '../img/projeto-2.jpg';
import projeto3 from '../img/projeto-3.png';
import projeto4 from '../img/projeto-4.png';
import projeto5 from '../img/projeto-5.png';
import projeto6 from '../img/projeto-6.png';
import projeto7 from '../img/projeto-7.png';
import projeto8 from '../img/projeto-8.png';
import desenhoSolucao from '../img/Desen.png';

function Index() {

    function inicio() {
        const navbar = window.document.getElementById('navbar');

        navbar.style.backgroundColor = `transparent`;
        navbar.style.transition = `0.5s`;
    }

    function projetos() {
        const navbar = window.document.getElementById('navbar');

        navbar.style.backgroundColor = `#08376B`;
        navbar.style.transition = `0.5s`;
    }

    function sobreNos() {
        const navbar = window.document.getElementById('navbar');

        navbar.style.backgroundColor = `#08376B`;
        navbar.style.transition = `0.5s`;
    }

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
                            <li><a onClick={inicio} href="#section_welcome">Início</a></li>
                            <li><a onClick={projetos} href="#section_projetos">Projetos</a></li>
                            <li><a onClick={sobreNos} href="#section_sobreNos">Sobre Nós</a></li>
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
                                        <img src={iconCards} class="iconCards" />
                                    </div>
                                    <div class="contentInf">
                                        <div>
                                            <h3>Enquanto dev você:</h3>
                                            <p>* Quer trazer uma maior visibilidade a seu projeto. <br /> * Tem intuito em
                                                colaborar em um projeto. <br />  * Buscar um reconhecimento pelo seu trabalho.
                                            </p>
                                            <a href="#">Cadastre-se</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="camposInf">
                                <h2>Você é um Investidor?</h2>
                                <div class="cardInf">
                                    <div class="imgBx">
                                        <img src={iconCards} class="iconCards" />
                                    </div>
                                    <div class="contentInf">
                                        <div>
                                            <h3>Enquanto investidor você:</h3>
                                            <p>* Quer trazer inovação para a sua empresa. <br /> * Precisa de uma ideia inovadora
                                                para competir no mercado. <br /> * Ter acesso a ideias que possam alavancar o seu
                                                negócio.
                                            </p>
                                            <a href="#">Cadastre-se</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="section_projetos" id="section_projetos">
                <div class="container2Work">
                    <div class="row-8">
                        <h1>Estes são alguns projetos que já estão em nossa plataforma!</h1>
                    </div>
                    <div class="row-4 linha-1">
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto1} class="projeto1" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">João Oliveira</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto2} class="projeto2" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">Caio Elcio</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto3} class="projeto3" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">Lucas Felix</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto4} class="projeto4" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">Lucas Felix</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-4 linha-1">
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto5} class="projeto5" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">Lucas Ferreira</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto6} class="projeto6" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">Luiz Gustavo</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto7} class="projeto7" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">Vinicius Novais</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-3 coluna-card">
                            <div>
                                <img class="card-img-top" src={projeto8} class="projeto8" />
                                <div class="card-body">
                                    <div class="row-informacoes-card">
                                        <p class="card-text">Caio Elcio</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="section_sobreNos" id="section_sobreNos">
                <div class="container2Work">
                    <div class="sobre_nos">
                        <div class="texto">
                            <h1>Buscamos trazer inspiração e inovação para todos!</h1>
                            <p>Somos uma empresa que acreditamos no poder de auxiliar os desenvolvedores a expor seus projetos e
                                assim promover a cultura de inovação no mercado da tecnologia. Através da 2WORK os
                                desenvolvedores poderam expor seus projetos e assim
                                como fazer publicações dos mesmos, no qual os iteressados poderão visualizar os mesmos e até
                                mesmo fechar um negócio através de um contrato com segurança.
                            </p>
                        </div>
                        <div class="imagem">
                            <img class="solucao" src={desenhoSolucao} />
                        </div>
                    </div>
                </div>
            </section>
            <footer>
                <div class="container-footer">
                    <div class="sec work">
                        <h2>2WORK</h2>
                        <p>
                            2WORK é a plataforma líder mundial para que desenvolvedores criativos compartilhem, cresçam e vendam
                            seus projetos. <br />
                            Trazendo maior visibilidade e probabilidade de sucesso para desenvolvedores autonomos
                            façam de suas projetos de gaveta, projetos que mudarão o mercado e a vida das pessoas que o
                            utilizarem
                            o mesmo.
                        </p>
                        <ul class="sci">
                            <li><a href="#"><i class="fa fa-whatsapp" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                            <li>
                                <a href="https://github.com/BandTec/3ADSB-2021-2-Grupo-07" target="_blank">
                                    <i class="fa fa-github" aria-hidden="true"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="sec localizacao">
                        <h2>Localização</h2>
                        <iframe src="https://maps.google.com/maps?q=bandtec&t=&z=13&ie=UTF8&iwloc=&output=embed"
                            style={{ width: '100%', height: '200px', border: '10px' }}
                            allowfullscreen="" loading="lazy">
                        </iframe>
                        <p><i class="fa fa-map-marker" aria-hidden="true"></i> Rua Haddock Lobo, 595 - Cerqueira César, São
                            Paulo - SP, 01414-001
                        </p>
                    </div>
                    <div class="sec contato">
                        <h2>Contato</h2>
                        <ul class="info">
                            <li>
                                <p><i class="fa fa-phone" aria-hidden="true"></i>
                                    <a href="tel:5511941282899"> +55 (11) 94128-2899</a>
                                </p>
                            </li>
                            <li>
                                <p><i class="fa fa-phone" aria-hidden="true"></i>
                                    <a href="tel:5511953930508"> +55 (11) 95393-0508</a>
                                </p>
                            </li>
                            <li>
                                <p><i class="fa fa-envelope" aria-hidden="true"></i>
                                    <a href="mailto:2Work@bandtec.com.br"> 2Work@bandtec.com.br</a>
                                </p>
                            </li>
                        </ul>
                    </div>
                </div>
            </footer>
            <div class="copyrightText">
                <p id="pFooter">Copyright © 2021 2WORK. Todos os direitos reservados.</p>
            </div>
        </>
    );
}

export default Index;