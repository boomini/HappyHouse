<template>
  <!-- <div class="container mx-auto sm:flex py-5 sm:py-10 mt-10 sm:mt-20">
    <qn-a-read-question></qn-a-read-question>
    <qn-a-read-answer></qn-a-read-answer>
  </div> -->
  <div>
    <section class="pt-20 sm:pt-28">
      <div class="text-center">
        <div class="w-full">
          <div class="leading-loose pl-80">
            <!-- 질문을 클릭하였을때 폼 시작 -->
            <div
              class="max-w-xl m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
              v-if="getTypeMode.type == 'Q'"
            >
              <p
                class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
              >
                Question
              </p>

              <div class="">
                <label
                  class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                  for="iduser"
                  >질문자 ID</label
                >
                <p
                  class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                  id="iduser"
                  name="iduser"
                  type="text"
                  required=""
                  aria-label="userid"
                >
                  {{ getterQ.iduser }}
                </p>
              </div>
              <div class="mt-6">
                <label
                  class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                  for="title"
                  >Title</label
                >
                <p
                  class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                  id="title"
                  name="title"
                  type="text"
                  required=""
                  aria-label="title"
                >
                  {{ getterQ.title }}
                </p>
              </div>
              <div class="mt-6">
                <label
                  class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                  for="title"
                  >질문 내용</label
                >
                <textarea
                  class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                  id="content"
                  name="content"
                  cols="14"
                  rows="6"
                  aria-label="Content"
                  v-model="getterQ.content"
                ></textarea>
              </div>
              <div class="mb-6">
                <button
                  class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right ml-1"
                  aria-label="Hire Me Button"
                  @click="mvDelete"
                >
                  삭제
                </button>
                <button
                  class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right ml-1"
                  aria-label="Hire Me Button"
                  @click="mvUpdate"
                >
                  수정
                </button>

                <button
                  class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right ml-1"
                  aria-label="Hire Me Button"
                  @click="mvList"
                >
                  목록
                </button>
                <button
                  class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right"
                  aria-label="Hire Me Button"
                  @click="mvAnswer"
                >
                  답글 작성
                </button>
              </div>
            </div>
            <!-- 질문을 클릭하였을때 폼 끝 -->

            <!-- 답변을 클릭하였을때 폼 시작 -->
            <div
              class="max-w-xl m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
              v-if="getTypeMode.type == 'A'"
            >
              <p
                class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
              >
                Answer
              </p>

              <div class="">
                <label
                  class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                  for="iduser"
                  >답변자 ID</label
                >
                <p
                  class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                  id="iduser"
                  name="iduser"
                  type="text"
                  required=""
                  placeholder="User Id"
                  aria-label="userid"
                >
                  {{ getterA.iduser }}
                </p>
              </div>

              <div class="mt-6">
                <label
                  class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                  for="title"
                  ><svg
                    class="h-6 w-6 text-white"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M8.228 9c.549-1.165 2.03-2 3.772-2 2.21 0 4 1.343 4 3 0 1.4-1.278 2.575-3.006 2.907-.542.104-.994.54-.994 1.093m0 3h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                    />
                  </svg>
                </label>
                <textarea
                  class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                  id="content"
                  name="content"
                  cols="14"
                  rows="6"
                  aria-label="Content"
                  v-model="getterQFromA.content"
                ></textarea>
              </div>
              <div class="mt-6">
                <label
                  class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                  for="title"
                  ><svg
                    class="h-6 w-6 text-white"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M12 8v4m0 4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                    />
                  </svg>
                </label>
                <textarea
                  class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                  id="content"
                  name="content"
                  cols="14"
                  rows="6"
                  aria-label="Content"
                  v-model="getterA.content"
                ></textarea>
              </div>
              <div class="mb-6">
                <button
                  class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right ml-1"
                  aria-label="Hire Me Button"
                  @click="mvDelete"
                >
                  삭제
                </button>
                <button
                  class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right ml-1"
                  aria-label="Hire Me Button"
                  @click="mvUpdate"
                >
                  수정
                </button>

                <button
                  class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right"
                  aria-label="Hire Me Button"
                  @click="mvList"
                >
                  목록
                </button>
              </div>
            </div>
            <!-- 답변을 클릭하였을때 폼 끝 -->
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
// import QnAReadQuestion from "@/components/qna/child/QnAReadQuestion.vue";
// import QnAReadAnswer from "@/components/qna/child/QnAReadAnswer.vue";
import { mapGetters, mapMutations } from "vuex";
export default {
  data() {
    return {
      idx: "",
      gidx: "",
    };
  },
  created() {
    this.idx = this.$route.params.idx;
    if (this.$route.params.gidx) this.gidx = this.$route.params.gidx;
    // alert(this.$store.state.qna.type);
  },
  computed: {
    ...mapGetters({
      getTypeMode: "getTypeMode",
      getQuestion: "getQuestion",
      getAnswer: "getAnswer",
    }),
    // ...mapGetters(["getQuestion, getTypeMode"]),
    getterQ() {
      console.log(this.idx);
      console.log(this.getQuestion(this.idx));
      return this.getQuestion(this.idx);
    },
    getterA() {
      return this.getAnswer(this.idx, this.gidx);
    },
    getterQFromA() {
      return this.getQuestion(this.gidx);
    },
  },
  methods: {
    ...mapMutations(["SET_TYPE_MODE", "SET_INDEX"]),
    mvAnswer() {
      this.SET_TYPE_MODE({ type: "A", mode: "C" });
      this.SET_INDEX({ index: this.idx });
      this.$router.push({ name: "QnACreate" });
    },
    mvUpdate() {
      // if (this.getTypeMode.type == "Q") {
      this.SET_TYPE_MODE({ type: this.getTypeMode.type, mode: "U" });
      this.SET_INDEX({ index: this.idx });
      if (this.getTypeMode.type == "Q") {
        this.$router.push({ name: "QnAUpdate" });
      } else if (this.getTypeMode.type == "A") {
        this.$router.push({ name: "QnAUpdate", params: { qidx: this.gidx } });
      }
      // } else if (this.getTypeMode.type == "A") {
      //   this.SET_TYPE_MODE({type: 'A', mode: 'U'});
      //   this.SET_INDEX({index: this.idx});
      //   this.$router.push({name: 'QnAUpdate'});
      // }
    },
    mvDelete() {
      this.SET_TYPE_MODE({ type: this.getTypeMode.type, mode: "D" });
      this.SET_INDEX({ index: this.idx });
      // this.$router.push({ name: "QnADelete" });
      if (this.getTypeMode.type == "Q") {
        this.$router.push({ name: "QnADelete", params: { qidx: this.idx } });
      } else if (this.getTypeMode.type == "A") {
        this.$router.push({ name: "QnADelete", params: { qidx: this.gidx } });
      }
    },
    mvList() {
      this.$router.push({ name: "QnAList" });
    },
  },
};
// export default {
//   name: "QnARead",
//   created() {
//     console.log("HELLO");
//   },
//   components: {
//     QnAReadQuestion,
//     QnAReadAnswer,
//   },
// };
</script>

<style></style>
