import React from "react";
import imgDev from '../img/undraw_Code_thinking_re_gka2 (1).png';

function ContainerHome() {
    return (
        <>
            <section class="section_welcome" id="section_welcome">
                <div class="container2Work">
                    <div class="content2Work">
                        <h3>Olá Vitor</h3>
                        <h1>Faça o upload de seu Projeto!</h1>
                        <p>O painel do projeto é um recurso exclusivo para contratos de trabalho. É perfeito para freelancers,
                            agências e moonlighters na 2Work.
                        </p>
                        <button class="btn_projeto">Crie um projeto Gratis!</button>
                    </div>
                    <img src={imgDev} class="imgDev" />
                </div>
            </section>
        </>
    );
}
export default ContainerHome;