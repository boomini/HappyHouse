<template>
  <div id="chart">
    <apexchart
      type="radar"
      height="350"
      :options="chartOptions"
      :series="series"
    >
      <div>
        <strong>학교 : {{ getSchoolCnt }}</strong>
      </div>
      <div>
        <strong>병원 : {{ getHospitalCnt }}</strong>
      </div>
      <div>
        <strong>유치원 : {{ getKidCnt }}</strong>
      </div>
      <div>
        <strong>편의점 : {{ getConvenientCnt }}</strong>
      </div>
      <div>
        <strong>카페 : {{ getCafeCnt }}</strong>
      </div>
    </apexchart>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  components: {},
  data() {
    return {
      series: [
        {
          name: "500m 내의 해당하는 수",
          data: [],
        },
      ],
      chartOptions: {
        chart: {
          height: 350,
          type: "radar",
        },
        title: {
          text: "주변 편의시설 확인하기",
        },
        xaxis: {
          categories: ["학교", "병원", "유치원", "편의점", "카페"],
        },
      },
    };
  },
  computed: {
    ...mapGetters([
      "getHospitalCnt",
      "getConvenientCnt",
      "getKidCnt",
      "getCafeCnt",
      "getSchoolCnt",
    ]),
  },
  created() {
    console.log("created");
    this.setHospitalCnt(this.$store.state.map.curposition);
    this.setKidCnt(this.$store.state.map.curposition);
    this.setSchoolCnt(this.$store.state.map.curposition);
    this.setConvenientCnt(this.$store.state.map.curposition);
    this.setCafeCnt(this.$store.state.map.curposition);
    console.log(this.getSchoolCnt);
    console.log(this.getHospitalCnt);
    console.log(this.getKidCnt);
    console.log(this.getConvenientCnt);
    console.log(this.getCafeCnt);
    console.log("watch");
    this.series[0].data = [];
    this.series[0].data.push(this.getSchoolCnt);
    this.series[0].data.push(this.getHospitalCnt);
    this.series[0].data.push(this.getKidCnt);
    this.series[0].data.push(this.getConvenientCnt);
    this.series[0].data.push(this.getCafeCnt);
    console.log(this.series[0].data);
  },
  watch: {
    "$store.state.kakaoapi.cafecnt": function() {
      console.log("watch");
      this.series[0].data = [];
      this.series[0].data.push(this.getSchoolCnt);
      this.series[0].data.push(this.getHospitalCnt);
      this.series[0].data.push(this.getKidCnt);
      this.series[0].data.push(this.getConvenientCnt);
      this.series[0].data.push(this.getCafeCnt);
      console.log(this.series[0].data);
    },
  },
  methods: {
    ...mapActions([
      "setHospitalCnt",
      "setKidCnt",
      "setSchoolCnt",
      "setConvenientCnt",
      "setCafeCnt",
    ]),
  },
};
</script>

<style></style>
