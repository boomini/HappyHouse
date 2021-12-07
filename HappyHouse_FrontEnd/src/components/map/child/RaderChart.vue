<template>
  <div id="chart">
    <apexchart
      type="radar"
      height="350"
      :options="chartOptions"
      :series="series"
    ></apexchart>
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
          name: "1km 내의 해당하는 수",
          data: [],
        },
      ],
      chartOptions: {
        chart: {
          height: 350,
          type: "radar",
        },
        title: {
          text: "대중교통 정보 확인하기",
        },
        xaxis: {
          categories: ["버스역", "지하철역", "자전거 보관소"],
        },
      },
    };
  },
  computed: {
    ...mapGetters(["getTransCnt"]),
  },
  watch: {
    "$store.state.map.transcnt": function() {
      this.series[0].data = [];
      this.series[0].data.push(this.getTransCnt.bus);
      this.series[0].data.push(this.getTransCnt.subway);
      this.series[0].data.push(this.getTransCnt.bicycle);
      console.log(this.series[0].data);
    },
  },
  created() {
    this.setTransCnt(this.$store.state.map.curposition);
    console.log(this.getTransCnt);
  },
  methods: {
    ...mapActions(["setTransCnt"]),
    getConvenientnum() {},
  },
};
</script>

<style></style>
