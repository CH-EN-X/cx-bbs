// import axios from 'axios';
// import router from '../router';
//
// const instance = axios.create({
//     baseURL: 'https://your-api-domain.com',
//     timeout: 5000
// });
//
// instance.interceptors.response.use(
//     response => {
//         return response;
//     },
//     error => {
//         if (error.response && error.response.status === 401) {
//             router.push({
//                 name: 'login'})
//         }
//         return Promise.reject(error);
//     }
// );
//
// export default instance;
