<template>
  <div>
    <canvas id="planet-chart" style="height:300px;"></canvas>
  </div>
</template>

<script>
import Chart from "chart.js/auto";
import planetChartData from "@/assets/js/chart-data.js";
import http from "@/util/http-common";
export default {
  name: "BarChart",
  data() {
    return {
      planetChartData: planetChartData,
    };
  },
  methods: {
    createBarChart(charId, chartData) {
      const ctx = document.getElementById(charId);
      new Chart(ctx, {
        type: chartData.type,
        data: chartData.data,
        options: chartData.options,
      });
    },
  },
  mounted() {
    http.get("/word/interestrank").then(({ data }) => {
      console.log(data);
      data.forEach((item) => {
        console.log(item);

        this.planetChartData.data.labels.push(item.text);
        this.planetChartData.data.datasets[0].data.push(item.size);
      });
    });
    this.createBarChart("planet-chart", this.planetChartData);
  },
};
</script>
