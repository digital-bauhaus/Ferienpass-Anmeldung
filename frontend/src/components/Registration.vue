<template>
  <form
    v-if="formData"
    @keydown.enter="preventAccidentalSubmit"
    @submit="delegatePost"
    class="form"
    action="/api/register"
    method="post"
  >
    <h1>{{ formData.title }}</h1>

    <checkbox
      class="school-child-checkbox"
      :params="{ 'label': 'Mein Kind geht zur Schule' }"
      @change="onSchoolChildChange"
    />

    <section
      v-for="(section, index) of formData.sections" :key="index"
      :class="`form-section ${section.expandOnStart ? 'open' : ''}`"
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

      <div class="form-section__body">
        <component
          v-for="(component, index) of section.components" :key="index"
          :is="component.componentName"
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
      formData: null
    };
  },
  created() {
    this.fetchData();
  },
  updated() {
    this.$nextTick(function() {
      if (this.formData) {
        const checkbox = document.querySelector('.school-child-checkbox > input');
        const formElements = this.getFormElements();
        this.disableFormElements(formElements, [checkbox]);
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

      console.log(jsonObject);

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
      console.log(exceptions);
      formElements.forEach(element => {
        if (!exceptions.includes(element) && element.type !== 'submit' && !element.disabled) {
          element.setAttribute('data-newly-disabled', null);
          element.setAttribute('disabled', null);
        }
      });
    },
    toggleSectionVisibility(event) {
      const section = event.currentTarget.parentElement;
      section.classList.toggle('open');
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

.form-section:not(.open) .form-section__body {
  position: absolute !important;
  clip: rect(1px, 1px, 1px, 1px);
  padding: 0 !important;
  border: 0 !important;
  height: 1px !important;
  width: 1px !important;
  overflow: hidden;
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
