<template>
  <section class="pt-20 sm:pt-28">
    <div class="text-center">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        class="h-6 w-6"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16"
        />
      </svg>
      삭제 처리 중...
    </div>
  </section>
</template>

<script>
import { mapActions, mapMutations, mapGetters } from "vuex";

export default {
  created() {
    // this.deleteQ(this.$store.state.qna.index);
    // this.$router.push({ name: "QnAList" });
    if (this.getTypeMode.type === "Q") {
      // alert("질문을 삭제합시다!!");
      this.deleteQ(this.getIndex);
    } else if (this.getTypeMode.type === "A") {
      // alert("답변을 삭제합시다!!");
      let indexes = { qidx: this.$route.params.qidx, aidx: this.getIndex };
      this.deleteA(indexes);
    }

    this.moveList();
  },
  computed: {
    ...mapGetters(["getTypeMode", "getIndex"]),
  },
  methods: {
    ...mapActions(["deleteQ", "deleteA"]),
    ...mapMutations(["DELETE_Q", "DELETE_A"]),

    moveList() {
      this.$router.push({ name: "QnAList" });
    },
  },
};
</script>

<style></style>
