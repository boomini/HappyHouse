<template>
  <div>
    <div id="search_wrap" class="bg_white" style="width:19%; height:800px;">
      <div class="option" style="height: 300px; width:100%">
        <p
          class="text-md pb-3 pl-10 text-center ml-10 sm:text-xl text-gray-600 font-extrabold"
        >
          {{ getHomeInfo.homeName }}
          <button
            class="inline-flex float-right ml-5 "
            @click="registerinterest"
          >
            <img
              src="@/assets/images/interestbtn.png"
              style="width:40px; height:40px;"
            />
          </button>
        </p>

        <div
          class="w-full text-center float-center mt-8 sm:mt-0"
          style="height: 250px;"
        >
          <img
            class="object-none w-full"
            src="@/assets/images/house.png"
            style="height: 250px; width:100%"
            alt="Developer"
          />
        </div>
      </div>
      <div>
        <button
          @click="mvroadview"
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 ml-15 rounded-full"
        >
          로드뷰로 확인하기
        </button>
      </div>
      <p class="text-sm text-left text-gray-600 font-bold py-2">
        실거래가 정보
      </p>

      <div class="container flex justify-center mx-auto py-2">
        <div class="flex flex-col">
          <div class="w-full">
            <div class="border-b border-gray-200 shadow">
              <table class="divide-y divide-gray-300 ">
                <thead class="bg-gray-50">
                  <tr>
                    <th class="px-6 py-2 text-xs text-gray-500">
                      거래일
                    </th>
                    <th class="px-6 py-2 text-xs text-gray-500">
                      가격
                    </th>
                    <th class="px-6 py-2 text-xs text-gray-500">
                      면적
                    </th>
                    <th class="px-6 py-2 text-xs text-gray-500">
                      층
                    </th>
                  </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-300">
                  <map-deal-single
                    v-for="(house, index) in getHomeInfo.housedeal"
                    :key="index"
                    v-bind="house"
                  >
                  </map-deal-single>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <hr />

      <p class="text-sm text-left text-gray-600 font-bold py-2">
        전월세 정보보기
      </p>

      <div class="container flex justify-center mx-auto">
        <div class="flex flex-col">
          <div class="w-full">
            <div class="border-b border-gray-200 shadow">
              <table class="divide-y divide-gray-300 ">
                <thead class="bg-gray-50">
                  <tr>
                    <th class="px-4 py-2 text-xs text-gray-500">
                      거래일
                    </th>
                    <th class="px-3 py-2 text-xs text-gray-500">
                      보증금
                    </th>
                    <th class="px-3 py-2 text-xs text-gray-500">
                      월세
                    </th>
                    <th class="px-3 py-2 text-xs text-gray-500">
                      면적
                    </th>
                    <th class="px-3 py-2 text-xs text-gray-500">
                      층
                    </th>
                  </tr>
                </thead>
                <tbody
                  v-if="getHomeInfo.houserent"
                  class="bg-white divide-y divide-gray-300"
                >
                  <map-rent-single
                    v-for="(house, index) in getHomeInfo.houserent"
                    :key="index"
                    v-bind="house"
                  >
                  </map-rent-single>
                </tbody>
                <tbody v-else>
                  해당 정보가 없습니다.
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <hr />
      <p class="text-sm text-left text-gray-600 font-bold py-2">
        여기서 살아봤어요!!
      </p>
      <map-review> </map-review>
      <hr class="tx-3" />
      <rader-chart></rader-chart>
      <hr class="tx-3" />
      <rader-convenient></rader-convenient>
    </div>
  </div>
</template>

