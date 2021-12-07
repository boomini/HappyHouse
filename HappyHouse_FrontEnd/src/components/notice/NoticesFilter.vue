<template>
  <div>
    <select
      @change="$emit('change', $event.target.value)"
      :name="select"
      :id="select"
      class="
        px-4
        sm:px-6
        py-2
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
      <option value class="text-sm sm:text-md">전체</option>
      <option
        v-for="option in selectOptions"
        :key="option"
        :value="option"
        class="text-normal sm:text-md"
      >
        {{ option }}
      </option>
    </select>
  </div>
</template>

<script>
export default {
  props: {
    select: {
      type: String,
      default: "notices",
    },
    selectOptions: {
      type: Array,
      default: () => ["해피 이야기", "부동산 상식", "생활 꿀팁"],
    },
  },
};
</script>

<style lang="scss" scoped></style>
