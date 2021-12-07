<template>
  <nav id="nav" class="sm:container sm:mx-auto">
    <!-- Header start -->
    <div
      class="z-10 max-w-screen-lg xl:max-w-screen-xl block sm:flex sm:justify-between sm:items-center my-6"
    >
      <!-- Header menu links and small screen humberger menu start -->
      <div class="flex justify-between items-center px-4 sm:px-0">
        <!-- Header logos start -->
        <div>
          <router-link to="/"
            ><img
              v-if="theme === 'light'"
              src="@/assets/images/hh_logo_dark4.png"
              class="w-36"
              alt="Dark Logo"
            />
            <img
              v-else
              src="@/assets/images/hh_logo_light4.png"
              class="w-36"
              alt="Light Logo"
            />
          </router-link>
        </div>
        <!-- Header logos end -->

        <!-- Theme switcher small screen start -->
        <theme-switcher
          :theme="theme"
          @themeChanged="updateTheme"
          class="block sm:hidden bg-ternary-light dark:bg-ternary-dark hover:bg-hover-light dark:hover:bg-hover-dark hover:shadow-sm px-2.5 py-2 rounded-lg ml-10"
        />
        <!-- Theme switcher small screen end -->

        <!-- Small screen humberger menu start -->
        <div class="sm:hidden">
          <button
            @click="isOpen = !isOpen"
            type="buttom"
            class="focus:outline-none"
            aria-label="Humberger Menu"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              class="h-7 w-7 fill-current text-secondary-dark dark:text-ternary-light"
            >
              <path
                v-if="isOpen"
                fill-rule="evenodd"
                d="M18.278 16.864a1 1 0 0 1-1.414 1.414l-4.829-4.828-4.828 4.828a1 1 0 0 1-1.414-1.414l4.828-4.829-4.828-4.828a1 1 0 0 1 1.414-1.414l4.829 4.828 4.828-4.828a1 1 0 1 1 1.414 1.414l-4.828 4.829 4.828 4.828z"
                clip-rule="evenodd"
              ></path>
              <path
                v-if="!isOpen"
                fill-rule="evenodd"
                d="M4 5h16a1 1 0 0 1 0 2H4a1 1 0 1 1 0-2zm0 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2zm0 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2z"
              ></path>
            </svg>
          </button>
        </div>
        <!-- Small screen humberger menu end -->
      </div>
      <!-- Header menu links and small screen humberger menu end -->

      <!-- Header links start -->
      <div
        :class="isOpen ? 'block' : 'hidden'"
        class="m-0 sm:ml-4 mt-5 sm:mt-3 sm:flex p-5 sm:p-0 justify-center items-center shadow-lg sm:shadow-none"
      >
        <router-link
          to="/map"
          class="block text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-secondary-dark dark:hover:text-secondary-light  sm:mx-4 mb-2 sm:py-2"
          aria-label="map"
          >SearchMap</router-link
        >
        <router-link
          to="/about"
          class="block text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-secondary-dark dark:hover:text-secondary-light  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
          aria-label="About Me"
          >About Me</router-link
        >
        <router-link
          to="/contact"
          class="block text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-secondary-dark dark:hover:text-secondary-light  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
          aria-label="Contact"
          >Contact</router-link
        >
        <router-link
          to="/qna"
          class="block text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-secondary-dark dark:hover:text-secondary-light  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
          aria-label="QnA"
          >QnA</router-link
        >
        <router-link
          v-if="memberInfo"
          to="/mypage"
          class="block text-left text-lg font-medium text-primary-dark dark:text-ternary-light hover:text-secondary-dark dark:hover:text-secondary-light  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
          aria-label="MyPage"
          >My Page</router-link
        >
      </div>
      <!-- Header links end -->
      <!-- <div class="sm:flex justify-between items-center flex-col md:flex-row">
        <div
          v-if="memberInfo"
          class="pl-8 block text-center text-base font-medium text-primary-dark dark:text-ternary-light hover:text-secondary-dark dark:hover:text-secondary-light  sm:mx-4 mb-2 sm:py-2 border-t-2 pt-3 sm:pt-2 sm:border-t-0 border-primary-light dark:border-secondary-dark"
        >
          <div class="avatar placeholder inline-block">
            <div
              class="block bg-neutral-focus text-neutral-content rounded-full w-8 h-8"
              style="background: #D4AF37;"
            >
              <span>{{ memberInfo.iduser.charAt(0).toUpperCase() }}</span>
            </div>
          </div>
          &nbsp;
          {{ memberInfo.name }}({{ memberInfo.iduser }}) 님 환영합니다.

          <button
            class="ml-8 inline-block text-left text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-md px-4 py-2 mt-2"
            @click.prevent="onClickLogout"
            aria-label="Hire Me Button"
          >
            Log Out
          </button>
        </div>

        <div
          v-else
          class="border-t-2 pt-3 sm:pt-0 sm:border-t-0 border-primary-light dark:border-secondary-dark"
        >
          <button
            class="sm:hidden block text-left text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-md px-4 py-2 mt-2"
            @click="showModal()"
            aria-label="Hire Me Button"
          >
            Log In
          </button>
        </div>
      </div> -->

      <!-- Header right section buttons start -->
      <div
        class="hidden sm:flex justify-between items-center flex-col md:flex-row"
      >
        <!-- Hire me button start -->
        <div
          v-if="memberInfo"
          class="border-t-2 pt-3 sm:pt-0 sm:border-t-0 border-primary-light dark:border-secondary-dark"
        >
          <div class="avatar placeholder inline-block">
            <div
              class="pt-1 bg-neutral-focus text-neutral-content rounded-full w-8 h-8"
              style="background: #D4AF37;"
            >
              <span>{{ memberInfo.iduser.charAt(0).toUpperCase() }}</span>
            </div>
          </div>
          <span class="ml-1 text-primary-dark dark:text-ternary-light"
            >{{ memberInfo.name }}({{ memberInfo.iduser }})님 환영합니다.</span
          >
          <button
            class="ml-8 mb-2 inline-block text-left text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-md px-4 py-2 mt-2"
            @click.prevent="onClickLogout"
            aria-label="Hire Me Button"
          >
            Log Out
          </button>
        </div>

        <div v-else>
          <button
            class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-2.5"
            @click="showModal()"
            aria-label="Hire Me Button"
          >
            Log In
          </button>
          <button
            class="ml-2 text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-2.5"
            @click="showRModal()"
            aria-label="Hire Me Button"
          >
            Sign Up
          </button>
        </div>
        <!-- Hire me button end -->

        <!-- Theme switcher largr screen start -->
        <theme-switcher
          :theme="theme"
          @themeChanged="updateTheme"
          class="ml-8 bg-primary-light dark:bg-ternary-dark px-3 py-2 shadow-sm rounded-xl cursor-pointer"
        />
        <!-- Theme switcher largr screen end -->
      </div>
      <!-- Header right section buttons stendart -->
    </div>
    <!-- Header end -->

    <!-- Log in modal start -->
    <member-login-modal
      :showModal="showModal"
      :modal="modal"
      :categories="categories"
      aria-modal="Log in Modal"
    />
    <!-- Log in modal end -->

    <!-- Sign up modal start -->
    <member-signup-modal
      :showModal="showRModal"
      :modal="rmodal"
      :categories="categories"
      aria-modal="Sign up Modal"
    />
    <!-- Sign up modal end -->
  </nav>
