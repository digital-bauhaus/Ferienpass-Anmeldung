import axios from 'axios';

export const AXIOS = axios.create({
  baseURL: 'https://ferienpass-admin.herokuapp.com/api',
  headers: {
    'Access-Control-Allow-Origin': 'https://ferienpass-anmeldung.herokuapp.com'
  }
});
