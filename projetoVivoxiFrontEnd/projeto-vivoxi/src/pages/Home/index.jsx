import './style.css'
import api from '../../services/api'
import { useState, useEffect, useRef } from 'react';
import Unicentro from '../../assets/unicentro.png'
import { Link } from 'react-router-dom';

function Home() {
  
  const [users, setUsers] = useState([]);

  const inputName = useRef()
  const inputLogin = useRef()
  const inputPassword = useRef()
  const inputEmail = useRef()

  async function getUsers() {
    const usersFromApi = await api.get('/vivoxi/user/getUser');
    setUsers(usersFromApi.data);
  }

  async function createUsers() {
    try {
      await api.post('/vivoxi/user/createUser', {
        name: inputName.current.value,
        login: inputLogin.current.value,
        password: inputPassword.current.value,
        email: inputEmail.current.value
      });
      alert("Usuário cadastrado com sucesso! 🎉");
      getUsers(); // atualiza a lista automaticamente
    } catch (error) {
      alert("Erro ao cadastrar. Verifique a conexão com o banco.");
  }
}

  async function deleteUsers(id) {
    await api.delete(`/vivoxi/user/deleteUser/${id}`)
  }

  
  useEffect(() => {
    getUsers();
  }, []); // esse array vazio diz: pra rodar apenas uma vez ao carregar

  
  return (
    <div className='container'>

      <form>
        <h1>Cadastro de Usuário</h1>
        <input name='name' type='text' placeholder='Nome completo' ref={inputName}/>
        <input name='login' type='text' placeholder='Login'  ref={inputLogin}/>
        <input name='password' type='password' placeholder='Senha' ref={inputPassword} />
        <input name='email' type='email' placeholder='Email' ref={inputEmail}/>
        <button type='button' onClick={createUsers}>Cadastrar</button>
        <Link to="/login" className="link-login">Já tem conta? Faça o login</Link>
      </form>

      {users.map(user => (
        <div key={user.id} className='card'>
          <div>
            <p>Nome: <span>{user.name} </span></p>
            <p>Login: <span>{user.login}</span> </p>
            <p>Email: <span>{user.email}</span> </p>
          </div>
          <button onClick={() => deleteUsers(user.id)}>
            <p>Excluir</p>
          </button>
      </div>

      ))}
      

    </div>
  )
}

export default Home