<!-- Required chart.js -->
<script>
import { mapGetters, mapState } from "vuex";
import MapDealSingle from "@/components/map/child/MapDealSingle.vue";
import MapRentSingle from "@/components/map/child/MapRentSingle.vue";
import MapReview from "@/components/map/child/MapReview.vue";
import RaderChart from "@/components/map/child/RaderChart.vue";
import http from "@/util/http-common";
//import DoughnutChart from "@/components/map/child/DoughnutChart.vue";
import RaderConvenient from "@/components/map/child/RaderConvenient.vue";
const memberStore = "memberStore";
//import Progress from "easy-circular-progress";
export default {
  name: "MapInfo",
  computed: {
    ...mapGetters([
      "getHospitalCnt",
      "getConvenientCnt",
      "getKidCnt",
      "getCafeCnt",
      "getSchoolCnt",
      "getTransCnt",
      "getHomeInfo",
      "getPosition",
    ]),
    ...mapState(memberStore, ["memberInfo"]),
  },

  components: {
    MapDealSingle,
    MapRentSingle,
    MapReview,
    RaderChart,
    // DoughnutChart,
    RaderConvenient,
    //Progress,
  },
  methods: {
    mvroadview() {
      this.$router.push({ name: "RoadView" });
    },
    registerinterest() {
      console.log(this.getHomeInfo.homeCode);
      console.log(this.getHomeInfo.homeName);
      console.log(this.getHomeInfo);
      console.log("hospital" + this.getHospitalCnt);
      console.log("convenient" + this.getConvenientCnt);
      console.log("kid" + this.getKidCnt);
      console.log("cafe" + this.getCafeCnt);
      console.log("school" + this.getSchoolCnt);
      console.log(this.getTransCnt.bus);
      console.log(this.getTransCnt.subway);
      console.log(this.getTransCnt.bicycle);
      console.log(this.getPosition.Ma);
      console.log(this.getPosition.La);
      console.log(this.memberInfo.iduser);
      http
        .post(`/interestapt`, {
          iduser: this.memberInfo.iduser,
          home_code: this.getHomeInfo.homeCode,
          home_name: this.getHomeInfo.homeName,
          lat: this.getPosition.Ma,
          lng: this.getPosition.La,
          buscnt: this.getTransCnt.bus,
          subcnt: this.getTransCnt.subway,
          biccnt: this.getTransCnt.bicycle,
          cafecnt: this.getCafeCnt,
          concnt: this.getConvenientCnt,
          kidcnt: this.getKidCnt,
          hoscnt: this.getHospitalCnt,
          schcnt: this.getSchoolCnt,
        })
        .then(({ data }) => {
          let msg = "질문 등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "관심 등록이 완료되었습니다.";
          }
          alert(msg);
        });
    },
  },
};
</script>

<style>
#progress_app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  height: 100vh;
  color: #fff;
  background: #3e423a;
  display: flex;
  justify-content: center;
  align-items: center;
}
#aptimg {
  height: 250px;
  object-fit: cover;
}
#search_wrap {
  position: absolute;
  top: 100px;
  left: 0;
  bottom: 0;
  width: 250px;
  margin: 10px 0 30px 10px;
  padding: 5px;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.7);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}
.bg_white {
  background: #fff;
}
#search_wrap hr {
  display: block;
  height: 1px;
  border: 0;
  border-top: 2px solid #5f5f5f;
  margin: 3px 0;
}
#search_wrap .option {
  text-align: center;
}
#search_wrap .option p {
  margin: 10px 0;
}
#search_wrap .option button {
  margin-left: 5px;
}
#search_placesList li {
  list-style: none;
}
#search_placesList .item {
  position: relative;
  border-bottom: 1px solid #888;
  overflow: hidden;
  cursor: pointer;
  min-height: 65px;
}
#search_placesList .item span {
  display: block;
  margin-top: 4px;
}
#search_placesList .item h5,
#search_placesList .item h5,
.item .info {
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
#search_placesList .item .info {
  padding: 10px 0 10px 55px;
}
#search_placesList .info .gray {
  color: #8a8a8a;
}
#search_placesList .info .jibun {
  padding-left: 26px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png)
    no-repeat;
}
#search_placesList .info .tel {
  color: #009900;
}
#search_placesList .item .markerbg {
  float: left;
  position: absolute;
  width: 36px;
  height: 37px;
  margin: 10px 0 0 10px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png)
    no-repeat;
}
#search_placesList .item .marker_1 {
  background-position: 0 -10px;
}
#search_placesList .item .marker_2 {
  background-position: 0 -56px;
}
#search_placesList .item .marker_3 {
  background-position: 0 -102px;
}
#search_placesList .item .marker_4 {
  background-position: 0 -148px;
}
#search_placesList .item .marker_5 {
  background-position: 0 -194px;
}
#search_placesList .item .marker_6 {
  background-position: 0 -240px;
}
#search_placesList .item .marker_7 {
  background-position: 0 -286px;
}
#search_placesList .item .marker_8 {
  background-position: 0 -332px;
}
#search_placesList .item .marker_9 {
  background-position: 0 -378px;
}
#search_placesList .item .marker_10 {
  background-position: 0 -423px;
}
#search_placesList .item .marker_11 {
  background-position: 0 -470px;
}
#search_placesList .item .marker_12 {
  background-position: 0 -516px;
}
#search_placesList .item .marker_13 {
  background-position: 0 -562px;
}
#search_placesList .item .marker_14 {
  background-position: 0 -608px;
}
#search_placesList .item .marker_15 {
  background-position: 0 -654px;
}
#search_pagination {
  margin: 10px auto;
  text-align: center;
}
#search_pagination a {
  display: inline-block;
  margin-right: 10px;
}
#search_pagination .on {
  font-weight: bold;
  cursor: default;
  color: #777;
}
</style>
