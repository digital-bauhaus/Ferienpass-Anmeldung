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
      {{ entry.title }}
    </span>
  </label>
</template>

<script>
export default {
  name: 'Checkbox',
  props: ['entry', 'toIdentifier']
};
</script>
