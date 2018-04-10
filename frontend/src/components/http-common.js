import axios from 'axios';

export const AXIOS = axios.create({
  baseURL: '/api',
  headers: {
    'Access-Control-Allow-Origin': 'https://ferienpass-admin.herokuapp.com'
  }
});
