import { createRouter, createWebHistory, type RouteRecordRaw } from "vue-router";
const routes: RouteRecordRaw[] = [
  {
    path: "/",
    name: "home",
    component: () => import("../pages/Main.vue"),
  },
  {
    path: "/auth",
    name: "auth",
    component: () => import("../pages/Auth.vue"),
  },
  {
    path: "/game",
    name: "game",
    component: () => import("../pages/Game.vue"),
  }
];
const router = createRouter({
  history: createWebHistory(),
  routes,
})
export default router