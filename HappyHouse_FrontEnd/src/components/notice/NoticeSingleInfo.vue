<template>
  <!-- Project information start -->
  <div class="block sm:flex gap-0 sm:gap-10 mt-14">
    <!-- Single project left section details start -->
    <div class="w-full sm:w-1/3 text-left">
      <!-- Single project client details start -->
      <!-- <div class="mb-7">
        <p
          class="text-2xl font-semibold text-secondary-dark dark:text-secondary-light mb-2"
        >
          {{ noticeInfo.clientHeading }}
        </p>
        <ul class="leading-loose">
          <li
            v-for="info in noticeInfo.companyInfos"
            :key="info"
            class="text-ternary-dark dark:text-ternary-light"
          >
            <span>{{ info.title }}: </span>
            <a
              href="#"
              :class="
                info.title == 'Website' || info.title == 'Phone'
                  ? 'hover:underline cursor-pointer'
                  : ''
              "
              aria-label="Project Webiste and Phone"
              >{{ info.details }}</a
            >
          </li>
        </ul>
      </div> -->
      <!-- Single project client details end -->

      <!-- Single project objectives start -->
      <!-- <div class="mb-7">
        <p
          class="text-2xl font-semibold text-ternary-dark dark:text-ternary-light mb-2"
        >
          {{ noticeInfo.objectivesHeading }}
        </p>
        <p class="text-primary-dark dark:text-ternary-light">
          {{ noticeInfo.objectivesDetails }}
        </p>
      </div> -->
      <!-- Single notice objectives end -->

      <!-- Single notice technologies start -->
      <!-- <div class="mb-7">
        <p
          class="text-2xl font-semibold text-ternary-dark dark:text-ternary-light mb-2"
        >
          {{ noticeInfo.technlogies[0].title }}
        </p>
        <p class="text-primary-dark dark:text-ternary-light">
          {{ noticeInfo.technlogies[0].techs.join(", ") }}
        </p>
      </div> -->
      <!-- Single notice technologies end -->

      <!-- Single notice social sharing start -->
      <div>
        <p
          class="text-2xl font-semibold text-ternary-dark dark:text-ternary-light mb-2"
        >
          {{ noticeInfo.socialSharingsHeading }}
        </p>
        <div class="flex items-center gap-3 mt-5">
          <a
            v-for="social in noticeInfo.socialSharings"
            :key="social.id"
            :href="social.url"
            target="__blank"
            aria-label="Share Notice"
            class="bg-ternary-light dark:bg-ternary-dark text-gray-400 hover:text-primary-dark dark:hover:text-primary-light p-2 rounded-lg shadow-sm"
            ><i :data-feather="social.icon" class="w-5 h-5"></i
          ></a>
        </div>
      </div>
      <!-- Single notice social sharing end -->
    </div>
    <!-- Single notice left section details end -->

    <!-- Single notice right section details start -->
    <div class="w-full sm:w-2/3 text-left mt-10 sm:mt-0">
      <p
        class="text-primary-dark dark:text-primary-light text-2xl font-bold mb-7"
      >
        {{ noticeInfo.noticeDetailsHeading }}
      </p>
      <!-- <p
        v-for="noticeDetail in noticeInfo.noticeDetails"
        :key="noticeDetail.id"
        class="mb-5 text-lg text-ternary-dark dark:text-ternary-light"
      >
        {{ noticeDetail.details }}
      </p> -->
      <p class="mb-5 text-lg text-ternary-dark dark:text-ternary-light">
        {{ noticeInfo.noticeDetails }}
      </p>
    </div>
    <!-- Single project right section details end -->
  </div>
  <!-- Project information end -->
</template>

<script>
import feather from "feather-icons";
// import { mapState } from "vuex";

// const noticeStore = "noticeStore";

export default {
  props: ["noticeInfo"],
  //   computed: {
  //     ...mapState(noticeStore, ["currentNotice"]),
  //   },

  //   created() {
  //     console.log("Notice Single Info");
  //   },

  mounted() {
    feather.replace();
  },
  updated() {
    feather.replace();
  },
};
</script>
