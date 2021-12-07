<template>
  <tr class="whitespace-nowrap">
    <td class="px-5 py-4 text-sm text-gray-500">
      {{ dealYear }}.{{ dealMonth }}.{{ dealDay }}
    </td>
    <td class="px-3 py-4">
      <div class="text-sm text-gray-900">{{ dealAmount }}만원</div>
    </td>
    <td class="px-5 py-4">
      <div class="text-sm text-gray-500">
        {{ area }}
      </div>
    </td>
    <td class="px-5 py-4 text-sm text-gray-500">{{ floor }}층</td>
  </tr>
</template>

<script>
export default {
  props: {
    dealAmount: String,
    dealYear: String,
    dealMonth: String,
    dealDay: String,
    area: String,
    floor: String,
  },
};
</script>

<style></style>
