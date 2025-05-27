import PrintBuser from './PrintBuser.js';
import AddBuser from './AddBuser.js';
import UpdateBuser from './UpdateBuser.js';
import PrintJikwon from './PrintJikwon.js';

const routes = [
    {path: '/', component: PrintBuser},
    {path: '/add',component:AddBuser},
    {path: '/update',component:UpdateBuser},
    {path: '/jikwon/', component : PrintJikwon},
];

const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes,
});

const app = Vue.createApp({});

app.use(router);
app.mount('#app');