<template>
  <label class="text-field">
    {{ entry.title }}
    <input type="text" :name="`basics-${toIdentifier(entry.title)}`" :required="entry.required">
  </label>
</template>

<script>
export default {
  name: 'TextField',
  props: ['entry', 'toIdentifier']
};
</script>
