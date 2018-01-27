<template>
  <form
    v-if="formData"
    @keydown.enter="preventAccidentalSubmit"
    @submit="delegatePost"
    class="form"
    action="/api/register"
    method="post"
    :data-age="age ? age : ''"
    :data-zip-code="zipCode ? zipCode : ''"
  >
    <h1>{{ formData.title }}</h1>

    <checkbox
      class="school-child-checkbox"
      :params="{ 'label': 'Mein Kind geht zur Schule' }"
      @change="onSchoolChildChange"
    />

    <section
      v-for="(section, index) of formData.sections" :key="index"
      class="form-section"
      :aria-labelledby="`${toIdentifier(section.title)}`"
    >
      <h2
        class="form-section__title"
        :id="`${toIdentifier(section.title)}`"
      >
        <button
          type="button"
          :aria-expanded="section.expandOnStart"
          @click="toggleSectionExpanded"
        >
          {{ section.title }}

          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-hidden="true" focusable="false" class="triangle">
            <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
          </svg>
        </button>
      </h2>

      <div :hidden="!section.expandOnStart">
        <component
          v-for="(component, index) of section.components" :key="index"
          :is="component.component"
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
      formData: null,
      initiallyDisabled: false,
      'base__birthdate-day': null,
      'base__birthdate-month': null,
      'base__birthdate-year': null,
      'base__zip-code': null
    };
  },
  computed: {
    age() {
      if (
        this['base__birthdate-day'] &&
        this['base__birthdate-month'] &&
        this['base__birthdate-year']
      ) {
        const day = parseInt(this['base__birthdate-day']);
        const month = parseInt(this['base__birthdate-month']);
        const year = parseInt(this['base__birthdate-year']);

        if ([day, month, year].every(el => typeof el === 'number' && el % 1 === 0)) {
          const birthdate = new Date(year, month - 1, day);
          const today = new Date();

          let age = today.getFullYear() - birthdate.getFullYear();
          const m = today.getMonth() - birthdate.getMonth();
          if (m < 0 || (m === 0 && today.getDate() < birthdate.getDate())) {
            age--;
          }

          this.disableUnavailableProjects(age);
          return age;
        }
      }

      return null;
    },
    zipCode() {
      if (this['base__zip-code']) {
        const value = parseInt(this['base__zip-code']);
        if (typeof value === 'number' && value % 1 === 0) {
          return value;
        }
      }

      return null;
    }
  },
  created() {
    this.fetchData();
  },
  updated() {
    this.$nextTick(function() {
      if (this.formData && !this.initiallyDisabled) {
        const checkbox = document.querySelector('.school-child-checkbox > input');
        const formElements = this.getFormElements();
        this.disableFormElements(formElements, [checkbox]);
        this.initiallyDisabled = true;
      }
    });
  },
  methods: {
    fetchData() {
      fetch('/static/form-data.json')
        .then(response => response.json())
        .then(json => {
          this.formData = json;
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
    getFormElements() {
      const form = document.querySelector('.form');

      if (form) {
        return Array.prototype.slice.call(form.elements);
      }

      return null;
    },
    onSchoolChildChange(event) {
      const formElements = this.getFormElements();

      if (event.currentTarget.checked) {
        this.enableFormElements(formElements);
      } else {
        this.disableFormElements(formElements, [event.currentTarget]);
      }
    },
    enableFormElements(formElements) {
      formElements.forEach(element => {
        if (element.type !== 'submit' && element.hasAttribute('data-newly-disabled')) {
          element.removeAttribute('data-newly-disabled');
          element.removeAttribute('disabled');
        }
      });
    },
    disableFormElements(formElements, exceptions = []) {
      formElements.forEach(element => {
        if (!exceptions.includes(element) && element.type !== 'submit' && !element.disabled) {
          element.setAttribute('data-newly-disabled', null);
          element.setAttribute('disabled', null);
        }
      });
    },
    toggleSectionExpanded(event) {
      const button = event.currentTarget;
      const expanded = button.getAttribute('aria-expanded') === 'true' || false;
      button.setAttribute('aria-expanded', !expanded);

      const heading = button.parentElement;
      const targetSection = heading.nextElementSibling;
      targetSection.hidden = expanded;
    },
    disableUnavailableProjects(age) {
      const projectControls = Array.prototype.slice.call(
        document.querySelectorAll('[name^="projects__id-"]')
      );
      projectControls.forEach(projectControl => {
        projectControl.removeAttribute('disabled');
        const minimumAge = parseInt(projectControl.dataset.minimumAge);
        if (age < minimumAge) {
          projectControl.setAttribute('disabled', null);
        }
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

.form-section__title::before {
  /* Display each .form-section’s counter value */
  content: counter(form-section) '.' '\A0';
}

.form-section__title > button {
  all: inherit;
  margin-top: 0;
  margin-bottom: 0;
  display: inline-block;
}

.form-section__title > button:focus > .triangle {
  outline: 2px solid cornflowerblue;
}

.form-item:not(:last-child) {
  margin-bottom: 0.75rem;
}

.triangle {
  margin-left: 0.25rem;
  transform-origin: 6px 9px;
  transition: transform 0.1s;
}

[aria-expanded='true'] .triangle {
  transform: rotate(90deg);
  transition: transform 0.25s;
}

[aria-expanded] path {
  fill: currentColor;
}
</style>
