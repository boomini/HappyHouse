export const planetChartData = {
  type: "bar",
  data: {
    labels: [
      "신갈동",
      "남대문로5가",
      "노고산동",
      "반포동",
      "답십리동",
      "신수동",
    ],
    datasets: [
      {
        label: "관심지역등록된동네",
        data: [27, 38, 15, 19, 21, 16, 15],
        // data: [],
        backgroundColor: "rgba(54,73,93,.5)",
        borderColor: "#36495d",
        borderWidth: 3,
      },
    ],
  },
  options: {
    responsive: true,
    lineTension: 1,
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true,
            padding: 25,
          },
          gridLines: {
            color: "white",
          },
        },
      ],
    },
  },
};

export default planetChartData;
