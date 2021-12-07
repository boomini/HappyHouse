<template>
  <section class="pt-20 sm:pt-28">
    <div class="text-center">
      <p
        class="text-2xl sm:text-5xl font-semibold mb-3 text-ternary-dark dark:text-ternary-light"
      >
        {{ qnasHeading }}
      </p>
      <p class="text-md sm:text-xl text-gray-500 dark:text-ternary-light">
        {{ qnasDescription }}
      </p>
    </div>

    <div class="mt-10 sm:mt-16">
      <div class="overflow-auto lg:overflow-visible flex flex-col">
        <div>
          <button
            class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right"
            @click="moveCreate()"
            aria-label="Hire Me Button"
          >
            질문하기
          </button>
        </div>
        <table class="table text-gray-400 border-separate space-y-6 text-sm">
          <thead
            class="bg-secondary-light dark:bg-secondary-dark text-ternary-dark dark:text-ternary-light"
          >
            <tr>
              <th class="p-3 w-1/12">No.</th>
              <th class="p-3 w-7/12">제목</th>
              <th class="p-3 w-2/12">작성자</th>
              <th class="p-3 w-2/12">작성일</th>
              <!-- <th class="p-3 w-2/12">Action</th> -->
            </tr>
          </thead>
          <tbody>
            <qn-a-list-single
              v-for="(qna, index) in getQnAList"
              :key="index"
              v-bind="qna"
            ></qn-a-list-single>
          </tbody>
        </table>
      </div>
    </div>
  </section>
</template>

<script>
import { mapActions, mapGetters, mapMutations } from "vuex";
// import http from "@/util/http-common.js";
import QnAListSingle from "@/components/qna/child/QnAListSingle.vue";

export default {
  name: "QnAList",
  components: {
    QnAListSingle,
  },
  data: () => {
    return {
      qnasHeading: "QnA 게시판",
      qnasDescription: "실시간 QnA를 확인해보세요!",
      //   qnas: [],
    };
  },
  created() {
    // http.get(`/qna`).then(({ data }) => {
    //   this.qnas = data;
    // });
    this.setQnAList();
  },
  methods: {
    ...mapActions(["setQnAList"]),
    ...mapMutations(["SET_TYPE_MODE", "SET_QNA_LIST"]),
    moveCreate() {
      //   commit("SET_TYPE_MODE", { type: "Q", mode: "C" });
      this.SET_TYPE_MODE({ type: "Q", mode: "C" });
      this.$router.push({ name: "QnACreate" });
    },
  },
  computed: {
    ...mapGetters(["getQnAList"]),
  },
};
</script>

<style>
.table {
  border-spacing: 0 15px;
}

i {
  font-size: 1rem !important;
}

.table tr {
  border-radius: 20px;
}

tr td:nth-child(n + 4),
tr th:nth-child(n + 4) {
  border-radius: 0 0.625rem 0.625rem 0;
}

tr td:nth-child(1),
tr th:nth-child(1) {
  border-radius: 0.625rem 0 0 0.625rem;
}
</style>
