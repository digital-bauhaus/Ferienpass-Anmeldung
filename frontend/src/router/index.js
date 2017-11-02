import Vue from 'vue';
import Router from 'vue-router';
import Registration from '@/components/Registration';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Anmeldung',
      component: Registration
    }
  ]
});
