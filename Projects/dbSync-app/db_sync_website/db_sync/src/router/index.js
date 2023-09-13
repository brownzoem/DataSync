// Composables
import { createRouter, createWebHistory } from 'vue-router'
import Dashboard from '@/views/Dashboard.vue'
import Tests from '@/views/Tests.vue'
import Tasks from '@/views/Tasks.vue'
const routes = [
  {
    path: '/',
    name: 'dashboard',
    component: Dashboard
  },
  {
    path: '/tests',
    name: 'tests',
    component: Tests
  },
  {
    path: '/tasks',
    name: 'tasks',
    component: Tasks
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router

// path: '/',
// component: () => import('@/layouts/default/Default.vue'),
// children: [
//   {
//     path: '',
//     name: 'Home',
//     // route level code-splitting
//     // this generates a separate chunk (about.[hash].js) for this route
//     // which is lazy-loaded when the route is visited.
//     component: () => import(/* webpackChunkName: "home" */ '@/views/Home.vue'),
//   },
// ],
