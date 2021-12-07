import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "./assets/css/tailwind.css";
import "./assets/css/app.css";
import "./assets/css/map.css";
import BackToTop from "vue-backtotop";
import store from "./store";
import VueApexCharts from "vue3-apexcharts";

const feather = require("feather-icons");
feather.replace();

createApp(App)
  .use(store)
  .use(router)
  .use(BackToTop)
  .use(VueApexCharts)
  .mount("#app");

const appTheme = localStorage.getItem("theme");

// Check what is the active theme
if (
  appTheme === "dark" &&
  document.querySelector("body").classList.contains("app-theme")
) {
  document.querySelector("body").classList.add("bg-primary-dark");
} else {
  document.querySelector("body").classList.add("bg-secondary-light");
}
