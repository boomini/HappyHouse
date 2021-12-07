<template>
  <div style="width:19%; height:800px;">
    <div
      class="content-center"
      id="roadview"
      style="width:100%; height:800px;"
    ></div>
    <button
      @click="mvBack"
      class="inline-flex absolute bottom-20 px-10 mr-100 content-center bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
    >
      돌아가기
    </button>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters({
      getPosition: "getPosition",
    }),
  },
  mounted() {
    // http.get(`/qna`).then(({ data }) => {
    //   this.qnas = data;
    // });
    this.addScript();
    this.makeRoadView();
  },
  methods: {
    makeRoadView() {
      var roadviewContainer = document.getElementById("roadview"); //로드뷰를 표시할 div
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
      // var position = new kakao.maps.LatLng(
      //   37.27213828251842,
      //   127.10857095560041
      // );
      let self = this;
      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      roadviewClient.getNearestPanoId(
        self.$store.state.map.curposition,
        50,
        function(panoId) {
          roadview.setPanoId(panoId, self.$store.state.map.curposition); //panoId와 중심좌표를 통해 로드뷰 실행
        }
      );
    },
    addScript() {
      console.log("addScript");
      const script = document.createElement("script"); /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9f562a2d765c9df3fcaf2706174306ec&libraries=services,clusterer,drawing";
      document.head.appendChild(script);
    },
    mvBack() {
      this.$router.push({ name: "MapInfo" });
    },
  },
};
</script>

<style></style>
