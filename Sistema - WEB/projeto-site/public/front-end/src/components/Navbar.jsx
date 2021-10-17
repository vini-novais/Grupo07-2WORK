import React from "react";
import logo from '../img/White on Transparent.png';

function Navbar() {
    return (
        <>
            <div id="navbar" class="header">
                <div class="container">
                    <div class="logo-header">
                        <a href="#section_welcome"> <img src={logo} class="logo" /></a>
                    </div>
                    <div class="nav">
                        <ul>
                            <li><a onclick="pInicio()" href="#section_welcome">Início</a></li>
                            <li><a onclick="pProjetos()" href="#section_projetos">Projetos</a></li>
                            <li><a onclick="SobreNos()" href="#section_sobreNos">Sobre Nós</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Navbar;