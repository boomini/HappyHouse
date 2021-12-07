<template>
  <div class="container mx-auto">
    <!-- Banner start -->
    <AppBanner />
    <!-- Banner snd -->

    <!-- Projects start -->
    <NoticesGrid />
    <!-- Projects end -->

    <!-- Load more projects button start -->
    <div class="mt-10 sm:mt-20 flex justify-center">
      <router-link
        v-if="memberInfo != null && memberInfo.iduser === 'admin'"
        to="/notice-post"
        class="mr-2 flex items-center px-6 py-3 rounded-xl shadow-lg hover:shadow-xl bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 text-white text-lg sm:text-xl font-medium"
        aria-label="More Notices"
        >공지 올리기</router-link
      >
      <router-link
        to="/notices"
        class="flex items-center px-6 py-3 rounded-xl shadow-lg hover:shadow-xl bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 text-white text-lg sm:text-xl font-medium"
        aria-label="More Notices"
        >공지 더보기</router-link
      >
    </div>
    <!-- Load more projects button end -->
  </div>
</template>

<script>
import AppBanner from "@/components/AppBanner";
import NoticesGrid from "@/components/notice/NoticesGrid.vue";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "Home",
  components: {
    AppBanner,
    NoticesGrid,
  },

  computed: {
    ...mapState(memberStore, ["memberInfo"]),
  },
};
</script>

<style scoped></style>
