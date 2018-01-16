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
      class="form-section"
      v-for="(section, index) of formData.sections" :key="index"
      :aria-labelledby="`${toIdentifier(section.title)}`"
    >
      <h2
        class="form-section__title"
        :id="`${toIdentifier(section.title)}`"
        @click="toggleSectionVisibility"
      >
        {{ section.title }}

        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-labelledby="triangle-right-title" class="triangle">
          <title id="triangle-right-title">Öffnet oder schließt den aktuellen Abschnitt</title>
          <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
        </svg>
      </h2>

      <div class="form-section__body  visually-hidden">
        <component
          v-for="(component, index) of section.components" :key="index"
          :is="component.name"
          :params="component.params"
        />
      </div>
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
        .then(response => response.json())
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
    },
    toggleSectionVisibility(event) {
      const section = event.currentTarget.parentElement;
      const sectionBody = section.querySelector('.form-section__body');

      section.classList.toggle('open');
      sectionBody.classList.toggle('visually-hidden');
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

.form-section__title::before {
  /* Display each .form-section’s counter value */
  content: counter(form-section) '.' '\A0';
}

.form-item:not(:last-child) {
  margin-bottom: 0.75rem;
}

.triangle {
  margin-left: 0.25rem;
  transform-origin: 6px 9px;
  transition: transform 0.1s;
}

.form-section.open .triangle {
  transform: rotate(90deg);
  transition: transform 0.25s;
}
</style>
