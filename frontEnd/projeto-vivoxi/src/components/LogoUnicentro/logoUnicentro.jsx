import React from 'react';
import Unicentro from '../../assets/unicentro.png';
import './style.css'; // Um CSS específico para a logo

const Logo = () => {
    return (
        <div className='logo-container'>
            <img src={Unicentro} alt='Unicentro Logo' className='logo-img'/>
        </div>
    );
};

export default Logo;