<template>
  <!-- Banner start -->
  <section
    class="flex flex-col sm:justify-between items-center sm:flex-row mt-12 sm:mt-24"
  >
    <div class="w-full sm:w-1/2 text-left">
      <h1
        class="text-2xl sm:text-4xl text-center sm:text-left font-semibold text-ternary-dark dark:text-primary-light uppercase"
      >
        행복한 집 구하기, 해피하우스
      </h1>
      <p
        class="mt-4 text-xl sm:text-3xl text-center sm:text-left font-semibold leading-none text-gray-400"
      >
        원룸, 오피스텔, 빌라, 아파트까지!<br />
        행복한 집, 이제 해피하우스에서 구해보세요
      </p>
      <div class="flex justify-center sm:block" @click="mvMap">
        <a
          class="flex justify-center items-center w-36 sm:w-48 mt-12 mb-6 sm:mb-0 text-lg border border-indigo-200 dark:border-ternary-dark py-2.5 sm:py-3 shadow-lg rounded-xl bg-indigo-50 focus:ring-1 focus:ring-indigo-900 hover:bg-indigo-500 text-gray-500 hover:text-white"
          aria-label="Download Resume"
        >
          <i
            data-feather="home"
            class="ml-0 sm:ml-1 mr-2 sm:mr-3 w-5 sm:w-6"
          ></i>
          <span class="text-sm sm:text-lg">집보러 가기</span></a
        >
      </div>
    </div>
    <div class="w-full sm:w-1/2 text-right float-right mt-8 sm:mt-0">
      <img
        v-if="theme === 'light'"
        src="@/assets/images/house.png"
        alt="Developer"
      />
      <img v-else src="@/assets/images/house.png" alt="Developer" />
    </div>
  </section>
  <!-- Banner end -->
</template>

<script>
import feather from "feather-icons";

export default {
  name: "Home",
  data: () => {
    return {
      theme: "",
    };
  },
  created() {
    this.theme = localStorage.getItem("theme") || "light";
  },
  mounted() {
    feather.replace();
    this.theme = localStorage.getItem("theme") || "light";
  },
  updated() {
    feather.replace();
  },
  methods: {
    mvMap() {
      this.$router.push({ name: "Map" });
    },
  },
};
</script>

<style scoped></style>
