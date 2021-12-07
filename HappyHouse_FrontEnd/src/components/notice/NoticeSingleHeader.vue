<template>
  <div>
    <!-- Project heading and meta info start -->
    <p
      class="text-left text-3xl sm:text-4xl font-bold text-primary-dark dark:text-primary-light mt-7 sm:mt-20 mb-7"
    >
      {{ singleNoticeHeader.singleNoticeTitle }}
      <!-- {{ currentNotice.title }} -->
    </p>
    <div class="flex">
      <div class="flex items-center mr-10">
        <i
          data-feather="clock"
          class="w-4 h-4 text-ternary-dark dark:text-ternary-light"
        ></i>
        <span
          class="ml-2 leading-none text-primary-dark dark:text-primary-light"
          >{{ singleNoticeHeader.singleNoticeDate }}</span
        >
      </div>
      <div class="flex items-center">
        <i
          data-feather="tag"
          class="w-4 h-4 text-ternary-dark dark:text-ternary-light"
        ></i>
        <span
          class="ml-2 leading-none text-primary-dark dark:text-primary-light"
          >{{ singleNoticeHeader.singleNoticeCategory }}</span
        >
      </div>
    </div>
    <!-- Project heading and meta info end -->
  </div>
</template>

<script>
// import { mapState } from "vuex";

// const noticeStore = "noticeStore";

// export default {
//   computed: {
//     ...mapState(noticeStore, ["currentNotice"]),
//   },
// };
export default {
  props: ["singleNoticeHeader"],
};
</script>
