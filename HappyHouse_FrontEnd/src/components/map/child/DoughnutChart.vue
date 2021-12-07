<template>
  <div id="chart">
    <apexchart
      type="radialBar"
      height="350"
      :options="chartOptions"
      :series="series"
    ></apexchart>
  </div>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      series: [30],
      plotOptions: {
        radialBar: {
          hollow: {
            margin: 15,
            size: "70%",
          },
        },
        dataLabels: {
          showOn: "always",
          name: {
            offsetY: -10,
            show: true,
            color: "#888",
            fontSize: "13px",
          },
          value: {
            color: "#111",
            fontSize: "30px",
            show: true,
          },
        },
      },

      stroke: {
        linkCap: "round",
      },
      labels: ["Progress"],
    };
  },
};
</script>

<style></style>
