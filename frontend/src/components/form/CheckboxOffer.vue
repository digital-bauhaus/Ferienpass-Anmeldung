<template>
  <checkbox :entry="entry" :toIdentifier="toIdentifier">
    <span class="offer" slot="checkboxLabel">
      <span class="offer__title">{{ entry.title }}</span>
      <span class="offer__date">{{ entry.date }}</span>
      <span class="offer__org">{{ entry.org }}</span>
    </span>
  </checkbox>
</template>

<script>
import Checkbox from './Checkbox.vue';

export default {
  name: 'CheckboxOffer',
  props: ['entry', 'toIdentifier'],
  components: {
    Checkbox
  }
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
