<template>
  <div>
    <div id="search_wrap" class="bg_white" style="width:19%; height:800px;">
      <div class="option">
        <p class="text-md sm:text-xl text-gray-600">
          하우스검색목록
        </p>
      </div>
      <hr />
      <ul id="search_placesList">
        <li
          class="item"
          v-for="(home, index) in getHomeList"
          :key="index"
          v-bind="home"
        >
          <span :class="`markerbg marker_${index + 1}`"></span>
          <div class="info">
            <p class="font-extrabold">{{ home.homeName }}</p>
            <span class="jibun gray">{{ home.dongName }} {{ home.jibun }}</span>
            <span class="tel">건축년도 : {{ home.buildYear }}</span>
          </div>
        </li>
      </ul>
      <div id="search_pagination"></div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {};
  },
  computed: {
    ...mapGetters(["getHomeList"]),
  },
  methods: {},
};
</script>

<style>
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
