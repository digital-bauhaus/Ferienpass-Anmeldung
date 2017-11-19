<template>
  <label class="text-field">
    <span :class="`text-field__label ${params.hideLabel ? 'visually-hidden' : ''}`">
      {{ params.label }}
    </span>

    <slot name="controlSlot">
      <input
        class="text-field__control"
        :type="params.type ? params.type : 'text'"
        :value="value"
        v-on:input="onInput"
        v-on:keydown="onKeydown"

        :name="toIdentifier(params.label)"
        :placeholder="params.placeholder ? params.placeholder : ''"
        :required="params.required"
      >
    </slot>
  </label>
</template>

<script>
export default {
  name: 'TextField',
  props: ['params', 'value'],
  methods: {
    onInput(event) {
      this.$emit('input', event.target.value);
    },
    onKeydown(event) {
      this.$emit('keydown', event);
    }
  }
};
</script>

<style scoped>
.text-field {
  display: block;
  margin-bottom: 0.75rem;
}

.text-field__control {
  display: block;
  width: 100%;
  padding: 4px 8px;
  border: 2px solid;
  border-radius: 8px;
}

.text-field__control:focus {
  outline: none;
  /* box-shadow: 0 0 0 2px #fff, 0 0 0 4px cornflowerblue; */
  box-shadow: 0 0 0 2px cornflowerblue;
}
</style>
