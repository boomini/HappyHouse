<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div>
    <div class="pt-1 pb-1 overflow-auto h-15">
      <div class="w-full">
        <!-- <div class="float-left pl-4 w-full">
          <strong>가격 : </strong>
          <input
            type="range"
            max="10"
            v-model="priceval"
            class="range ml-6 pl-4"
          />
          <strong> {{ priceval }}</strong>
        </div> -->
        <div class="float-left pl-4 pr-10 w-full">
          <strong>편의시설 : </strong>
          <input
            type="range"
            max="10"
            v-model="convenienteval"
            class="range pl-4"
          />
          <strong> {{ convenienteval }}</strong>
        </div>
        <div class="mx-auto p-3 float-left ml-3 w-full">
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4 mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              value="cafe"
              v-model="convenientarr"
            />
            카페
          </label>
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4  mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              value="hospital"
              v-model="convenientarr"
            />
            병원
          </label>
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4  mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              value="school"
              v-model="convenientarr"
            />
            학교
          </label>
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4 mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              v-model="convenientarr"
              value="kid"
            />
            유치원
          </label>
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4 mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              value="convenient"
              v-model="convenientarr"
            />
            편의점
          </label>
        </div>
        <div class="float-left pl-4 pr-10 w-full">
          <strong>교통 : </strong>
          <input
            type="range"
            max="10"
            v-model="transval"
            class="range ml-6 pl-4"
          />
          <strong> {{ transval }}</strong>
        </div>
        <div class="mx-auto p-3 float-left ml-3">
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4 mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              v-model="transarr"
              value="bus"
            />
            버스
          </label>
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4  mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              v-model="transarr"
              value="subway"
            />
            지하철
          </label>
          <label class="inline-flex items-center mr-2">
            <input
              class="text-indigo-500 w-4 h-4  mr-2 focus:ring-indigo-400 focus:ring-opacity-25 border border-gray-300 rounded"
              type="checkbox"
              v-model="transarr"
              value="bicycle"
            />
            자전거보관소
          </label>
        </div>
        <div class="float-left pl-4 w-full">
          <strong>면적 : </strong>
          <input
            type="range"
            max="10"
            v-model="areaval"
            class="range ml-6 pl-4"
          />
          <strong>{{ areaval }}</strong>
        </div>
        <div class="float-left pl-4 w-full">
          <strong>신식 : </strong>
          <input
            type="range"
            max="10"
            v-model="buildyearval"
            class="range ml-6 pl-4"
          />
          <strong> {{ buildyearval }}</strong>
        </div>
      </div>
      <div class="w-full">
        <button
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
          @click="getinfo"
        >
          비교하기
        </button>
      </div>
      <div v-if="searchflag">
        <div v-if="interests.length == 0">
          <div><strong>관심등록된 아파트가 없습니다.</strong></div>
          <div><strong>로그인 후 등록 해주세요</strong></div>
        </div>
        <div class="px-4 sm:px-6 lg:px-6">
          <div
            v-for="interest in interests"
            :key="interest.idx"
            class="max-w-lg px-8 py-8 mt-2 mb-2 rounded-md shadow-lg bg-white"
          >
            <div class="space-y-1 mt-2">
              <p class="text-sm font-medium leading-5 text-gray-600">
                {{ interest.home_name }}
              </p>
            </div>
            <div class="mt-6 flex items-center space-x-2">
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
                <span class="text-sm font-semibold leading-5 text-gray-900"
                  >총점 : {{ interest.totalScore }}</span
                >
              </div>
            </div>
          </div>
        </div>
        <div id="chart">
          <apexchart
            type="radar"
            height="350"
            :options="chartOptions"
            :series="series"
          ></apexchart>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import http from "@/util/http-common";
const memberStore = "memberStore";
export default {
  data() {
    return {
      modal: false,
      interests: [],
      convenienteval: 5,
      transval: 5,
      areaval: 5,
      buildyearval: 5,
      convenientarr: [],
      transarr: [],
      searchflag: false,
      series: [
        {
          name: "",
          data: [],
        },
      ],
      chartOptions: {
        chart: {
          height: 350,
          type: "radar",
        },
        title: {
          text: "항목 비교하기",
        },
        xaxis: {
          categories: ["교통", "편의", "신축", "면적"],
        },
      },
    };
  },
  watch: {},
  computed: {
    ...mapState(memberStore, ["memberInfo"]),
  },
  components: {},
  mounted() {},
  methods: {
    getinfo() {
      console.log(this.priceval);
      console.log(this.convenienteval);
      console.log(this.transval);
      console.log(this.areaval);
      console.log(this.buildyearval);
      console.log(this.convenientarr);
      console.log(this.transarr);
      http
        .post(`/interestapt/sort`, {
          iduser: this.memberInfo.iduser,
          priceval: this.review,
          convenienteval: this.convenienteval,
          transval: this.transval,
          areaval: this.areaval,
          buildyearval: this.buildyearval,
          convenientarr: this.convenientarr,
          transarr: this.transarr,
        })
        .then(({ data }) => {
          //console.log(data);
          this.interests = data;
          this.series = [];
          this.interests.forEach((item) => {
            this.series.push({
              name: item.home_name,
              data: [
                item.transScore,
                item.convenientScore,
                item.areaScore,
                item.buildScore,
              ],
            });
          });
          console.log(this.interests);
          this.searchflag = true;
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
