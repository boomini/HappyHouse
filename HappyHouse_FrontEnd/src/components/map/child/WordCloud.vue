<template>
  <div id="word-cloud"></div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  data() {
    return {
      words: [
        // { text: "엘에이치강남8단지", size: 64 },
        // { text: "더하이엔드", size: 53 },
        // { text: "ggggggggggggggggggggg", size: 10 },
        // { text: "Bad", size: 25 },
        // { text: "Title", size: 50 },
        // { text: "Style", size: 40 },
        // { text: "Vue", size: 30 },
        // { text: "Javascript", size: 24 },
        // { text: "HTML", size: 10 },
        // { text: "CSS", size: 34 },
        // { text: "Hello", size: 20 },
        // { text: "Bye", size: 30 },
        // { text: "Good", size: 10 },
        // { text: "Bad", size: 25 },
        // { text: "Title", size: 50 },
        // { text: "Style", size: 40 },
        // { text: "Vue", size: 30 },
        // { text: "Javascript", size: 24 },
        // { text: "HTML", size: 10 },
        // { text: "CSS", size: 34 },
      ],
    };
  },
  watch: {
    "$store.state.map.words": function() {
      console.log(this.$store.state.map.words);
      this.genLayout(this.$store.state.map.words);
    },
  },

  created() {
    this.setWordList();
  },
  methods: {
    ...mapActions(["setWordList"]),
    genLayout(words) {
      console.log(words);
      const cloud = require("d3-cloud");
      cloud()
        .words(words)
        .padding(1)
        .rotate(function(d) {
          return d.size > 15 ? 0 : 90;
        })
        .font("Impact")
        .fontSize(function(d) {
          return d.size;
        })
        .on("end", this.end)
        .spiral("archimedean")
        .start()
        .stop();
    },
    getRandom(min, max) {
      return Math.floor(Math.random() * (max - min) + min);
    },
    async end(words) {
      const d3 = require("d3");
      const width = 300;
      const height = 300;
      // let wordScale = d3.scale
      //   .linear()
      //   .domain([0, 100])
      //   .range([0, 150])
      //   .clamp(true);
      //let self = this;
      console.log(words);
      var cloud = d3
        .select("#word-cloud")
        .append("svg")

        .attr("width", width)
        .attr("height", height)
        .on("mouseover", function() {
          console.log("check");
        })
        .style("background", "white")
        .append("g")
        .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")") // g를 중심에서 단어들을 그리기 때문에 g를 svg 중심으로 이동
        .selectAll("text")
        .on("mouseover", function() {
          console.log("check");
        })
        .data(words);

      cloud
        .enter()
        .append("text")
        .on("click", function(d) {
          console.log(d.size);
        })
        .style("font-size", (d) => {
          return d.size + "px";
        })
        .style("fill", function(d) {
          console.log(d.size);
          if (d.size > 30) {
            return "#bcabe2";
          }
          if (d.size > 20) {
            return "#8496e2";
          }
          if (d.size > 15) {
            return "#dfcaab";
          }
          return "#f2b4b5";
        })
        .style("font-family", "Impact")
        .attr("text-anchor", "middle")
        .attr("transform", (d, i) => {
          console.log(d.x + " " + d.y + " " + d.text + " " + d.size + " " + i);
          return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
        })
        .text((d) => d.text);
    },
  },
};
</script>
