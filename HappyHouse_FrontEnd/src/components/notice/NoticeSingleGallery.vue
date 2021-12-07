<template>
  <!-- Project gallery start -->
  <div class="grid grid-cols-1 sm:grid-cols-3 sm:gap-10 mt-12">
    <div
      class="mb-10 sm:mb-0"
      v-for="noticeImage in noticeImages"
      :key="noticeImage.id"
    >
      <img
        :src="noticeImage.img"
        class="rounded-2xl cursor-pointer shadow-lg sm:shadow-none"
        alt="{{ noticeImage.title }}"
      />
    </div>
  </div>
  <!-- Project gallery end -->
</template>

<script>
export default {
  props: ["noticeImages"],
};
</script>
