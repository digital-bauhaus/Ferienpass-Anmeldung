<template>
  <form v-if="formDataLoaded" class="form" action="/api/register" method="post">
    <h1>{{ formData.title }}</h1>

    <section
      v-for="(section, index) of formData.sections" :key="index"
      class="form-section"
      :aria-labelledby="`${toIdentifier(section.title)}-label`"
    >
      <h2 class="form-section__title" :id="`${toIdentifier(section.title)}-label`">
        {{ section.title }}
      </h2>

      <component
        v-for="(entry, index) of section.entries" :key="index"
        :is="$options.components[entry.component]"
        :params="entry.params"
      />
    </section>
  </form>
</template>

<script>
export default {
  name: 'Registration',
  data() {
    return {
      formDataLoaded: false,
      formData: null
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetch('/static/form-data.json')
        .then(response => {
          return response.json();
        })
        .then(json => {
          this.formDataLoaded = true;
          this.formData = json;
        });
    }
  }
};
</script>

<style>
.form {
  /* Initialize the form section counter */
  counter-reset: form-section;
}

.form-section {
  /* Count each .form-section element */
  counter-increment: form-section;
}

.form-section:not(:last-child) {
  margin-bottom: 4.5rem;
}

.form-section__title::before {
  /* Display each .form-section’s counter value */
  content: counter(form-section) '.' '\A0';
}

.form-item:not(:last-child) {
  margin-bottom: 0.75rem;
}
</style>
