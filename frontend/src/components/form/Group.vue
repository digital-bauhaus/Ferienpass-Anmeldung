<template>
  <div
    class="group"
    :role="params.role ?  params.role : 'group'"
    :aria-labelledby="`${toIdentifier(params.title)}-label`"
  >
    <h3 :class="`group__title ${params.hideTitle ? 'visually-hidden' : ''}`" :id="`${toIdentifier(params.title)}-label`">
      {{ params.title }}
    </h3>

    <p v-if="params.introduction">
      {{ params.introduction }}
    </p>

    <div :class="`group__body ${params.horizontal ? 'group__body--horizontal' : ''}`">
      <component
        v-for="(component, index) of params.components"
        :key="index" :is="component.name" :params="component.params"
      />
    </div>

    <p v-if="params.note">
      {{ params.note }}
    </p>
  </div>
</template>

<script>
export default {
  name: 'Group',
  props: ['params']
};
</script>

<style scoped>
.group__body--horizontal {
  display: flex;
  align-items: start;
}

.group__body--horizontal > *:not(:last-child) {
  margin-right: 0.75rem;
}

.group__title {
  margin-bottom: 0.75rem;
}
</style>

