<template>
  <form class="form" action="">
    <h1>Ferienpass Weimar – Anmeldung</h1>

    <section class="form-section">
      <h2 class="form-section__title">{{ base.title }}</h2>

      <label class="form-item" v-for="(entry, index) of base.entries" :key="index">
        <div class="form-item__label">{{ entry }}</div>
        <input class="form-item__control" type="text" name="base">
      </label>
    </section>

    <section class="form-section">
      <h2 class="form-section__title">{{ offers.title }}</h2>

      <label class="form-item" v-for="(entry, index) of offers.entries" :key="index">
        <div class="form-item__label offer">
          <span class="offer__title">{{ entry.title }}</span>
          <span class="offer__meta">{{ entry.date }}, {{ entry.org }}</span>
        </div>
        <input
          class="form-item__control"
          type="checkbox"
          v-bind:name="'offers--' + entry.title.toLowerCase().split(' ').join('-')"
        >
      </label>
    </section>
  </form>
</template>

<script>
export default {
  name: 'Registration',
  data() {
    return {
      base: {
        title: 'Grunddaten',
        entries: [
          'Familienname',
          'Vorname meines Kindes',
          'Geburtsdatum meines Kindes',
          'Straße',
          'Wohnort',
          'Telefon'
        ]
      },
      offers: {
        title: 'Angebote',
        entries: [
          {
            title: 'Piratenfest an der Ilm',
            date: '26. Juni 2017',
            org: 'Sportjugend Weimar'
          }
        ]
      }
    };
  }
};
</script>

<style scoped>
input {
  border: 2px solid;
}

.form {
  counter-reset: form-section;
}

.form-section {
  counter-increment: form-section;
}

.form-section__title::before {
  content: counter(form-section) '.' '\A0';
}

.form-item {
  display: block;
  padding: 6px;
}

.form-item__control {
  padding: 6px;
}

.offer__title {
  display: block;
  font-weight: bold;
}
</style>
