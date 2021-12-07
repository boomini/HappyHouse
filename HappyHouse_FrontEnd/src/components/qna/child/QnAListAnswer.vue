<template>
  <tr @click="mvQnaRead">
    <td class="p-2">
      <div class="">{{ idx }}</div>
    </td>
    <td class="font-bold">
      <svg
        class="h-4 w-4 text-white"
        width="24"
        height="24"
        viewBox="0 0 24 24"
        stroke-width="2"
        stroke="currentColor"
        fill="none"
        stroke-linecap="round"
        stroke-linejoin="round"
      >
        <path stroke="none" d="M0 0h24v24H0z" />
        <path d="M15 11l4 4l-4 4m4 -4h-11a4 4 0 0 1 0 -8h1" />
      </svg>
      Re: {{ title }}
    </td>
    <td>
      {{ iduser }}
    </td>
    <td>
      {{ regtime }}
    </td>
  </tr>
</template>

<script>
import { mapMutations } from "vuex";
export default {
  props: {
    idx: String,
    iduser: String,
    title: String,
    content: String,
    regtime: String,
    gidx: String,
  },
  methods: {
    ...mapMutations(["SET_TYPE_MODE"]),

    mvQnaRead() {
      console.log(this.idx);
      // this.SET_INDEX({ index: this.gidx });
      // this.$router.push({ name: "QnARead" });
      this.SET_TYPE_MODE({ type: "A", mode: "R" });
      this.$router.push({
        name: "QnARead",
        params: { idx: this.idx, gidx: this.gidx },
      });
    },
  },
};
</script>

<style></style>
