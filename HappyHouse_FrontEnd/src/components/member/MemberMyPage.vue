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
    <!-- <div class="mt-10 sm:mt-16">
      <div class="leading-loose pl-80">
        <div
          class="max-w-xl m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
        >
          <p
            class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
          >
            {{ memberInfo.iduser }} 님의 프로필
          </p>
          <div class="">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="name"
              >Full Name</label
            >
            <input
              class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
              id="name"
              name="name"
              type="text"
              required=""
              placeholder="Your Name"
              aria-label="Name"
            />
          </div>
          <div class="mt-6">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="email"
              >Email</label
            >
            <input
              class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
              id="email"
              name="email"
              type="text"
              required=""
              placeholder="Your Email"
              aria-label="Email"
            />
          </div>
          <div class="mt-6">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="subject"
              >Subject</label
            >
            <input
              class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
              id="subject"
              name="subject"
              type="text"
              required=""
              placeholder="Subject"
              aria-label="Subject"
            />
          </div>

          <div class="mt-6">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="message"
              >Message</label
            >
            <textarea
              class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
              id="message"
              name="message"
              cols="14"
              rows="6"
              aria-label="Message"
            ></textarea>
          </div>

          <div class="mt-6">
            <button
              class="px-4 py-2.5 text-white font-medium tracking-wider bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 rounded-lg"
              type="submit"
              aria-label="Send Message"
            >
              Send Message
            </button>
          </div>
        </div>
      </div>
    </div> -->
  </section>
</template>

<script>
import { mapState } from "vuex";
import MemberMyPageProfile from "@/components/member/child/MemberMyPageProfile.vue";
import MemberMyPageUpdate from "@/components/member/child/MemberMyPageUpdate.vue";

const memberStore = "memberStore";

export default {
  name: "MyPage",
  components: {
    MemberMyPageProfile,
    MemberMyPageUpdate,
  },
  data() {
    return {
      myPageHeading: "마이페이지",
      myPageDescription: "해피하우스 프로필을 수정 하실 수 있습니다.",
    };
  },
  computed: {
    ...mapState(memberStore, ["memberInfo"]),
  },
};
</script>

<style lang="scss" scoped></style>
