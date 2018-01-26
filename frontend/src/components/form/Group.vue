<template>
  <div
    class="group"
    :role="params.role ?  params.role : 'group'"
    :aria-labelledby="`${toIdentifier(params.title)}-label`"
  >
    <h3 :class="`group__title ${params.hideTitle ? 'visually-hidden' : ''}`" :id="`${toIdentifier(params.title)}-label`">
      {{ params.title }}
    </h3>

    <div :class="`group__body ${params.horizontal ? 'group__body--horizontal' : ''}`">
      <component
        v-for="(component, index) of params.components" :key="index"
        :is="component.component"
        :params="component.params"
        @input="onInput"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: 'Group',
  props: ['params'],
  methods: {
    onInput(event) {
      if (this.params.emitBirthdate) {
        const value = parseInt(event.target.value);
        if (typeof value === 'number' && value % 1 === 0) {
          // Yeah, I know. :/
          const registrationData = this.$root.$children[0].$children[0].$data;
          registrationData[event.target.name] = value;

          // window[event.target.name] = value;
        }
      }
    }
  }
};
</script>

<style scoped>
.group__body--horizontal {
  display: flex;
  align-items: start;
}

.group__body--horizontal > * {
  flex: 1;
}

.group__body--horizontal > *:not(:last-child) {
  margin-right: 0.75rem;
}

.group__title {
  margin-bottom: 0.75rem;
}
</style>

