<template>
  <form
    v-if="formDataLoaded"
    @keydown.enter="preventAccidentalSubmit"
    @submit="delegatePost"
    class="form"
    action="/api/register"
    method="post"
  >
    <h1>{{ formData.title }}</h1>

    <section
      v-for="(section, index) of formData.sections" :key="index"
      class="form-section"
      :aria-labelledby="`${toIdentifier(section.title)}`"
    >
      <h2 class="form-section__title" :id="`${toIdentifier(section.title)}`">
        {{ section.title }}
      </h2>

      <component
        v-for="(component, index) of section.components" :key="index"
        :is="component.name"
        :params="component.params"
      />
    </section>

    <input class="button button--wide" type="submit" name="Submit" value="Absenden">
  </form>
</template>

<script>
import { AXIOS } from './http-common';

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
          this.formData = json;
          this.formDataLoaded = true;
        });
    },
    preventAccidentalSubmit(event) {
      if (['textarea', 'submit'].includes(event.target.type)) {
        return;
      }

      event.preventDefault();
    },
    delegatePost(event) {
      event.preventDefault();

      const form = event.target;
      let jsonObject = {};
      Array.prototype.slice.call(form.elements).forEach(element => {
        if (element.name && element.type !== 'submit') {
          jsonObject[element.name] = element.type === 'checkbox' ? element.checked : element.value;
        }
      });

      AXIOS.post('/api/register', jsonObject)
        .then(response => {
          console.log(response);
        })
        .catch(error => {
          console.error(error);
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
