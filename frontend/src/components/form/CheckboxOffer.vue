<template>
  <label class="checkbox">
    <input
      class="checkbox__control visually-hidden"
      type="checkbox"
      :name="`offers-${toIdentifier(entry.title)}`"
      :required="entry.required"
    >
    <span class="checkbox__tick"></span>
    <span class="checkbox__label">
      <span class="offer">
        <span class="offer__title">{{ entry.title }}</span>
        <span class="offer__date">{{ entry.date }}</span>
        <span class="offer__org">{{ entry.org }}</span>
      </span>
    </span>
  </label>
</template>

<script>
export default {
  name: 'CheckboxOffer',
  props: ['entry', 'toIdentifier']
};
</script>

<style scoped>
.offer {
  display: flex;
  flex-direction: column;
}

.offer__date {
  order: -1;
  font-size: 0.75em;
  /* color: #666; */
}

.offer__title {
  font-weight: bold;
}
</style>
