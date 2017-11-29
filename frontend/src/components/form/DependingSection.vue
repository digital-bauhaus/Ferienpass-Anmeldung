<template>
  <div>
    <h3>
      {{ params.title }}
    </h3>

    <checkbox :params="params.checkbox.params" @change="updateChecked" />

    <template v-if="checked">
      <component
        v-for="(entry, index) of params.entries" :key="index"
        :is="entry.component"
        :params="entry.params"
      />
    </template>
  </div>
</template>

<script>
export default {
  name: 'DependingSection',
  props: ['params'],
  data() {
    return {
      checked: undefined
    };
  },
  methods: {
    updateChecked(checked) {
      this.checked = checked;
    }
  }
};
</script>
