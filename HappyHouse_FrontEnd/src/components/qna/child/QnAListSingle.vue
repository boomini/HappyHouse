<template>
  <tr
    class="cursor-pointer bg-secondary-light dark:bg-gray-700 text-ternary-dark dark:text-ternary-light"
    @click="mvQnaRead"
  >
    <td class="p-6">
      <div class="">{{ idx }}</div>
    </td>
    <td class="font-bold">
      {{ title }}
    </td>
    <td>
      {{ iduser }}
    </td>
    <td>
      {{ regtime }}
    </td>
    <!-- <td class="p-3">
      <a href="#" class="text-gray-400 hover:text-gray-100  mr-2">
        <i class="material-icons-outlined text-base">visibility</i>
      </a>
      <a href="#" class="text-gray-400 hover:text-gray-100 mx-2">
        <i class="material-icons-outlined text-base">edit</i>
      </a>
      <a href="#" class="text-gray-400 hover:text-gray-100 ml-2">
        <i class="material-icons-round text-base">delete_outline</i>
      </a>

    </td> -->
  </tr>
  <qn-a-list-answer
    v-for="(answer, index) in qnaanswer"
    :key="index"
    v-bind="answer"
    class="cursor-pointer bg-secondary-light dark:bg-secondary-dark text-ternary-dark dark:text-ternary-light"
  ></qn-a-list-answer>
</template>

<script>
import QnAListAnswer from "@/components/qna/child/QnAListAnswer.vue";
import { mapMutations } from "vuex";

export default {
  name: "QnAListSingle",
  props: {
    idx: String,
    iduser: String,
    title: String,
    content: String,
    regtime: String,
    qnaanswer: Object,
  },
  components: {
    QnAListAnswer,
  },
  created() {
    console.log(this.idx + " " + this.title);
  },
  methods: {
    ...mapMutations(["SET_TYPE_MODE"]),

    mvQnaRead() {
      console.log(this.idx);

      this.SET_TYPE_MODE({ type: "Q", mode: "R" });
      this.$router.push({ name: "QnARead", params: { idx: this.idx } });
      // this.SET_INDEX({ index: this.idx });
      // this.$router.push({ name: "QnARead" });
    },
  },
};
</script>

<style></style>
