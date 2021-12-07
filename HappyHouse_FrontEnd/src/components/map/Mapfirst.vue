<template>
  <div>
    <div id="search_wrap" class="bg_white" style="width:19%; height:800px;">
      <div class="option">
        <p class="text-md sm:text-xl text-gray-600 font-extrabold">
          어떤 집을 찾고 계세요?
        </p>
      </div>
      <hr />
      <div class="px-3 content-center">
        <nav class="tabs flex flex-col sm:flex-row">
          <button
            data-target="panel-1"
            @click="mvtab1"
            :class="{ active: tab1 }"
            class="tab text-gray-600 py-2 px-2 focus:outline-none"
          >
            <p
              class="text-sm text-gray-600 font-extrabold block hover:text-blue-500"
            >
              실시간 뉴스
            </p></button
          ><button
            data-target="panel-2"
            @click="mvtab2"
            :class="{ active: tab2 }"
            class="tab text-gray-600 py-2 px-2 block hover:text-blue-500 focus:outline-none"
          >
            <p
              class="text-sm text-gray-600 font-extrabold block hover:text-blue-500"
            >
              인기하우스
            </p></button
          ><button
            data-target="panel-3"
            :class="{ active: tab3 }"
            @click="mvtab3"
            class="tab text-gray-600 py-2 px-2 block hover:text-blue-500 focus:outline-none"
          >
            <p
              class="text-sm text-gray-600 font-extrabold block hover:text-blue-500"
            >
              관심아파트
            </p>
          </button>
        </nav>
      </div>

      <div id="panels">
        <div :class="{ active: tab1 }" class="panel-1 tab-content py-5">
          <p class="text-sm text-left text-gray-600 font-bold py-2">
            부동산 실시간 뉴스
          </p>

          <div class="container flex justify-center mx-auto py-2">
            <div class="flex flex-col">
              <div class="w-full">
                <div class="border-b border-gray-200 shadow">
                  <table class="divide-y divide-gray-300 ">
                    <thead class="bg-gray-50">
                      <tr>
                        <th class="px-6 py-2 text-xs text-gray-500">
                          번호
                        </th>
                        <th class="px-6 py-2 text-xs text-gray-500">
                          제목
                        </th>
                      </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-300">
                      <tr
                        class="whitespace-nowrap"
                        v-for="(news, index) in newsData2"
                        v-bind="news"
                        :key="index"
                      >
                        <td class="px-5 py-4 text-sm text-gray-500">
                          {{ index + 1 }}
                        </td>
                        <td class="px-3 py-4 ">
                          <div
                            class="text-sm text-gray-900 hover:text-blue-500 cursor-pointer"
                            @click="mvnews(news.originallink)"
                          >
                            {{ news.title }}
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <hr class="px-10" />
          <p class="text-sm text-left text-gray-600 font-bold py-2">
            관심지역 실시간 뉴스
          </p>
          <div class="container flex justify-center mx-auto py-2">
            <div class="flex flex-col">
              <div class="w-full">
                <div class="border-b border-gray-200 shadow">
                  <table class="divide-y divide-gray-300 ">
                    <thead class="bg-gray-50">
                      <tr>
                        <th class="px-6 py-2 text-xs text-gray-500">
                          번호
                        </th>
                        <th class="px-6 py-2 text-xs text-gray-500">
                          제목
                        </th>
                      </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-300">
                      <tr
                        class="whitespace-nowrap"
                        v-for="(news, index) in newsData"
                        v-bind="news"
                        :key="index"
                      >
                        <td class="px-5 py-4 text-sm text-gray-500">
                          {{ index + 1 }}
                        </td>
                        <td class="px-3 py-4">
                          <div
                            class="text-sm text-gray-900 hover:text-blue-500 cursor-pointer"
                            @click="mvnews(news.originallink)"
                          >
                            {{ news.title }}
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div :class="{ active: tab2 }" class="panel-2 tab-content py-5">
          <p class="text-sm text-left text-gray-600 font-bold py-2">
            TOP 20 매매율 높은동네
          </p>
          <word-cloud> </word-cloud>
          <hr />
          <p class="text-sm text-left text-gray-600 font-bold py-2">
            TOP 6 즐겨찾기 동네
          </p>
          <bar-chart> </bar-chart>
        </div>
        <div :class="{ active: tab3 }" class="panel-3 tab-content py-5">
          <p class="text-sm text-left text-gray-600 font-bold py-2 ml-3">
            검색 우선순위(가중치)를 설정해주세요
          </p>
          <interest-apt></interest-apt>
        </div>
      </div>
      <div id="search_pagination"></div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import http from "@/util/http-common";
