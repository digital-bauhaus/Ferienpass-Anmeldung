<template>
  <label class="checkbox">
    <input
      class="checkbox__control visually-hidden"
      type="checkbox"
      :name="toIdentifier(params.label)"
      :required="params.required"
    >

    <span class="checkbox__tick"></span>

    <span class="checkbox__label">
      <slot name="checkboxLabel">
        {{ params.label }}
      </slot>
    </span>
  </label>
</template>

<script>
export default {
  name: 'Checkbox',
  props: ['params']
};
</script>

<style scoped>
.checkbox {
  display: inline-flex;
  align-items: center;
}

.checkbox__label {
  padding-right: 8px;
  padding-left: 8px;
}

.checkbox__tick {
  flex-shrink: 0;
  position: relative;
  width: 1.5rem;
  height: 1.5rem;
  margin: 4px;
  background-color: #fff;
  border-radius: 8px;
  border: 2px solid #000;
}

.checkbox__control:focus ~ .checkbox__tick {
  box-shadow: 0 0 0 2px #fff, 0 0 0 4px cornflowerblue;
}

.checkbox__control:checked ~ .checkbox__tick::before {
  content: '\2713';
  width: 100%;
  height: 100%;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>

