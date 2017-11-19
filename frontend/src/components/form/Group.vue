<template>
  <div
    class="group"
    :role="params.role ?  params.role : 'group'"
    :aria-labelledby="`${toIdentifier(params.title)}-label`"
  >
    <h3 class="group__title" :id="`${toIdentifier(params.title)}-label`">
      {{ params.title }}
    </h3>

    <div class="form-item" v-for="(entry, index) of params.entries" :key="index">
      <component :is="entry.component" :params="entry.params"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Group',
  props: ['params']
};
</script>