import WordCloud from "@/components/map/child/WordCloud.vue";
import BarChart from "@/components/map/child/BarChart.vue";
import InterestApt from "@/components/map/child/InterestApt.vue";
export default {
  name: "MapInfo",
  components: {
    WordCloud,
    BarChart,
    InterestApt,
  },
  data: () => {
    return {
      clicked: "tab1",
      tab1: true,
      tab2: false,
      tab3: false,
      newsData: [],
      newsData2: [],
    };
  },
  computed: {
    ...mapGetters({
      getAptInfo: "getAptInfo",
    }),
  },
  mounted() {
    http
      .get("/map/news/`부동산`")
      .then((response) => {
        console.log(response);
        if (response.data == "") {
          alert("글이 없습니다");
        } else {
          this.newsData2 = response.data.items;
          for (var i = 0; i < 5; i++) {
            // this.newsData[i].title = {
            //   title: this.newsData[i].title.replace(/(<([^>]+)>)/gi, ''),
            // };
            this.newsData2[i].title = response.data.items[i].title.replace(
              /(<([^>]+)>)/gi,
              ""
            );
            if (this.newsData2[i].title.length > 20) {
              this.newsData2[i].title =
                this.newsData2[i].title.substr(0, 20) + "...";
            }
          }
        }
      })
      .catch(() => {
        console.log("글 불러오기 실패.");
      });
    http
      .get("/map/news/`남대문로5가`")
      .then((response) => {
        console.log(response);
        if (response.data == "") {
          alert("글이 없습니다");
        } else {
          this.newsData = response.data.items;
          for (var i = 0; i < 5; i++) {
            // this.newsData[i].title = {
            //   title: this.newsData[i].title.replace(/(<([^>]+)>)/gi, ''),
            // };
            this.newsData[i].title = response.data.items[i].title.replace(
              /(<([^>]+)>)/gi,
              ""
            );
            if (this.newsData[i].title.length > 20) {
              this.newsData[i].title =
                this.newsData[i].title.substr(0, 20) + "...";
            }
          }
        }
      })
      .catch(() => {
        console.log("글 불러오기 실패.");
      });
  },
  methods: {
    wordClickHandler(name, value, vm) {
      console.log("wordClickHandler", name, value, vm);
    },
    mvtab1() {
      this.tab1 = true;
      this.tab2 = false;
      this.tab3 = false;
      console.log("tab1");
    },
    mvtab2() {
      this.tab1 = false;
      this.tab2 = true;
      this.tab3 = false;
      console.log("tab2");
    },
    mvtab3() {
      this.tab1 = false;
      this.tab2 = false;
      this.tab3 = true;
      console.log("tab3");
    },
    mvnews(originallink) {
      console.log("mvnews");
      window.open(originallink);
    },
    // onTabClick(event) {
    //   // deactivate existing active tabs and panel

    //   for (let i = 0; i < tab.length; i++) {
    //     tab[i].classList.remove("active");
    //   }

    //   for (let i = 0; i < panel.length; i++) {
    //     panel[i].classList.remove("active");
    //   }

    //   // activate new tabs and panel
    //   event.target.classList.add("active");
    //   let classString = event.target.getAttribute("data-target");
    //   console.log(classString);
    //   document
    //     .getElementById("panels")
    //     .getElementsByClassName(classString)[0]
    //     .classList.add("active");
    // },
  },
};

// for (let i = 0; i < tab.length; i++) {
//   tab[i].addEventListener("click", onTabClick, false);
// }
</script>

<style>
.tab-content {
  display: none;
}

.tab-content.active {
  display: block;
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
