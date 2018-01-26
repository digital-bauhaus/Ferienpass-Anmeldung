<template>
  <label
     :class="`select ${params.required ? 'required' : ''}`"
  >
    <span :class="`select__label ${params.hideLabel ? 'visually-hidden' : ''}`">
      {{ params.label }}
    </span>


    <select
      class="select__control"
      :name="toIdentifier(params.label)"
      :required="params.required"
    >
      <option v-for="(option, index) of params.options" :key="index" :value="option">
        {{ option }}
      </option>
    </select>
  </label>
</template>

<script>
export default {
  name: 'Select',
  props: ['params']
};
</script>

<style scoped>
.required .select__label::after {
  content: '*';
  color: #444;
}

.select__control {
  display: block;
  background-color: #fff;
  padding: 4px 8px;
  border: 2px solid;
  border-radius: 8px;
}
</style>
