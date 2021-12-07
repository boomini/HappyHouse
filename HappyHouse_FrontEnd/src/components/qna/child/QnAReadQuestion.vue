<template>
  <div>
    <section class="pt-20 sm:pt-28">
      <div class="text-center">
        <div class="w-full">
          <div class="leading-loose">
            <form
              class="max-w-xl m-4 p-6 sm:p-10 bg-secondary-light dark:bg-secondary-dark rounded-xl shadow-xl text-left"
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
                  >UserID</label
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
                  {{ getter.iduser }}
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
                  placeholder="title"
                  aria-label="title"
                >
                  {{ getter.title }}
                </p>
              </div>
              <button
                class="
                    text-purple-500
                    bg-transparent
                    border border-solid border-purple-500
                    hover:bg-purple-500 hover:text-white
                    active:bg-purple-600
                    font-bold
                    uppercase
                    text-xs
                    px-4
                    py-2
                    rounded
                    outline-none
                    focus:outline-none
                    mr-1
                    mb-1
                    ease-linear
                    transition-all
                    duration-150
                    items-center
                "
                @click="mvUpdate"
                type="button"
              >
                수정
              </button>
              <button
                class="
                text-purple-500
                bg-transparent
                border border-solid border-purple-500
                hover:bg-purple-500 hover:text-white
                active:bg-purple-600
                font-bold
                uppercase
                text-xs
                px-4
                py-2
                rounded
                outline-none
                focus:outline-none
                mr-1
                mb-1
                ease-linear
                transition-all
                duration-150
                items-center
            "
                type="button"
                @click="mvDelete"
              >
                삭제
              </button>
              <button
                class="
                    text-purple-500
                    bg-transparent
                    border border-solid border-purple-500
                    hover:bg-purple-500 hover:text-white
                    active:bg-purple-600
                    font-bold
                    uppercase
                    text-xs
                    px-4
                    py-2
                    rounded
                    outline-none
                    focus:outline-none
                    mr-1
                    mb-1
                    ease-linear
                    transition-all
                    duration-150
                    items-center
                "
                @click="mvAnswer"
                type="button"
              >
                답글작성
              </button>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { mapGetters, mapMutations } from "vuex";
export default {
  data() {
    return {
      idx: "",
    };
  },
  created() {
    // this.idx = this.$route.params.idx;
    this.idx = this.getIndex();
  },
  computed: {
    // ...mapGetters({
    //   getQuestion: "getQuestion",
    //   getIndex,
    // }),
    ...mapGetters(["getQuestion", "getIndex"]),
    getter() {
      alert(this.idx + "뇨오옹~");
      console.log(this.getQuestion(this.idx));
      return this.getQuestion(this.idx);
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
      this.SET_TYPE_MODE({ type: "Q", mode: "U" });
      this.SET_INDEX({ index: this.idx });
      this.$router.push({ name: "QnAUpdate" });
    },
    mvDelete() {
      this.SET_INDEX({ index: this.idx });
      this.$router.push({ name: "QnADelete" });
    },
  },
};
</script>

<style></style>
