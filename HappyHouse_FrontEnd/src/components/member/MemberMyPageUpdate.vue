<template>
  <div class="mt-10 sm:mt-16">
    <div class="leading-loose inline-flex">
      <div
        class="content-center max-w-xl m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
      >
        <p
          class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
        >
          {{ memberInfo.iduser }} 님의 프로필
          수정&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        </p>
        <div class="">
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="name"
            >이름</label
          >
          <input
            class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
            id="name"
            name="name"
            type="text"
            required=""
            v-model="member.name"
            aria-label="Name"
          />
        </div>
        <div class="mt-6">
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="password"
            >비밀번호</label
          >
          <input
            class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
            id="password"
            name="password"
            type="password"
            required=""
            v-model="member.password"
            aria-label="Password"
          />
        </div>
        <div class="mt-6">
          <label
            class="block text-lg text-primary-dark dark:text-primary-light mb-2"
            for="address"
            >주소</label
          >
          <input
            class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
            id="address"
            name="address"
            type="text"
            required=""
            v-model="member.addr"
            aria-label="Address"
          />
        </div>

        <div class="mt-6 text-center">
          <button
            class="px-4 py-2.5 text-white font-medium tracking-wider bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 rounded-lg"
            aria-label="Send Message"
            @click="updateMember"
          >
            수정 완료하기
          </button>
          <button
            class="ml-2 px-4 py-2.5 text-white font-medium tracking-wider bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 rounded-lg"
            aria-label="Send Message"
            @click="mvMyPage"
          >
            마이 페이지로
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MyPageUpdate",
  data() {
    return {
      member: {},
    };
  },
  created() {
    this.member = this.memberInfo;
  },
  computed: {
    ...mapState(memberStore, ["memberInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["modifyMember"]),

    updateMember() {
      this.modifyMember(this.member);
      this.mvMyPage();
    },

    mvMyPage() {
      this.$router.push({ name: "MyPageProfile" });
    },
  },
};
</script>

<style></style>
