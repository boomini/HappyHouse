<template>
  <div>
    <router-view
      class="float-left"
      style="width:20%; height:800px;"
    ></router-view>
    <div class="map_wrap float-right" style="width: 80%; height:800px;">
      <div id="map" style="width: 100%; height:800px;"></div>
      <div class="">
        <button
          class="inline-flex absolute left-5 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="openfloating"
          style="position:absolute; left:10px; top:120px;"
        >
          <img
            src="@/assets/images/plusicon.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag"
          class="inline-flex absolute left-5 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="closefloating"
          style="position:absolute; left:10px; top:120px;"
        >
          <img
            src="@/assets/images/closeicon.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag"
          class="inline-flex absolute left-5 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="subwaymarker"
          style="position:absolute; left:10px; top:170px;"
        >
          <img
            src="@/assets/images/subwayicon.jpg"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag"
          class="inline-flex absolute left-5 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="bicyclemarker"
          style="position:absolute; left:10px; top:220px;"
        >
          <img
            src="@/assets/images/bicycleicon.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag"
          class="inline-flex absolute left-5 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="busmarker"
          style="position:absolute; left:10px; top:270px;"
        >
          <img
            src="@/assets/images/busicon.png"
            style="width:40px; height:40px;"
          />
        </button>

        <!--편의기능-->
        <button
          class="inline-flex absolute left-15 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="openfloating2"
          v-if="!floatingflag2"
          style="position:absolute; left:60px; top:120px;"
        >
          <img
            src="@/assets/images/heart.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag2"
          class="inline-flex absolute left-15 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="closefloating2"
          style="position:absolute; left:60px; top:120px;"
        >
          <img
            src="@/assets/images/closeicon.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag2"
          class="inline-flex absolute left-15 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="hospitalmarker"
          style="position:absolute; left:60px; top:170px;"
        >
          <img
            src="@/assets/images/cart.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag2"
          class="inline-flex absolute left-15 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="schoolmarker"
          style="position:absolute; left:60px; top:220px;"
        >
          <img
            src="@/assets/images/school.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag2"
          class="inline-flex absolute left-15 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="cafemarker"
          style="position:absolute; left:60px; top:270px;"
        >
          <img
            src="@/assets/images/cafe.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag2"
          class="inline-flex absolute left-15 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="convenientmarker"
          style="position:absolute; left:60px; top:320px;"
        >
          <img
            src="@/assets/images/convenient.png"
            style="width:40px; height:40px;"
          />
        </button>
        <button
          v-if="floatingflag2"
          class="inline-flex absolute left-15 z-40 py-2 px-4 rounded inline-flex items-center"
          @click="kidmarker"
          style="position:absolute; left:60px; top:370px;"
        >
          <img src="@/assets/images/kid.png" style="width:40px; height:40px;" />
        </button>
        <div class="inline-flex absolute top-5 left-5 z-40">
          <svg
            class="w-2 h-2 absolute top-0 right-0 m-4 pointer-events-none"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 412 232"
          >
            <path
              d="M206 171.144L42.678 7.822c-9.763-9.763-25.592-9.763-35.355 0-9.763 9.764-9.763 25.592 0 35.355l181 181c4.88 4.882 11.279 7.323 17.677 7.323s12.796-2.441 17.678-7.322l181-181c9.763-9.764 9.763-25.592 0-35.355-9.763-9.763-25.592-9.763-35.355 0L206 171.144z"
              fill="#648299"
              fill-rule="nonzero"
            />
          </svg>
          <select
            @change="changesido($event)"
            class="border border-gray-300 rounded-full text-gray-600 h-10 pl-5 pr-10 bg-white hover:border-gray-400 focus:outline-none appearance-none"
          >
            <option>시도</option>
            <option
              v-for="sido in getSidoList"
              v-bind:key="sido.sidoCode"
              :value="sido.sidoCode"
              >{{ sido.sidoName }}</option
            >
          </select>
        </div>

        <div class="inline-flex absolute top-5 left-40 z-30 pl-10">
          <svg
            class="w-2 h-2 absolute top-0 right-0 m-4 pointer-events-none"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 412 232"
          >
            <path
              d="M206 171.144L42.678 7.822c-9.763-9.763-25.592-9.763-35.355 0-9.763 9.764-9.763 25.592 0 35.355l181 181c4.88 4.882 11.279 7.323 17.677 7.323s12.796-2.441 17.678-7.322l181-181c9.763-9.764 9.763-25.592 0-35.355-9.763-9.763-25.592-9.763-35.355 0L206 171.144z"
              fill="#648299"
              fill-rule="nonzero"
            />
          </svg>
          <select
            class="border border-gray-300 rounded-full text-gray-600 h-10 pl-5 pr-10 bg-white hover:border-gray-400 focus:outline-none appearance-none"
            @change="changegugun($event)"
          >
            <option>구/군</option>
            <option
              v-for="gugun in getGugunList"
              v-bind:key="gugun.gugunCode"
              :value="gugun.gugunCode"
              >{{ gugun.gugunName }}</option
            >
          </select>
        </div>

        <div class="inline-flex absolute top-5 left-40 z-20 ml-40 pl-5">
          <svg
            class="w-2 h-2 absolute top-0 right-0 m-4 pointer-events-none"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 412 232"
          >
            <path
              d="M206 171.144L42.678 7.822c-9.763-9.763-25.592-9.763-35.355 0-9.763 9.764-9.763 25.592 0 35.355l181 181c4.88 4.882 11.279 7.323 17.677 7.323s12.796-2.441 17.678-7.322l181-181c9.763-9.764 9.763-25.592 0-35.355-9.763-9.763-25.592-9.763-35.355 0L206 171.144z"
              fill="#648299"
              fill-rule="nonzero"
            />
          </svg>
          <select
            class="border border-gray-300 rounded-full text-gray-600 h-10 pl-5 pr-10 bg-white hover:border-gray-400 focus:outline-none appearance-none"
            @change="changedong($event)"
          >
            <option>동</option>
            <option
              v-for="dong in getDongList"
              v-bind:key="dong.dongCode"
              :value="dong.dongCode"
              >{{ dong.dongName }}</option
            >
          </select>
        </div>
        <button
          v-if="memberInfo"
          class="absolute top-3 left-40 z-10 ml-40 pl-40 py-2 px-4 rounded inline-flex items-center"
          @click="interestArea"
        >
          <img
            src="@/assets/images/star_favourite.png"
            alt="관심지역 등록하기"
            style="width:40px; height:40px;"
          />
        </button>
        <div class="inline-flex absolute top-20 left-5 z-10">
          <svg
            class="w-2 h-2 absolute top-0 right-0 m-4 pointer-events-none"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 412 232"
          >
            <path
              d="M206 171.144L42.678 7.822c-9.763-9.763-25.592-9.763-35.355 0-9.763 9.764-9.763 25.592 0 35.355l181 181c4.88 4.882 11.279 7.323 17.677 7.323s12.796-2.441 17.678-7.322l181-181c9.763-9.764 9.763-25.592 0-35.355-9.763-9.763-25.592-9.763-35.355 0L206 171.144z"
              fill="#648299"
              fill-rule="nonzero"
            />
          </svg>

          <select
            class="border border-gray-300 rounded-full text-gray-600 h-10 pl-5 pr-10 bg-white hover:border-gray-400 focus:outline-none appearance-none"
            v-if="memberInfo"
            @change="changedong($event)"
          >
            <option>관심지역 모아보기</option>
            <option
              v-for="(dongname, index) in memberInfo.dongname"
              v-bind:key="index"
              :value="memberInfo.dongcode[index]"
              >{{ dongname }}</option
            >
          </select>
        </div>
      </div>
      <!-- 지도타입 컨트롤 div 입니다 -->
      <div class="inline-flex custom_typecontrol radius_border">
        <span
          id="btnRoadmap"
          class="selected_btn"
          @click="setMapType('roadmap')"
          >지도</span
        >
        <span id="btnSkyview" @click="setMapType('skyview')">스카이뷰</span>
      </div>
      <!-- 지도 확대, 축소 컨트롤 div 입니다 -->
      <div class="inline-flex custom_zoomcontrol radius_border">
        <span @click="zoomIn"
          ><img
            src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_plus.png"
            alt="확대"
        /></span>
        <span @click="zoomOut"
          ><img
            src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_minus.png"
            alt="축소"
        /></span>
      </div>
    </div>
  </div>
  <!-- <div class="container mx-auto sm:flex py-5 sm:py-10 mt-10 sm:mt-20">
    <router-view></router-view>
  </div> -->
