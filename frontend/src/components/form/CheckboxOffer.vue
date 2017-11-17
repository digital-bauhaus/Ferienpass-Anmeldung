<template>
  <checkbox :params="params">
    <span class="offer" slot="checkboxLabel">
      <span class="offer__title">{{ params.label }}</span>
      <span class="offer__date">{{ params.date }}</span>
      <span class="offer__org">{{ params.org }}</span>
    </span>
  </checkbox>
</template>

<script>
import Checkbox from './Checkbox.vue';

export default {
  name: 'CheckboxOffer',
  props: ['params'],
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
}

.offer__title {
  font-weight: bold;
}
</style>
