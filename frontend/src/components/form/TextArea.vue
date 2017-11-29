<template>
  <label class="text-area">
    <span :class="`text-area__label ${params.hideLabel ? 'visually-hidden' : ''}`">
      {{ params.label }}
    </span>

    <textarea
      class="text-area__control"
      :name="toIdentifier(params.label)"
      cols="30"
      rows="10"
    ></textarea>
  </label>
</template>

<script>
export default {
  name: 'TextArea',
  props: ['params']
};
</script>

<style scoped>
.text-area {
  margin-bottom: 0.75rem;
}

.text-area__control {
  display: block;
  width: 100%;
  padding: 4px 8px;
  border: 2px solid;
}

.text-area__control:focus {
  outline: none;
  /* box-shadow: 0 0 0 2px #fff, 0 0 0 4px cornflowerblue; */
  box-shadow: 0 0 0 2px cornflowerblue;
}
</style>