</template>

<script>
import { mapGetters, mapActions, mapMutations, mapState } from "vuex";

const memberStore = "memberStore";

export default {
  data() {
    return {
      map: "",
      selectedsido: "",
      selectedgugun: "",
      selecteddong: "",
      apt_markers: [],
      convenient_markers: [],
      alert: false,
      floatingflag: false,
      floatingflag2: false,
    };
  },
  created() {
    console.log(this.selectedsido);
    this.setSidoList();
  },
  computed: {
    ...mapGetters([
      "getSidoList",
      "getGugunList",
      "getDongList",
      "getHomeList",
      "getBusList",
      "getBicycleList",
      "getSubwayList",
    ]),
    ...mapState(memberStore, ["memberInfo"]),
  },
  watch: {
    "$store.state.map.homes": function() {
      console.log(this.$store.state.map.homes);
      this.getPlaces(this.$store.state.map.homes);
      this.$router.push({ name: "MapSearchList" });
    },
    "$store.state.map.subways": function() {
      this.addConvenienceMarker(this.$store.state.map.subways, "SUB");
    },
    "$store.state.map.bicycles": function() {
      this.addConvenienceMarker(this.$store.state.map.bicycles, "BIC");
    },
    "$store.state.kakaoapi.hospitals": function() {
      this.addConvenienceMarker(this.$store.state.kakaoapi.hospitals, "HOS");
    },
    "$store.state.kakaoapi.schools": function() {
      this.addConvenienceMarker(this.$store.state.kakaoapi.schools, "SCH");
    },
    "$store.state.kakaoapi.cafes": function() {
      this.addConvenienceMarker(this.$store.state.kakaoapi.cafes, "CAF");
    },
    "$store.state.kakaoapi.convenients": function() {
      this.addConvenienceMarker(this.$store.state.kakaoapi.convenients, "CON");
    },
    "$store.state.kakaoapi.kids": function() {
      this.addConvenienceMarker(this.$store.state.kakaoapi.kids, "KID");
    },
    "$store.state.map.busstations": function() {
      this.addConvenienceMarker(this.$store.state.map.busstations, "BUS");
    },
    memberInfo: function() {
      console.log("memberInfo");
    },
  },
  mounted() {
    console.log("check");
    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },
  methods: {
    ...mapActions([
      "setSidoList",
      "setGugunList",
      "setDongList",
      "setHomeList",
      "setSubwayList",
      "setBusList",
      "setBicycleList",
      "setHospitalList",
      "setSchoolList",
      "setCafeList",
      "setConvenientList",
      "setKidList",
    ]),
    ...mapMutations(["SET_HOME", "SET_POSITION", "SET_REVIEW_HOMECODE"]),
    ...mapActions(memberStore, ["addInterest", "removeInterest"]),

    changesido(event) {
      this.selectedsido = event.target.value;
      this.setGugunList(this.selectedsido);
      console.log(this.selectedsido);
    },
    subwaymarker() {
      //this.addConvenienceMarker(this.getSubwayList, "SUB");
      this.setSubwayList(this.$store.state.map.curposition);
      console.log(this.$store.state.map.curposition);
    },
    bicyclemarker() {
      //this.addConvenienceMarker(this.getBicycleList, "BIC");
      this.setBicycleList(this.$store.state.map.curposition);
    },
    busmarker() {
      //this.addConvenienceMarker(this.getBusList, "BUS");
      this.setBusList(this.$store.state.map.curposition);
    },
    hospitalmarker() {
      this.setHospitalList(this.$store.state.map.curposition);
    },
    schoolmarker() {
      this.setSchoolList(this.$store.state.map.curposition);
    },
    cafemarker() {
      this.setCafeList(this.$store.state.map.curposition);
    },
    convenientmarker() {
      this.setConvenientList(this.$store.state.map.curposition);
    },
    kidmarker() {
      this.setKidList(this.$store.state.map.curposition);
    },
    changegugun(event) {
      this.selectedgugun = event.target.value;
      this.setDongList(this.selectedgugun);
    },
    async changedong(event) {
      this.selecteddong = event.target.value;
      console.log(this.selecteddong);
      await this.setHomeList(this.selecteddong);

      //this.getPlaces(this.$store.state.map.apts);
    },
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };
      this.map = new kakao.maps.Map(container, options);
      //마커추가하려면 객체를 아래와 같이 하나 만든다.
    },
    buscontent(place) {
      var content =
        '<div class="info">' +
        '   <div class="title">' +
        place.id +
        " : " +
        place.station +
        "</div>" +
        "</div>";

      return content;
    },
    subwaycontent(place) {
      var content =
        '<div class="info">' +
        '   <div class="title">' +
        place.train +
        " : " +
        place.station +
        "</div>" +
        "</div>";

      return content;
    },
    bicyclecontent(place) {
      var content =
        '<div class="info">' +
        '   <div class="title">' +
        place.id +
        " : " +
        place.place +
        "</div>" +
        "</div>";

      return content;
    },
    convenientcontent(place) {
      var content =
        '<div class="info">' + '   <div class="title">' + place.place_name;
      "</div>" + "</div>";

      return content;
    },
    addConvenienceMarker(places, type) {
      console.log(places);
      this.removeConvenientMarker();

      //아파트숫자 마커 등록
      for (const place of places) {
        let position = "";
        console.log(place);
        let imageSrc = "";
        let imageSize = "";
        let imageOption = "";
        let content = "";
        if (type == "SUB") {
          console.log("지하철뿌려주기");
          (imageSrc = require("@/assets/images/subwayicon.jpg")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.subwaycontent(place));
          position = new kakao.maps.LatLng(place.lat, place.lng);
        }
        if (type == "BUS") {
          console.log("버스뿌려주기");
          (imageSrc = require("@/assets/images/busicon.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.buscontent(place));
          position = new kakao.maps.LatLng(place.lat, place.lng);
        }
        if (type == "BIC") {
          console.log("자전거뿌려주기");
          (imageSrc = require("@/assets/images/bicycleicon.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.bicyclecontent(place));
          position = new kakao.maps.LatLng(place.lat, place.lng);
        }
        if (type == "HOS") {
          (imageSrc = require("@/assets/images/cart.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.convenientcontent(place));
          position = new kakao.maps.LatLng(place.y, place.x);
        }
        if (type == "SCH") {
          (imageSrc = require("@/assets/images/school.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.convenientcontent(place));
          position = new kakao.maps.LatLng(place.y, place.x);
        }
        if (type == "CAF") {
          (imageSrc = require("@/assets/images/cafe.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.convenientcontent(place));
          position = new kakao.maps.LatLng(place.y, place.x);
        }
        if (type == "KID") {
          (imageSrc = require("@/assets/images/kid.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.convenientcontent(place));
          position = new kakao.maps.LatLng(place.y, place.x);
        }
        if (type == "CON") {
          (imageSrc = require("@/assets/images/convenient.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(25, 25)), // 마커 이미지의 크기
            (content = this.convenientcontent(place));
          position = new kakao.maps.LatLng(place.y, place.x);
        }
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });
        var markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        );
        var marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });
        // }

        console.log(marker.getPosition());
        marker.setMap(this.map); // 지도 위에 마커를 표출합니다
        this.convenient_markers.push(marker); // 배열에 생성된 마커를 추가합니다
        var map = this.map;

        (function(marker) {
          var infowindow = new kakao.maps.InfoWindow({ removable: true });
          kakao.maps.event.addListener(marker, "click", () => {
            //this.displayInfowindow(marker, title);
            infowindow.setContent(content);
            infowindow.setPosition(position);
            infowindow.setMap(map);
            // 커스텀 오버레이를 생성합니다
            // mapCustomOverlay = new kakao.maps.CustomOverlay({
            //   position: marker.getPosition(),
            //   content: content,
            //   xAnchor: 0.5, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
            //   yAnchor: 1.5, // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
            // });
            // // 커스텀 오버레이를 지도에 표시합니다
            // mapCustomOverlay.setMap(map);
          });

          //클릭시
          // kakao.maps.event.addListener(marker, "click", function() {

          // });
        })(marker);
      }
    },
    //displayInfowindow: (marker, title) => {},
    addAptMarker(positions, homes) {
      var bounds = new kakao.maps.LatLngBounds();
      var idx = 0;
      //아파트숫자 마커 등록
      for (const position of positions) {
        bounds.extend(position);
        console.log(position);
        var imageSrc = "";
        var imageSize = "";
        var imageOption = "";
        if (homes[idx].type == "A") {
          console.log("아파트뿌려주기");
          (imageSrc = require("@/assets/images/apart.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(45, 45)); // 마커 이미지의 크기
        }
        if (homes[idx].type == "O") {
          console.log("오피스텔뿌려주기");
          (imageSrc = require("@/assets/images/office.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(45, 45)); // 마커 이미지의 크기
        }
        if (homes[idx].type == "H") {
          console.log("주택뿌려주기");
          (imageSrc = require("@/assets/images/home.png")), // 마커 이미지 url, 스프라이트 이미지를 씁니다
            (imageSize = new kakao.maps.Size(45, 45)), // 마커 이미지의 크기
            (imageOption = { offset: new kakao.maps.Point(27, 69) });
        }
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });
        var markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        );
        var marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });
        // }

        console.log(marker.getPosition());
        marker.setMap(this.map); // 지도 위에 마커를 표출합니다
        this.apt_markers.push(marker); // 배열에 생성된 마커를 추가합니다
        var map = this.map;
        var mapCustomOverlay;
        let self = this;
        let imgPath = require("@/assets/images/apt.png");
        let imgPath2 = require("@/assets/images/house_green.png");

        (function(marker, home, position) {
          kakao.maps.event.addListener(marker, "mouseover", () => {
            //this.displayInfowindow(marker, title);
            console.log(position);

            console.log(
              home.avgPrice + " " + home.recentPrice + " " + home.homeName
            );
            console.log(home);

            var content = '<div class="custom_overlay_info">';
            content +=
              `    <a target="_blank"><img src="${imgPath2}" alt="" style="margin-bottom:5px; margin-right:5px; float:left; height:30px; width=30px;"><strong>` +
              home.homeName +
              `</strong></a>`;
            content += '    <div class="desc">';
            content += `<img src="${imgPath}" alt="" style="height:60px; width=80px;">`;
            if (home.avgPrice == null) {
              content +=
                `<span v-if="home.avgPrice!=null"class="address"> ` +
                `<p class="text-sm text-gray-600">
          <div><strong>매매내역이</strong></div><div><strong> 확인되지 않습니다.</strong></div>
        </p>
              </span>`;
            } else {
              content +=
                `<span v-if="home.avgPrice!=null"class="address"> ` +
                `<p class="text-sm text-gray-600">
          평균금액 : ${home.avgPrice}
        </p>
        <p class="text-sm text-gray-600">
          최신금액 : ${home.recentPrice}
        </p>
              </span>`;
            }

            content += "    </div>";
            content += "</div>";

            // 커스텀 오버레이를 생성합니다
            mapCustomOverlay = new kakao.maps.CustomOverlay({
              position: marker.getPosition(),
              content: content,
              xAnchor: 0.5, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
              yAnchor: 1.3, // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
            });

            self.SET_HOME({ homeCode: home.homeCode });
            self.SET_POSITION({ position: position });
            self.SET_REVIEW_HOMECODE({ homeCode: home.homeCode });
            self.$router.push({ name: "MapInfo" });
            // 커스텀 오버레이를 지도에 표시합니다
            console.log(position);
            mapCustomOverlay.setMap(map);
            console.log(home.homeCode);
          });

          kakao.maps.event.addListener(marker, "mouseout", function() {
            mapCustomOverlay.setMap(null);
          });

          //클릭시
          // kakao.maps.event.addListener(marker, "click", function() {

          // });
        })(marker, homes[idx], position);
        idx++;
      }
      this.map.setBounds(bounds);
    },

    async getPlaces(homes) {
      // 주소-좌표 변환 객체를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();
      console.log(this.map);
      console.log(homes.length);
      const positions = [];
      this.removeMarker();
      for (var home of homes) {
        const result = await this.searchAddress(geocoder, home);
        positions.push(result);
      }

      this.addAptMarker(positions, homes);
    },
    searchAddress(geocoder, home) {
      return new Promise((resolve, reject) => {
        console.log(home.dongName + " " + home.jibun);
        // 주소로 좌표를 검색합니다
        geocoder.addressSearch(home.dongName + " " + home.jibun, function(
          result,
          status
        ) {
          // 정상적으로 검색이 완료됐으면
          if (status === kakao.maps.services.Status.OK) {
            resolve(new kakao.maps.LatLng(result[0].y, result[0].x));
          } else {
            reject(status);
          }
        });
      });
    },
    addScript() {
      console.log("addScript");
      const script = document.createElement("script"); /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9f562a2d765c9df3fcaf2706174306ec&libraries=services,clusterer,drawing";
      document.head.appendChild(script);
    },
    setMapType(maptype) {
      var roadmapControl = document.getElementById("btnRoadmap");
      var skyviewControl = document.getElementById("btnSkyview");
      if (maptype === "roadmap") {
        this.map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP);
        roadmapControl.className = "selected_btn";
        skyviewControl.className = "btn";
      } else {
        this.map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);
        skyviewControl.className = "selected_btn";
        roadmapControl.className = "btn";
      }
    },
    removeMarker() {
      for (var i = 0; i < this.apt_markers.length; i++) {
        this.apt_markers[i].setMap(null);
      }
      this.apt_markers = [];
    },
    removeConvenientMarker() {
      console.log("removeCheck");
      for (var i = 0; i < this.convenient_markers.length; i++) {
        this.convenient_markers[i].setMap(null);
      }
      this.convenient_markers = [];
    },
    zoomIn() {
      this.map.setLevel(this.map.getLevel() - 1);
    },
    zoomOut() {
      this.map.setLevel(this.map.getLevel() + 1);
    },
    interestArea() {
      this.alert = true;
      console.log(this.alert);

      if (this.selectedsido && this.selectedgugun && this.selecteddong) {
        alert("관심등록 직전");
        this.addInterest({
          dongcode: this.selecteddong,
          memberid: this.memberInfo.iduser,
        });
      }
    },
    openfloating() {
      this.floatingflag = true;
    },
    closefloating() {
      this.floatingflag = false;
    },
    openfloating2() {
      this.floatingflag2 = true;
    },
    closefloating2() {
      this.floatingflag2 = false;
    },
  },
};
</script>

<style>
.info {
  font-size: 12px;
  padding: 5px;
}
.info .title {
  font-weight: bold;
}
.custom_overlay_info {
  height: 130px;
  width: 271px;
  border-radius: 6px;
  margin-bottom: 12px;
  float: left;
  position: relative;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  background-color: #fff;
}
.custom_overlay_info:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.custom_overlay_info a {
  display: block;
  background: #d95050;
  background: #d95050 no-repeat right 14px center;
  text-decoration: none;
  color: #fff;
  padding: 12px 36px 12px 14px;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
}
.custom_overlay_info a strong {
  background: url(http://www.w3.org/2000/svg) no-repeat;
}
.custom_overlay_info .desc {
  padding: 14px;
  position: relative;
  min-width: 190px;
  height: 56px;
}
.custom_overlay_info .address {
  font-size: 12px;
  color: #333;
  position: absolute;
  left: 80px;
  right: 14px;
  top: 24px;
  white-space: normal;
}
.custom_overlay_info:after {
  content: "";
  position: absolute;
  margin-left: -11px;
  left: 50%;
  bottom: -12px;
  width: 22px;
  height: 12px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png)
    no-repeat 0 bottom;
}
.map_wrap {
  position: relative;
  overflow: hidden;
  width: 100%;
  height: 800px;
}
.radius_border {
  border: 1px solid #919191;
  border-radius: 5px;
}
.custom_typecontrol {
  position: absolute;
  top: 10px;
  right: 10px;
  overflow: hidden;
  width: 130px;
  height: 30px;
  margin: 0;
  padding: 0;
  z-index: 1;
  font-size: 12px;
  font-family: "Malgun Gothic", "맑은 고딕", sans-serif;
}
.custom_typecontrol span {
  display: block;
  width: 65px;
  height: 30px;
  float: left;
  text-align: center;
  line-height: 30px;
  cursor: pointer;
}
.custom_typecontrol .btn {
  background: #fff;
  background: linear-gradient(#fff, #e6e6e6);
}
.custom_typecontrol .btn:hover {
  background: #f5f5f5;
  background: linear-gradient(#f5f5f5, #e3e3e3);
}
.custom_typecontrol .btn:active {
  background: #e6e6e6;
  background: linear-gradient(#e6e6e6, #fff);
}
.custom_typecontrol .selected_btn {
  color: #fff;
  background: #425470;
  background: linear-gradient(#425470, #5b6d8a);
}
.custom_typecontrol .selected_btn:hover {
  color: #fff;
}
.custom_zoomcontrol {
  position: absolute;
  top: 50px;
  right: 10px;
  width: 36px;
  height: 80px;
  overflow: hidden;
  z-index: 1;
  background-color: #f5f5f5;
}
.custom_zoomcontrol span {
  display: block;
  width: 36px;
  height: 40px;
  text-align: center;
  cursor: pointer;
}
.custom_zoomcontrol span img {
  width: 15px;
  height: 15px;
  padding: 12px 0;
  border: none;
}
.custom_zoomcontrol span:first-child {
  border-bottom: 1px solid #bfbfbf;
}
</style>
