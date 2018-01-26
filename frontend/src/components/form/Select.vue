<template>
  <label
     :class="`select ${params.required ? 'required' : ''}`"
  >
    <span :class="`select__label ${params.hideLabel ? 'visually-hidden' : ''}`">
      {{ params.label }}
    </span>


    <select
      class="select__control"
      :name="params.name"
      :required="params.required"
    >
      <option
        v-for="(option, index) of params.options" :key="index"
        :selected="index === 0"
        :disabled="index === 0"
        :value="option.value"
      >
        {{ option.label }}
      </option>
    </select>

    <span class="select__open-indicator"></span>

  </label>
</template>

<script>
export default {
  name: 'Select',
  props: ['params']
};
</script>

<style scoped>
.select {
  position: relative;
}

.required .select__label::after {
  content: '*';
  color: #444;
}

.select__control {
  display: block;
  width: 100%;
  padding: 4px 8px;
  border: 2px solid;
  border-radius: 8px;
}

.select__control:not(:disabled) {
  background-color: #fff;
}

.select__control:focus {
  outline: none;
  box-shadow: 0 0 0 2px cornflowerblue;
}

.select__control:disabled + .select__open-indicator {
  color: #888;
}

.select__open-indicator::after {
  content: '\25BC';
  pointer-events: none;
  position: absolute;
  bottom: 0;
  right: 0;
  padding: 5px 12px 5px 8px;
  border-left: 2px solid;
}
</style>
