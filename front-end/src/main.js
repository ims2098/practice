import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css';
import { createRouter, createWebHistory } from 'vue-router';
import ProfessionList from './components/pages/profession/ProfessionList';
import ProfessionCreate from './components/pages/profession/ProfessionCreate';
import ProfessionEdit from './components/pages/profession/ProfessionEdit';
import ProfessionShow from './components/pages/profession/ProfessionShow';
import PersonList from './components/pages/person/PersonList';
import PersonCreate from './components/pages/person/PersonCreate';
import PersonEdit from './components/pages/person/PersonEdit';
import PersonShow from './components/pages/person/PersonShow';
import DepartmentList from './components/pages/department/DepartmentList'
import DepartmentCreate from './components/pages/department/DepartmentCreate'
import DepartmentEdit from './components/pages/department/DepartmentEdit'
import DepartmentShow from './components/pages/department/DepartmentShow'
 
const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/profession/', component: ProfessionList },
    { path: '/profession/create', component: ProfessionCreate },
    { path: '/profession/edit/:id', component: ProfessionEdit },
    { path: '/profession/show/:id', component: ProfessionShow },
    { path: '/person/', component: PersonList },
    { path: '/person/create', component: PersonCreate },
    { path: '/person/edit/:id', component: PersonEdit },
    { path: '/person/show/:id', component: PersonShow },
    { path: '/department/', component: DepartmentList },
    { path: '/department/create', component: DepartmentCreate },
    { path: '/department/edit/:id', component: DepartmentEdit },
    { path: '/department/show/:id', component: DepartmentShow }
  ],
});

createApp(App).use(router).mount('#app')
