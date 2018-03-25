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
    <h1>Ferienpass Weimar – Anmeldung</h1>

    <checkbox
      class="school-child-checkbox"
      :params="{ 'label': 'Mein Kind geht zur Schule' }"
      @change="onSchoolChildChange"
    />
    <!-- Grunddaten -->
    <section v-model="grunddaten" class="form-section" :aria-labelledby="`${toIdentifier(grunddaten.title)}`">
      <h2 class="form-section__title" :id="`${toIdentifier(grunddaten.title)}`">
        <button type="button" :aria-expanded="grunddaten.expandOnStart" @click="toggleSectionExpanded">
          Grunddaten
          <!-- Small triangle to switch section view -->
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-hidden="true" focusable="false" class="triangle">
            <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
          </svg>
        </button>
      </h2>

      <div :hidden="!grunddaten.expandOnStart">
        <component v-for="(component, index) of grunddaten.components" :key="index" :is="component.component" :params="component.params"/>
      </div>
    </section>

    <!-- Angebote -->
    <section v-model="angebote" class="form-section" :aria-labelledby="`${toIdentifier(angebote.title)}`">
      <h2 class="form-section__title" :id="`${toIdentifier(angebote.title)}`">
        <button type="button" :aria-expanded="angebote.expandOnStart" @click="toggleSectionExpanded">
          Angebote
          <!-- Small triangle to switch section view -->
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-hidden="true" focusable="false" class="triangle">
            <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
          </svg>
        </button>
      </h2>

      <div :hidden="!angebote.expandOnStart">

        <component
          :is="component_checkbox"
          :params="projekt_params"
        />

        <component
          v-for="(projektParams, index) of alleAnmeldungProjekte" :key="index"
          :is="component_checkbox"
          :params="projektParams"
        />

        <!--<component-->
          <!--v-for="(projekt, index) of angebote.components[1].params.components" :key="index"-->
          <!--:is="projekt.component"-->
          <!--:params="projekt.params"-->
        <!--/>-->

        <!--<component v-for="(component, index) of angebote.components" :key="index" :is="component.component" :params="component.params"/>-->
      </div>
    </section>

    <!-- Allergien, Krankheiten, … -->
    <section v-model="allergienkrankheiten" class="form-section" :aria-labelledby="`${toIdentifier(allergienkrankheiten.title)}`">
      <h2 class="form-section__title" :id="`${toIdentifier(allergienkrankheiten.title)}`">
        <button type="button" :aria-expanded="allergienkrankheiten.expandOnStart" @click="toggleSectionExpanded">
          Allergien, Krankheiten, …
          <!-- Small triangle to switch section view -->
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-hidden="true" focusable="false" class="triangle">
            <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
          </svg>
        </button>
      </h2>

      <div :hidden="!allergienkrankheiten.expandOnStart">
        <component v-for="(component, index) of allergienkrankheiten.components" :key="index" :is="component.component" :params="component.params"/>
      </div>
    </section>

    <!-- Angaben bei Behinderung -->
    <section v-model="behinderung" class="form-section" :aria-labelledby="`${toIdentifier(behinderung.title)}`">
      <h2 class="form-section__title" :id="`${toIdentifier(behinderung.title)}`">
        <button type="button" :aria-expanded="behinderung.expandOnStart" @click="toggleSectionExpanded">
          Angaben bei Behinderung
          <!-- Small triangle to switch section view -->
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-hidden="true" focusable="false" class="triangle">
            <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
          </svg>
        </button>
      </h2>

      <div :hidden="!behinderung.expandOnStart">
        <component v-for="(component, index) of behinderung.components" :key="index" :is="component.component" :params="component.params"/>
      </div>
    </section>

    <!-- Erklärung -->
    <section v-model="erklaerung" class="form-section" :aria-labelledby="`${toIdentifier(erklaerung.title)}`">
      <h2 class="form-section__title" :id="`${toIdentifier(erklaerung.title)}`">
        <button type="button" :aria-expanded="erklaerung.expandOnStart" @click="toggleSectionExpanded">
          Erklärung
          <!-- Small triangle to switch section view -->
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-hidden="true" focusable="false" class="triangle">
            <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
          </svg>
        </button>
      </h2>

      <div :hidden="!erklaerung.expandOnStart">
        <component v-for="(component, index) of erklaerung.components" :key="index" :is="component.component" :params="component.params"/>
      </div>
    </section>

    <!-- Datenschutzerklärung -->
    <section v-model="datenschutz" class="form-section" :aria-labelledby="`${toIdentifier(datenschutz.title)}`">
      <h2 class="form-section__title" :id="`${toIdentifier(datenschutz.title)}`">
        <button type="button" :aria-expanded="datenschutz.expandOnStart" @click="toggleSectionExpanded">
          Datenschutzerklärung
          <!-- Small triangle to switch section view -->
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" role="img" aria-hidden="true" focusable="false" class="triangle">
            <path d="m0,0l0,18 15.588,-9 Z" fill="#000"/>
          </svg>
        </button>
      </h2>

      <div :hidden="!datenschutz.expandOnStart">
        <component v-for="(component, index) of datenschutz.components" :key="index" :is="component.component" :params="component.params"/>
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
      'base__zip-code': null,
      grunddaten: null,
      angebote: null,
      allergienkrankheiten: null,
      behinderung: null,
      erklaerung: null,
      datenschutz: null,
      projekt_params: {
        label: 'Mein Fest',
        name: 'projects__id-65878',
        meta: {
          date: '26. Juni 2018',
          org: 'Sportjugend Weimar',
          minimumAge: 8
        }
      },
      component_checkbox: 'Checkbox',
      alleAdminProjekte: [],
      alleAnmeldungProjekte: []
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
    this.retrieveAllAdminProjects();
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
          this.grunddaten = this.formData.sections[0];
          this.angebote = this.formData.sections[1];
          this.allergienkrankheiten = this.formData.sections[2];
          this.behinderung = this.formData.sections[3];
          this.erklaerung = this.formData.sections[4];
          this.datenschutz = this.formData.sections[5];
        });
    },
    retrieveAllAdminProjects() {
      AXIOS.get('http://localhost:8088/api/allprojects')
        .then(response => {
          console.log('Retrieve projects from Admin-Microservice');
          console.log(response);
          this.alleAdminProjekte = response.data;
          this.mappeAdminProjekteAufAnmeldungProjekte();
        })
        .catch(error => {
          console.error(error);
        });
    },
    mappeAdminProjekteAufAnmeldungProjekte() {
      this.alleAdminProjekte.forEach(adminProjekt => {
        console.log(adminProjekt)
        var projektParam = {
          label: adminProjekt.name,
          name: adminProjekt.id,
          meta: {
            date: adminProjekt.datum,
            org: 'Sportjugend Weimar',
            minimumAge: adminProjekt.alterLimitierung
          }
        }
        this.alleAnmeldungProjekte.push(projektParam);
      });
      console.log('Map Admin projects to Anmeldung projects')
      console.log(this.alleAnmeldungProjekte)
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
      console.log(jsonObject)
      AXIOS.post('http://localhost:8088/api/register', jsonObject)
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
        if (element.hasAttribute('data-newly-disabled')) {
          element.removeAttribute('data-newly-disabled');
          element.removeAttribute('disabled');
        }
      });
    },
    disableFormElements(formElements, exceptions = []) {
      formElements.forEach(element => {
        if (!exceptions.includes(element) && element.type !== 'button' && !element.disabled) {
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
  content: counter(form-section) "." "\A0";
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

[aria-expanded="true"] .triangle {
  transform: rotate(90deg);
  transition: transform 0.25s;
}

[aria-expanded] path {
  fill: currentColor;
}
</style>
