<template>
  <section class="pt-20 sm:pt-28">
    <div class="text-center">
      <div class="w-full">
        <div class="leading-loose pl-80">
          <div
            class="max-w-xl m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
          >
            <p
              class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
              v-if="this.type === 'Q' && this.mode === 'C'"
            >
              질문 작성하기
            </p>
            <p
              class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
              v-if="this.type === 'Q' && this.mode === 'U'"
            >
              질문 수정하기
            </p>
            <p
              class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
              v-if="this.type === 'A' && this.mode === 'C'"
            >
              답변 작성하기
            </p>
            <p
              class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
              v-if="this.type === 'A' && this.mode === 'U'"
            >
              답변 수정하기
            </p>
            <div class="">
              <label
                class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                for="iduser"
                >UserID</label
              >
              <input
                class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                id="iduser"
                v-model="board.iduser"
                name="iduser"
                type="text"
                required=""
                placeholder="User Id"
                aria-label="userid"
              />
            </div>
            <div class="mt-6">
              <label
                class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                for="title"
                >제목</label
              >
              <input
                class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                id="title"
                name="title"
                v-model="board.title"
                type="text"
                required=""
                placeholder="title"
                aria-label="title"
              />
            </div>
            <div class="mt-6">
              <label
                class="block text-lg text-primary-dark dark:text-primary-light mb-2"
                for="content"
                >내용</label
              >
              <textarea
                class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
                id="message"
                v-model="board.content"
                name="content"
                cols="14"
                rows="6"
                placeholder="content"
                aria-label="content"
              ></textarea>
            </div>

            <div class="mb-6">
              <button
                class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right"
                type="button"
                aria-label="write"
                v-if="this.type === 'Q' && this.mode === 'C'"
                @click="check"
              >
                질문 등록
              </button>
              <button
                class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right"
                type="button"
                aria-label="write"
                v-if="this.type === 'Q' && this.mode === 'U'"
                @click="check"
              >
                질문 수정
              </button>
              <button
                class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right"
                type="button"
                aria-label="write"
                v-if="this.type === 'A' && this.mode === 'C'"
                @click="check"
              >
                답변 등록
              </button>
              <button
                class="text-md font-medium bg-indigo-500 hover:bg-indigo-600 text-white shadow-sm rounded-lg px-5 py-1 float-right"
                type="button"
                aria-label="write"
                v-if="this.type === 'A' && this.mode === 'U'"
                @click="check"
              >
                답변 수정
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import http from "@/util/http-common";
import { mapGetters } from "vuex";
export default {
  name: "QnACreateForm",
  data() {
    return {
      type: "",
      mode: "",
      gidx: 0,
      qna: {
        idx: 0, // 부모 키(질문의 idx)
      },
      board: {
        iduser: "",
        title: "",
        content: "",
      },
    };
  },
  created() {
    this.type = this.getTypeMode.type;
    this.mode = this.getTypeMode.mode;
    this.gidx = this.getIndex;
    console.log(this.type, this.mode, this.gidx);

    if (this.mode == "U") {
      if (this.type == "Q") {
        let question = this.getQuestion(this.gidx);
        this.board.iduser = question.iduser;
        this.board.title = question.title;
        this.board.content = question.content;
      } else if (this.type == "A") {
        this.qna.idx = this.$route.params.qidx;

        let answer = this.getAnswer(this.gidx, this.qna.idx);
        this.board.iduser = answer.iduser;
        this.board.title = answer.title;
        this.board.content = answer.content;
      }
    }
  },
  computed: {
    ...mapGetters(["getTypeMode", "getIndex", "getQuestion", "getAnswer"]),
  },
  methods: {
    check() {
      let err = true;
      let msg = "";
      !this.board.iduser &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.iduser.focus());
      err &&
        !this.board.title &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err &&
        !this.board.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else if (this.type === "Q") {
        this.mode === "C" ? this.registQuestion() : this.modifyQuestion();
      } else {
        this.mode === "C" ? this.registAnswer() : this.modifyAnswer();
      }
    },
    registQuestion() {
      console.log(this.board.iduser);
      console.log(this.board.title);
      console.log(this.board.content);
      http
        .post(`/qna`, {
          iduser: this.board.iduser,
          title: this.board.title,
          content: this.board.content,
        })
        .then(({ data }) => {
          let msg = "질문 등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "질문 등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    modifyQuestion() {
      console.log(this.board.iduser);
      console.log(this.board.title);
      console.log(this.board.content);
      http
        .put(`/qna`, {
          iduser: this.board.iduser,
          title: this.board.title,
          content: this.board.content,
          idx: this.gidx,
        })
        .then(({ data }) => {
          let msg = "질문 수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "질문 수정이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    registAnswer() {
      http
        .post(`/qna/answer`, {
          iduser: this.board.iduser,
          title: this.board.title,
          content: this.board.content,
          gidx: this.gidx,
        })
        .then(({ data }) => {
          let msg = "답변 등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "답변 등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    modifyAnswer() {
      http
        .put(`/qna/answer`, {
          iduser: this.board.iduser,
          title: this.board.title,
          content: this.board.content,
          idx: this.gidx,
        })
        .then(({ data }) => {
          let msg = "답변 수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "답변 수정이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    moveList() {
      this.$router.push({ name: "QnAList" });
    },
  },
};
</script>

<style></style>
