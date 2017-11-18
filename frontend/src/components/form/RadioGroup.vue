<template>
  <div class="radio-group" role="radiogroup" :aria-labelledby="toIdentifier(params.title)">
    <h3 class="radio-group__title" :id="toIdentifier(params.title)">
      {{ params.title }}
    </h3>

    <div class="form-item" v-for="(radioButton, index) of params.radioButtons" :key="index">
      <component :is="radioButton.component" :params="radioButton.params"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RadioGroup',
  props: ['params']
};
</script>
