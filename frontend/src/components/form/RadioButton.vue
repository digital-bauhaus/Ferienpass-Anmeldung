<template>
  <label class="radio-button">
    <input class="radio-button__control visually-hidden" type="radio" :name="toIdentifier(params.name)" required>

    <span class="radio-button__tick"></span>

    <span class="radio-button__label">
      {{ params.label }}
    </span>
  </label>
</template>

<script>
export default {
  name: 'RadioButton',
  props: ['params']
};
</script>

<style scoped>
.radio-button {
  display: inline-flex;
  align-items: center;
}

.radio-button__label {
  padding-right: 8px;
  padding-left: 8px;
}

.radio-button__tick {
  flex-shrink: 0;
  position: relative;
  width: 1.5rem;
  height: 1.5rem;
  margin: 4px;
  background-color: #fff;
  border-radius: 50%;
  border: 2px solid #000;
}

.radio-button__control:focus ~ .radio-button__tick {
  box-shadow: 0 0 0 2px #fff, 0 0 0 4px cornflowerblue;
}

.radio-button__control:checked ~ .radio-button__tick::before {
  content: '';
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  position: absolute;
  border-radius: 50%;
  border: 4px solid #fff;
  background-color: #000;
}
</style>
