<template>
  <label class="text-field">
    {{ entry.title }}

    <input
      class="text-field__control"
      :type="entry.type ? entry.type : 'text'"
      :name="`basics-${toIdentifier(entry.title)}`"
      :required="entry.required"
    >
  </label>
</template>

<script>
export default {
  name: 'TextField',
  props: ['entry', 'toIdentifier']
};
</script>

<style scoped>
.text-field__control {
  display: block;
  width: 100%;
  padding: 0.25rem 0.5rem;
  border: 0.125rem solid #aaa;
  border-radius: 0.5rem;
}

.text-field__control:focus {
  outline: none;
  box-shadow: 0 0 0 0.125rem #fff, 0 0 0 0.25rem cornflowerblue;
}
</style>
