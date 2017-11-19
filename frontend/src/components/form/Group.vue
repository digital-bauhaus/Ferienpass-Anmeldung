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

    <component v-for="(entry, index) of params.entries" :key="index" :is="entry.component" :params="entry.params"/>

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
.group__title {
  margin-bottom: 0.75rem;
}
</style>

