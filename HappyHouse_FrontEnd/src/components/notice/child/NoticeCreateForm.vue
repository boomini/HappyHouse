<template>
  <section class="pt-20 sm:pt-28">
    <!-- Projects grid title start -->
    <div class="text-center">
      <p
        class="text-2xl sm:text-5xl font-semibold mb-3 text-ternary-dark dark:text-ternary-light"
      >
        {{ noticesHeading }}
      </p>
      <p class="text-md sm:text-xl text-gray-500 dark:text-ternary-light">
        {{ noticesDescription }}
      </p>
    </div>

    <div class="w-full mt-12">
      <div class="leading-loose content-center">
        <div
          class="max-w-full m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
        >
          <p
            class="text-primary-dark dark:text-primary-light text-2xl font-semibold mb-8"
          >
            공지사항
          </p>

          <div class="w-4/6 inline-block">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="title"
              >제목</label
            >
            <input
              class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
              id="title"
              name="title"
              type="text"
              required=""
              placeholder="공지 제목을 입력해 주세요."
              v-model="notice.title"
              aria-label="Title"
            />
          </div>

          <div class="mt-6 ml-12 w-1/6 inline-block">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="content"
              >분류</label
            >
            <select v-model="notice.category" class="text-sm sm:text-md">
              <option disabled value="">카테고리를 선택하세요.</option>
              <option
                v-for="option in categories"
                :key="option"
                :value="option"
                class="text-normal sm:text-md"
                >{{ option }}
              </option>
            </select>
          </div>

          <div class="mt-6">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="content"
              >내용</label
            >
            <textarea
              class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
              id="content"
              name="content"
              rows="12"
              placeholder="공지 내용을 입력해 주세요."
              v-model="notice.content"
              aria-label="Content"
            ></textarea>
          </div>
          <!-- 
          <div class="mt-6">
            <label
              class="block text-lg text-primary-dark dark:text-primary-light mb-2"
              for="uploadFile"
              >썸네일</label
            >
            <input
              class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
              id="fileInfos"
              name="fileInfos"
              type="file"
              ref="fileInfos"
              required=""
              placeholder="사진을 업로드해 주세요."
              @change="fileChangeHandler"
              aria-label="Title"
            />
          </div> -->

          <div class="mt-6">
            <button
              class="px-4 py-2.5 text-white font-medium tracking-wider bg-indigo-500 hover:bg-indigo-600 focus:ring-1 focus:ring-indigo-900 rounded-lg"
              type="submit"
              aria-label="Send Message"
              @click="check"
            >
              공지하기
            </button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  data: () => {
    return {
      noticesHeading: "공지사항 게시하기",
      noticesDescription: "해피하우스가 알려주는 부동산 가이드",
      notice: {
        iduser: "",
        title: "",
        category: "",
        content: "",
        // fileInfos: null,
      },
      categories: ["해피 이야기", "부동산 상식", "생활 꿀팁"],
    };
  },
  computed: {
    ...mapState(memberStore, ["memberInfo"]),
  },
  created() {
    this.notice.iduser = this.memberInfo.iduser;
  },
  methods: {
    fileChangeHandler(e) {
      this.notice.fileInfos = e.target.files[0];
      console.log(e.target.files);
    },
    check() {
      if (!this.notice.title) {
        alert("제목을 입력하세요.");
      } else if (!this.notice.content) {
        alert("내용을 입력하세요.");
      } else this.postNotice();
    },
    postNotice() {
      //   //   this.notice.uploadFile = this.$refs.fileInfos.file;

      //   var formData = new FormData();
      //   formData.append("iduser", this.notice.iduser);
      //   formData.append("title", this.notice.title);
      //   formData.append("category", this.notice.category);
      //   formData.append("content", this.notice.content);
      //   formData.append("fileInfos", this.notice.fileInfos);

      //   http.post(`/notice`, JSON.stringify(formData)).then(({ data }) => {
      //     let msg = "공지 등록 처리시 문제가 발생했습니다.";
      //     if (data === "success") {
      //       msg = "공지 등록이 완료되었습니다.";
      //     }
      //     alert(msg);
      //     this.moveList();
      //   });
      http
        .post(`/notice`, {
          iduser: this.notice.iduser,
          title: this.notice.title,
          category: this.notice.category,
          content: this.notice.content,
        })
        .then(({ data }) => {
          let msg = "공지 등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "공지 등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    moveList() {
      this.$router.push({
        name: "Home",
      });
    },
  },
};
</script>

<style></style>
