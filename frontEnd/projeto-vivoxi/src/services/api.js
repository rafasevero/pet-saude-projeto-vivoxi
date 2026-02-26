import axios from 'axios'

const api = axios.create({
    baseURL: 'http://localhost:8080'  //endereco onde esta o backend
})

export default api