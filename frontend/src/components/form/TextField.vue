<template>
  <label class="text-field">
    <span :class="`text-field__label ${textField.hideLabel ? 'visually-hidden' : ''}`">
      {{ textField.label }}
    </span>

    <slot name="textFieldControl">
      <input
        class="text-field__control"
        :type="textField.type ? textField.type : 'text'"
        :name="toIdentifier(textField.label)"
        :placeholder="textField.placeholder ? textField.placeholder : ''"
        :required="textField.required"
      >
    </slot>
  </label>
</template>

<script>
export default {
  name: 'TextField',
  props: ['textField', 'toIdentifier']
};
</script>

<style scoped>
.text-field__control {
  display: block;
  width: 100%;
  padding: 0.25rem 0.5rem;
  border: 0.125rem solid;
  border-radius: 0.5rem;
}

.text-field__control:focus {
  outline: none;
  box-shadow: 0 0 0 0.125rem #fff, 0 0 0 0.25rem cornflowerblue;
}
</style>
