<template>
  <router-link
    :to="{
      name: 'Single Notice',
      params: { idx: notice.idx, img: thumbnail.img },
    }"
    class="rounded-3xl shadow-lg hover:shadow-xl cursor-pointer mb-10 sm:mb-0 bg-secondary-light dark:bg-ternary-dark"
    aria-label="Single Notice"
  >
    <div>
      <img
        :src="thumbnail.img"
        :alt="notice.title"
        class="rounded-t-3xl border-none"
      />
    </div>
    <div class="text-center px-4 py-6">
      <p
        class="text-2xl text-ternary-dark dark:text-ternary-light font-semibold mb-2"
      >
        {{ notice.title }}
      </p>
      <span class="text-lg text-ternary-dark dark:text-ternary-light">{{
        notice.category
      }}</span>
    </div>
  </router-link>
</template>

<script>
export default {
  props: ["notice", "thumbnail"],
};
</script>

<style lang="scss" scoped></style>
