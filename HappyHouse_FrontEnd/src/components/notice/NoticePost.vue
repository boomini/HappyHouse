<template>
  <div class="container mx-auto">
    <!-- NoticesGrid start -->
    <notice-create-form></notice-create-form>
    <!-- NoticesGrid end -->
  </div>
</template>

<script>
import NoticeCreateForm from "@/components/notice/child/NoticeCreateForm.vue";

export default {
  name: "NoticePost",
  components: {
    NoticeCreateForm,
  },
};
</script>

<style scoped></style>
