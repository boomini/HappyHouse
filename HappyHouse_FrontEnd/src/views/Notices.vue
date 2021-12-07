<template>
  <div class="container mx-auto">
    <!-- NoticesGrid start -->
    <notices-grid />
    <!-- NoticesGrid end -->
  </div>
</template>

<script>
import NoticesGrid from "@/components/notice/NoticesGrid.vue";

export default {
  name: "Notices",
  components: {
    NoticesGrid,
  },
};
</script>

<style scoped></style>
