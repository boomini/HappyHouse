<template>
  <!-- Projects start -->
  <section class="pt-20 sm:pt-28">
    <!-- Projects grid title start -->
    <div class="text-center">
      <p
        class="text-2xl sm:text-5xl font-semibold mb-3 text-ternary-dark dark:text-ternary-light"
      >
        {{ noticesHeading }}
      </p>
      <p class="text-md sm:text-xl text-gray-500 dark:text-ternary-light">
        {{ noticesDescription }}
      </p>
    </div>
    <!-- Projects grid title end -->

    <!-- Filter and search projects start -->
    <div class="mt-10 sm:mt-16">
      <!-- <h3
        class="
          text-center text-secondary-dark
          dark:text-ternary-light
          text-md
          sm:text-xl
          font-normal
          mb-3
        "
      >
        Search notices by title or filter by category
      </h3> -->
      <div
        class="
          flex
          justify-between
          border-b border-primary-light
          dark:border-secondary-dark
          pb-3
          gap-3
        "
      >
        <div class="flex justify-between gap-2">
          <span
            class="
              hidden
              sm:block
              bg-primary-light
              dark:bg-ternary-dark
              p-2.5
              shadow-sm
              rounded-xl
              cursor-pointer
            "
          >
            <i
              data-feather="search"
              class="text-ternary-dark dark:text-ternary-light"
            ></i>
          </span>
          <input
            v-model="searchNotice"
            class="
              pl-3
              pr-1
              sm:px-4
              py-2
              border-1 border-gray-200
              dark:border-secondary-dark
              rounded-lg
              text-sm
              sm:text-md
              bg-secondary-light
              dark:bg-ternary-dark
              text-primary-dark
              dark:text-ternary-light
            "
            id="name"
            name="name"
            type="search"
            required=""
            placeholder="제목으로 검색하세요"
            aria-label="Name"
          />
        </div>
        <NoticesFilter @change="selectedNotice = $event" />
      </div>
    </div>
    <!-- Filter and search projects end -->

    <!-- Projects grid start -->
    <div class="grid grid-cols-1 sm:grid-cols-3 mt-6 sm:gap-10">
      <NoticeSingle
        v-for="(notice, index) in filteredNotices"
        :key="notice.idx"
        :notice="notice"
        :thumbnail="thumbnails[index]"
      />
    </div>
    <!-- Projects grid end -->
  </section>
  <!-- Projects end -->
</template>

<script>
import feather from "feather-icons";
import NoticesFilter from "./NoticesFilter.vue";
import NoticeSingle from "./NoticeSingle.vue";
import { mapActions, mapMutations, mapState } from "vuex";

const noticeStore = "noticeStore";

export default {
  name: "NoticesGrid",
  components: { NoticeSingle, NoticesFilter },
  data: () => {
    return {
      noticesHeading: "공지사항",
      noticesDescription: "해피하우스가 알려주는 부동산 가이드",
      selectedNotice: "",
      searchNotice: "",
      notices: [
        // {
        //   id: 1,
        //   title: "해피하우스 허위매물 예방 5계명",
        //   category: "해피 이야기",
        //   img: require("@/assets/images/housegrid2.jpg"),
        // },
        // {
        //   id: 2,
        //   title: "알아두면 좋은 부동산 용어",
        //   category: "부동산 상식",
        //   img: require("@/assets/images/housegrid4.jpg"),
        // },
        // {
        //   id: 3,
        //   title: "방 구하기 전 꼭 확인하자! 매물 체크 리스트",
        //   category: "생활 꿀팁",
        //   img: require("@/assets/images/housegrid2.jpg"),
        // },
        // {
        //   id: 4,
        //   title: "이사 준비한다면 필독! 이사 체크 리스트",
        //   category: "생활 꿀팁",
        //   img: require("@/assets/images/housegrid4.jpg"),
        // },
        // {
        //   id: 5,
        //   title: "해피하우스로 나에게 꼭 맞는 방 찾는 방법",
        //   category: "해피 이야기",
        //   img: require("@/assets/images/housegrid2.jpg"),
        // },
        // {
        //   id: 6,
        //   title: "임대차 계약서 작성 시 이것만 알아두세요~",
        //   category: "부동산 상식",
        //   img: require("@/assets/images/housegrid4.jpg"),
        // },
      ],
      thumbnails: [],
      // publicPath: process.env.BASE_URL,
    };
  },
  async created() {
    await this.setNoticeList();
    this.notices = this.noticeList;
    for (let i = 0; i < this.notices.length; i++) {
      var rand = Math.floor(Math.random() * 18) + 1;
      console.log(rand + "!");
      this.thumbnails.push({
        img: require(`@/assets/images/housegrid${rand}.jpg`),
      });
    }
  },
  computed: {
    ...mapState(noticeStore, ["noticeList"]),

    filteredNotices() {
      if (this.selectedNotice) {
        return this.filterNoticesByCategory();
      } else if (this.searchNotice) {
        return this.filterNoticesBySearch();
      }
      return this.notices;
    },
  },
  methods: {
    ...mapActions(noticeStore, ["setNoticeList"]),
    ...mapMutations(noticeStore, ["SET_NOTICE_LIST"]),

    filterNoticesByCategory() {
      // return this.notices.filter((item) => {
      //   let category =
      //     item.category.charAt(0).toUpperCase() + item.category.slice(1);
      //   return category.includes(this.selectedNotice);
      // });
    },
    filterNoticesBySearch() {
      let notice = new RegExp(this.searchNotice, "i");
      return this.notices.filter((el) => el.title.match(notice));
    },
  },
  mounted() {
    feather.replace();
  },
};
</script>

<style scoped></style>
