import React from 'react'
import './style.css'
import Logo from '../../components/LogoUnicentro/logoUnicentro';
import { Link } from 'react-router-dom';

const LandingPage = () => {
    return(
        <div className='landing-container'>
            <header className='navbar'>
                <Logo />
                <nav className='nav-links'>
                    <a href='#sobre'>Sobre</a>
                    <a href='#contato'>Contato</a>
                </nav>

                <Link to="/login"><button className='login-btn'>FAZER LOGIN</button></Link>
            </header>

            <main className='content-landing'>
                <h1>VIVOXI - Vivendo com Oxigênio</h1>
                <p>Inovação no acompanhamento respiratório: do papel para o digital, do cuidado para a vida.</p>
            </main>
        </div>
    );
};

export default LandingPage;


