<template>
  <div class="container mx-auto mt-10 sm:mt-20">
    <!-- Notice header -->
    <NoticeSingleHeader :singleNoticeHeader="singleNoticeHeader" />
    <!-- <NoticeSingleHeader></NoticeSingleHeader> -->

    <!-- Notice gallery -->
    <NoticeSingleGallery :noticeImages="noticeImages" />

    <!-- Notice information -->
    <NoticeSingleInfo :noticeInfo="noticeInfo" />
    <!-- <NoticeSingleInfo></NoticeSingleInfo> -->

    <!-- Project related projects -->
    <!-- <NoticeSingleRelatedNotices :relatedNotice="relatedNotice" /> -->
  </div>
</template>

<script>
import feather from "feather-icons";
import NoticeSingleHeader from "@/components/notice/NoticeSingleHeader.vue";
import NoticeSingleGallery from "@/components/notice/NoticeSingleGallery.vue";
import NoticeSingleInfo from "@/components/notice/NoticeSingleInfo.vue";
// import NoticeSingleRelatedNotices from "@/components/notice/NoticeSingleRelatedNotices.vue";
import { mapActions, mapState } from "vuex";

const noticeStore = "noticeStore";

export default {
  name: "Single Notice",
  components: {
    NoticeSingleHeader,
    NoticeSingleGallery,
    NoticeSingleInfo,
    // NoticeSingleRelatedNotices,
  },
  data: () => {
    return {
      singleNoticeHeader: {
        singleNoticeTitle: "",
        singleNoticeDate: "",
        singleNoticeCategory: "",
      },
      noticeImages: [
        // {
        //   id: 1,
        //   title: "Kabul Project Management UI",
        //   img: require("@/assets/images/ui-project-1.jpg"),
        // },
        // {
        //   id: 2,
        //   title: "Kabul Project Management UI",
        //   img: require("@/assets/images/web-project-2.jpg"),
        // },
        // {
        //   id: 3,
        //   title: "Kabul Project Management UI",
        //   img: require("@/assets/images/mobile-project-2.jpg"),
        // },
      ],
      noticeInfo: {
        // clientHeading: "About Client",
        // companyInfos: [
        //   {
        //     id: 1,
        //     title: "Name",
        //     details: "Company Ltd",
        //   },
        //   {
        //     id: 2,
        //     title: "Services",
        //     details: "UI Design & Frontend Development",
        //   },
        //   {
        //     id: 3,
        //     title: "Website",
        //     details: "https://company.com",
        //   },
        //   {
        //     id: 4,
        //     title: "Phone",
        //     details: "555 8888 888",
        //   },
        // ],
        // objectivesHeading: "Objective",
        // objectivesDetails:
        //   "Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio, natus! Quibusdam enim quod in esse, mollitia molestias incidunt quas ipsa accusamus veniam, quis odit cumque vero voluptate, reiciendis amet non!",
        // technlogies: [
        //   {
        //     title: "Tools & Technologies",
        //     techs: [
        //       "HTML",
        //       "CSS",
        //       "JavaScript",
        //       "Vue.js",
        //       "TailwindCSS",
        //       "AdobeXD",
        //     ],
        //   },
        // ],
        noticeDetailsHeading: "공지 내용",
        noticeDetails: "",
        //   {
        //     id: 1,
        //     details:
        //       "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nihil vel illum asperiores dignissimos cumque quibusdam et fugiat voluptatem nobis suscipit explicabo, eaque consequatur nesciunt, fugit eligendi corporis laudantium adipisci soluta? Lorem ipsum, dolor sit amet consectetur adipisicing elit. Incidunt totam dolorum, ducimus obcaecati, voluptas facilis molestias nobis ut quam natus similique inventore excepturi optio ipsa deleniti fugit illo. Unde, amet! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum illo necessitatibus perspiciatis! Aperiam perferendis labore temporibus, eos culpa corporis recusandae quas, fuga voluptatibus nesciunt odit libero tenetur neque consequatur ea.",
        //   },
        //   {
        //     id: 2,
        //     details:
        //       "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nihil vel illum asperiores dignissimos cumque quibusdam et fugiat voluptatem nobis suscipit explicabo, eaque consequatur nesciunt, fugit eligendi corporis laudantium adipisci soluta?",
        //   },
        //   {
        //     id: 3,
        //     details:
        //       "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nihil vel illum asperiores dignissimos cumque quibusdam et fugiat voluptatem nobis suscipit explicabo, eaque consequatur nesciunt, fugit eligendi corporis laudantium adipisci soluta?",
        //   },
        //   {
        //     id: 4,
        //     details:
        //       "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nihil vel illum asperiores dignissimos cumque quibusdam et fugiat voluptatem nobis suscipit explicabo, eaque consequatur nesciunt, fugit eligendi corporis laudantium adipisci soluta? Lorem ipsum, dolor sit amet consectetur adipisicing elit. Incidunt totam dolorum, ducimus obcaecati, voluptas facilis molestias nobis ut quam natus similique inventore excepturi optio ipsa deleniti fugit illo. Unde, amet! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum illo necessitatibus perspiciatis! Aperiam perferendis labore temporibus, eos culpa corporis recusandae quas, fuga voluptatibus nesciunt odit libero tenetur neque consequatur ea.",
        //   },
        // ],
        socialSharingsHeading: "Share This",
        socialSharings: [
          {
            id: 1,
            name: "Twitter",
            icon: "twitter",
            url: "https://twitter.com/NangialaiStoman",
          },
          {
            id: 2,
            name: "Instagram",
            icon: "instagram",
            url: "https://instagram.com/NangialaiStoman",
          },
          {
            id: 3,
            name: "Facebook",
            icon: "facebook",
            url: "https://facebook.com/",
          },
          {
            id: 4,
            name: "LinkedIn",
            icon: "linkedin",
            url: "https://linkedin.com/",
          },
          {
            id: 5,
            name: "Youtube",
            icon: "youtube",
            url: "https://www.youtube.com/c/StomanStudio",
          },
          {
            id: 5,
            name: "Dribbble",
            icon: "dribbble",
            url: "https://www.dribbble.com/",
          },
        ],
      },
      // relatedNotice: {
      //   relatedNoticesHeading: "Related Notices",
      //   relatedNotices: [
      //     {
      //       id: 1,
      //       title: "Mobile UI",
      //       img: require("@/assets/images/mobile-project-1.jpg"),
      //     },
      //     {
      //       id: 2,
      //       title: "Web Application",
      //       img: require("@/assets/images/web-project-1.jpg"),
      //     },
      //     {
      //       id: 3,
      //       title: "UI Design",
      //       img: require("@/assets/images/ui-project-2.jpg"),
      //     },
      //     {
      //       id: 4,
      //       title: "Kabul Mobile App UI",
      //       img: require("@/assets/images/mobile-project-2.jpg"),
      //     },
      //   ],
      // },
    };
  },
  async created() {
    console.log("여기오니 1 " + this.$route.params.idx);
    await this.getNotice(this.$route.params.idx);

    this.singleNoticeHeader.singleNoticeTitle = this.currentNotice.title;
    this.singleNoticeHeader.singleNoticeDate = this.currentNotice.regitime;
    this.singleNoticeHeader.singleNoticeCategory = this.currentNotice.category;

    console.log("여기오니 2 " + this.singleNoticeHeader.singleNoticeTitle);
    this.noticeImages.push({
      id: 1,
      title: `housegrid.jpg`,
      img: this.$route.params.img,
    });
    // for (let i = 1; i <= 3; i++) {
    //   var rand = Math.floor(Math.random() * 18) + 1;
    //   var noticeImage = {
    //     id: i,
    //     title: `housegrid${rand}.jpg`,
    //     img: require(`@/assets/images/housegrid${rand}.jpg`),
    //   };
    //   this.noticeImages.push(noticeImage);
    // }
    console.log("여기오니 3 ");
    this.noticeInfo.noticeDetails = this.currentNotice.content;
    console.log("여기오니 4 " + this.noticeInfo.noticeDetails);
  },
  mounted() {
    feather.replace();
  },
  updated() {
    feather.replace();
  },
  computed: {
    ...mapState(noticeStore, ["currentNotice"]),
  },
  methods: {
    ...mapActions(noticeStore, ["getNotice"]),
  },
};
</script>

<style scoped></style>
