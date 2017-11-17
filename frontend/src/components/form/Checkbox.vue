<template>
  <label class="checkbox">
    <input
      class="checkbox__control visually-hidden"
      type="checkbox"
      :name="toIdentifier(checkbox.label)"
      :required="checkbox.required"
    >

    <span class="checkbox__tick"></span>

    <span class="checkbox__label">
      <slot name="checkboxLabel">
        {{ checkbox.label }}
      </slot>
    </span>
  </label>
</template>

<script>
export default {
  name: 'Checkbox',
  props: ['checkbox', 'toIdentifier']
};
</script>

<style scoped>
.checkbox {
  display: flex;
  align-items: center;
}

.checkbox__label {
  margin-left: 0.5rem;
}

.checkbox__tick {
  flex-shrink: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 1.5rem;
  height: 1.5rem;
  margin: 0.25rem;
  background-color: #fff;
  border-radius: 0.5rem;
  border: 0.125rem solid;
}

.checkbox__control:checked ~ .checkbox__tick {
  color: #fff;
  border: 0;
  background-color: cornflowerblue;
}

.checkbox__control:focus ~ .checkbox__tick {
  box-shadow: 0 0 0 0.125rem #fff, 0 0 0 0.25rem cornflowerblue;
}

.checkbox__control:checked ~ .checkbox__tick::before {
  content: '\2713';
}
</style>