</template>

<script>
import ThemeSwitcher from "./ThemeSwitcher";
import MemberLoginModal from "@/components/member/MemberLoginModal.vue";
import MemberSignupModal from "@/components/member/MemberSignupModal.vue";
import feather from "feather-icons";

import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  components: {
    ThemeSwitcher,
    MemberLoginModal,
    MemberSignupModal,
  },
  data() {
    return {
      isOpen: false,
      theme: "",
      modal: false,
      rmodal: false,
      categories: [
        {
          id: 1,
          value: "web",
          name: "Web Application",
        },
        {
          id: 2,
          value: "mobile",
          name: "Mobile Applicaiton",
        },
        {
          id: 3,
          value: "ui-ux",
          name: "UI/UX Design",
        },
        {
          id: 4,
          value: "branding",
          name: "Branding",
        },
      ],
    };
  },

  created() {
    this.theme = localStorage.getItem("theme") || "light";
  },
  mounted() {
    feather.replace();
    this.theme = localStorage.getItem("theme") || "light";
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "memberInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, [
      "SET_IS_LOGIN",
      "SET_IS_LOGIN_ERROR",
      "SET_MEMBER_INFO",
    ]),
    onClickLogout() {
      this.SET_IS_LOGIN(false);
      this.SET_MEMBER_INFO(null);
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$route.push({ name: "Home" });
    },

    updateTheme(theme) {
      this.theme = theme;
    },

    showModal() {
      this.SET_IS_LOGIN_ERROR(false);

      if (this.modal) {
        // Stop screen scrolling
        document
          .getElementsByTagName("html")[0]
          .classList.remove("overflow-y-hidden");
        this.modal = false;
      } else {
        document
          .getElementsByTagName("html")[0]
          .classList.add("overflow-y-hidden");
        this.modal = true;
      }
    },
    showRModal() {
      this.SET_IS_LOGIN_ERROR(false);

      if (this.rmodal) {
        // Stop screen scrolling
        document
          .getElementsByTagName("html")[0]
          .classList.remove("overflow-y-hidden");
        this.rmodal = false;
      } else {
        document
          .getElementsByTagName("html")[0]
          .classList.add("overflow-y-hidden");
        this.rmodal = true;
      }
    },
  },
  updated() {
    feather.replace();
  },
};
</script>

<style scoped>
#nav a.router-link-exact-active {
  @apply text-indigo-700;
  @apply dark:text-indigo-400;
  @apply font-medium;
}
</style>
