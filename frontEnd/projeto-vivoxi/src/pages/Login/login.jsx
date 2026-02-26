import { useRef } from 'react'
import api from '../../services/api'
import '../../pages/Home/style.css'
import { Link } from 'react-router-dom'
import Logo from '../../components/LogoUnicentro/logoUnicentro'

function Login() {
    const inputIdentifier = useRef()
    const inputPassword = useRef()

    async function makeLogin() {
        try {
            const response = await api.post('/vivoxi/user/login', {
                identifier: inputIdentifier.current.value,
                password: inputPassword.current.value
            })
            alert("Login realizado com sucesso!")
            console.log(response.data)
        } catch (error) {
            alert("Usuário ou senha incorretos")
        }
    }

    return (
        <div className='container'>
            <form>
                <h1>Login</h1>
                {/* Use type="text" para aceitar e-mail ou nickname */}
                <input name='identifier' type='text' placeholder='E-mail ou Login' ref={inputIdentifier} />
                <input name='password' type='password' placeholder='Senha' ref={inputPassword} />
                <button type='button' onClick={makeLogin}>Entrar</button>
                <Link to="/cadastro" className="link-login">Não é registrado? Faça o Cadastro</Link>    
            </form>
        </div>
    )
}

export default Login