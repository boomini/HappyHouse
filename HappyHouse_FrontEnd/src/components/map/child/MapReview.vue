<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div class="bg-gray-100 pt-8 pb-12 overflow-auto h-30">
    <div><strong>유저들의 평균 점수</strong></div>
    <div>
      <strong class="text-lg">{{ avgrat }}</strong>
    </div>
    <div v-if="reviews.length == 0">
      <div><strong>등록된 리뷰가 없습니다.</strong></div>
      <div><strong>첫등록을 해주세요</strong></div>
    </div>
    <div class="px-4 sm:px-6 lg:px-6">
      <div
        v-for="review in reviews"
        :key="review.id"
        class="max-w-lg px-8 py-8 mt-2 mb-2 rounded-md shadow-lg bg-white"
      >
        <div class="flex space-x-0.5">
          <svg
            v-for="i in 5"
            v-bind:key="i"
            :class="i <= review.rating ? 'text-yellow-300' : 'text-gray-300'"
            class="w-5 h-5"
            :fill="i <= review.rating ? 'currentColor' : 'none'"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="1"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              d="M11.049 2.927c.3-.921 1.603-.921 1.902 0l1.519 4.674a1 1 0 00.95.69h4.915c.969 0 1.371 1.24.588 1.81l-3.976 2.888a1 1 0 00-.363 1.118l1.518 4.674c.3.922-.755 1.688-1.538 1.118l-3.976-2.888a1 1 0 00-1.176 0l-3.976 2.888c-.783.57-1.838-.197-1.538-1.118l1.518-4.674a1 1 0 00-.363-1.118l-3.976-2.888c-.784-.57-.38-1.81.588-1.81h4.914a1 1 0 00.951-.69l1.519-4.674z"
            ></path>
          </svg>
        </div>
        <p class="mt-2 text-sm font-medium leading-5 text-gray-500">
          {{ review.date }}
        </p>
        <div class="space-y-1 mt-2">
          <p class="text-sm font-medium leading-5 text-gray-600">
            {{ review.body }}
          </p>
        </div>
        <div class="mt-6 flex items-center space-x-2">
          <span class="text-sm font-semibold leading-5 text-gray-900">{{
            review.iduser
          }}</span>
          <div class="flex-shrink-0">
            <svg
              class="w-5 h-5 text-gray-600"
              fill="currentColor"
              viewBox="0 0 20 20"
            >
              <path
                fill-rule="evenodd"
                d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z"
                clip-rule="evenodd"
              ></path>
            </svg>
          </div>
        </div>
      </div>
      <div v-if="memberInfo" class="mt-6">
        <textarea
          class="w-full px-5 py-2 border-0 text-primary-dark dark:text-secondary-light bg-ternary-light dark:bg-ternary-dark rounded-md shadow-sm text-md dark:font-medium"
          id="message"
          name="content"
          cols="14"
          rows="6"
          placeholder="리뷰를 적어주세요"
          aria-label="content"
          v-model="review"
        ></textarea>
      </div>

      <div v-if="memberInfo" class="mb-6">
        <button
          @click="registerreview"
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 ml-3 mt-1 rounded float-right"
        >
          리뷰등록
        </button>
        <ranking-filter class="float-right"> </ranking-filter>
      </div>
    </div>
    <div></div>
    <!-- Hire me modal end -->
  </div>
</template>

<script>
import RankingFilter from "@/components/map/child/RankingFilter.vue";
import { mapActions, mapGetters, mapState } from "vuex";
import http from "@/util/http-common";
const memberStore = "memberStore";
export default {
  data() {
    return {
      modal: false,
      reviews: [],
      review: "",
      avgrat: Number,
    };
  },
  watch: {
    "$store.state.review.reviewList": function() {
      this.reviews = this.getReviewList;
    },
    "$store.state.review.homecode": function() {
      this.setReviewList(this.$store.state.review.homecode);
      this.reviews = this.getReviewList;
      console.log(this.reviews);
    },
    "$store.state.review.avgrank": function() {
      this.avgrat = this.$store.state.review.avgrank;
    },
  },
  computed: {
    ...mapGetters(["getReviewList"]),
    ...mapState(memberStore, ["isLogin", "memberInfo"]),
  },
  components: {
    RankingFilter,
  },
  mounted() {
    this.setReviewList(this.$store.state.review.homecode);
    this.reviews = this.getReviewList;
    console.log(this.reviews);
  },
  methods: {
    ...mapActions(["setReviewList"]),

    registerreview() {
      console.log(this.memberInfo.iduser);
      console.log(this.$store.state.review.homecode);
      console.log(this.review);
      console.log(this.$store.state.review.ranking);
      http
        .post(`/review`, {
          iduser: this.memberInfo.iduser,
          home_code: this.$store.state.review.homecode,
          body: this.review,
          rating: this.$store.state.review.ranking,
        })
        .then(({ data }) => {
          let msg = "질문 등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "질문 등록이 완료되었습니다.";
            this.setReviewList(this.$store.state.review.homecode);
            this.review = "리뷰를 적어주세요";
          }
          alert(msg);
        });
    },
  },
};
</script>

<style>
html {
  font-family: "Inter", sans-serif;
}
</style>
