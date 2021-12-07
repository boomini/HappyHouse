<template>
  <div class="mt-10 sm:mt-16">
    <div class="leading-loose inline-flex">
      <div
        class="content-center max-w-xl m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
      >
        <p
          class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
        >
          {{ memberInfo.iduser }} 님의
          프로필&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        </p>
        <div>
          <ul class="">
            <li class="flex">
              <i
                data-feather="user"
                class="w-5 text-gray-500 dark:text-gray-400 mr-4"
              ></i>
              <a
                href="#"
                class="text-lg mb-4 text-ternary-dark dark:text-ternary-light"
                aria-label="Website and Phone"
              >
                {{ memberInfo.name }}
              </a>
            </li>
            <li class="flex">
              <i
                data-feather="key"
                class="w-5 text-gray-500 dark:text-gray-400 mr-4"
              ></i>
              <a
                href="#"
                class="text-lg mb-4 text-ternary-dark dark:text-ternary-light"
                aria-label="Website and Phone"
              >
                ********
              </a>
            </li>

            <li class="flex">
              <i
                data-feather="map-pin"
                class="w-5 text-gray-500 dark:text-gray-400 mr-4"
              ></i>
              <a
                href="#"
                class="text-lg mb-4 text-ternary-dark dark:text-ternary-light"
                aria-label="Website and Phone"
              >
                {{ memberInfo.addr }}
              </a>
            </li>
          </ul>
        </div>
        <!-- <div class="">
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
        </div> -->

        <div class="mt-6 text-center">
          <!-- <router-link :to="{ name: 'MyPageUpdate' }" tag="button"> -->
          <button
            class="px-4 py-2.5 text-white font-medium tracking-wider bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 rounded-lg"
            aria-label="Send Message"
            @click="mvMemberModify"
          >
            정보 수정
          </button>
          <!-- </router-link> -->
          <button
            class="ml-2 px-4 py-2.5 text-white font-medium tracking-wider bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 rounded-lg"
            aria-label="Send Message"
            @click="unregister"
          >
            회원 탈퇴
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import feather from "feather-icons";

const memberStore = "memberStore";

export default {
  name: "MyPageProfile",
  computed: {
    ...mapState(memberStore, ["memberInfo"]),
  },
  mounted() {
    feather.replace();
  },
  updated() {
    feather.replace();
  },
  methods: {
    ...mapActions(memberStore, ["deleteMember"]),

    mvMemberModify() {
      this.$router.push({ name: "MyPageUpdate" });
    },
    unregister() {
      if (confirm("정말로 탈퇴하시겠습니까?")) {
        this.deleteMember(this.memberInfo.iduser);
        this.$router.push({ name: "Home" });
      }
    },
  },
};
</script>

<style></style>
