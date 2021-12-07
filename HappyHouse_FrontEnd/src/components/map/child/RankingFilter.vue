<template>
  <div>
    <select
      @change="changeranking($event)"
      :name="select"
      :id="select"
      class="
        border-1 border-gray-200
        dark:border-secondary-dark
        rounded-lg
        text-sm
        sm:text-md
        dark:font-medium
        bg-secondary-light
        dark:bg-ternary-dark
        text-primary-dark
        dark:text-ternary-light
    "
    >
      <option value class="text-sm">별점</option>
      <option
        v-for="option in selectOptions"
        :key="option"
        :value="option"
        class="text-normal"
      >
        {{ option }}
      </option>
    </select>
  </div>
</template>

<script>
import { mapMutations } from "vuex";

export default {
  props: {
    select: {
      type: String,
      default: "notices",
    },
    selectOptions: {
      type: Array,
      default: () => ["1", "2", "3", "4", "5"],
    },
  },
  methods: {
    ...mapMutations(["SET_REVIEW_RANKING"]),
    changeranking(event) {
      this.SET_REVIEW_RANKING({ ranking: event.target.value });
    },
  },
};
</script>

<style lang="scss" scoped></style>
