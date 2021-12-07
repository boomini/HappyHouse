<template>
  <section class="pt-20 sm:pt-28">
    <div class="text-center">
      <p
        class="text-2xl sm:text-5xl font-semibold mb-3 text-ternary-dark dark:text-ternary-light"
      >
        {{ myPageHeading }}
      </p>
      <p class="text-md sm:text-xl text-gray-500 dark:text-ternary-light">
        {{ myPageDescription }}
      </p>
    </div>
    <router-view></router-view>
  </section>
</template>

<script>
export default {
  name: "MyPage",

  data() {
    return {
      myPageHeading: "마이페이지",
      myPageDescription: "해피하우스 프로필을 수정 하실 수 있습니다.",
    };
  },
};
</script>

<style></style>
