import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
});

/**
 * Realiza uma requisição ao back-end
 * 
 * @param {String} url 
 * @param {Method} method 
 * @param {any} data 
 * @returns AxiosResponse
 */
const doRequest = async (url, method = 'GET', data = undefined) => {
  return await api.request({ url, method, data });
}

export default { doRequest };