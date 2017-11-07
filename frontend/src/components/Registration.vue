<template>
  <form class="form" action="">
    <h1>Ferienpass Weimar – Anmeldung</h1>

    <section class="form-section" :aria-labelledby="`${toIdentifier(basics.title)}-label`">
      <h2 class="form-section__title" :id="`${toIdentifier(basics.title)}-label`">
        {{ basics.title }}
      </h2>

      <div class="form-item" v-for="(entry, index) of basics.entries" :key="index">
        <text-field :entry="entry" :toIdentifier="toIdentifier"/>
      </div>
    </section>

    <section class="form-section" :aria-labelledby="`${toIdentifier(offers.title)}-label`">
      <h2 class="form-section__title" :id="`${toIdentifier(offers.title)}-label`">
        {{ offers.title }}
      </h2>

      <p>Mein Kind möchte an folgenden Veranstaltungen teilnehmen:</p>

      <div class="form-item" v-for="(entry, index) of offers.entries" :key="index">
        <checkbox-offer :entry="entry" :toIdentifier="toIdentifier"/>
      </div>

      <p><b>Hinweis:</b> Die Bestätigung des Platzes erfolgt bei der Anmeldung entsprechend der zur Verfügung stehenden Kapazitäten für die Angebote. Sollte ein Angebot seitens der Veranstalter aus unvorhergesehenen Gründen abgesagt werden, besteht kein Anspruch auf ein Ersatzangebot. Der gezahlte Beitrag für dieses Angebot wird Ihnen komplett zurück erstattet.</p>
    </section>

    <section class="form-section">
      <h2 class="form-section__title">{{ conditions.title }}</h2>

      <p>Worauf muss bei meinem Kind besonders geachtet werden?</p>

      <dynamic-list
        v-for="(entry, index) of conditions.entries"
        :key="index"
        :listData="entry"
        :toIdentifier="toIdentifier"
      />
    </section>
  </form>
</template>

<script>
import TextField from './form/TextField.vue';
import CheckboxOffer from './form/CheckboxOffer.vue';
import DynamicList from './form/DynamicList.vue';

export default {
  name: 'Registration',
  components: {
    TextField,
    CheckboxOffer,
    DynamicList
  },
  methods: {
    toIdentifier: function(value) {
      return value
        .toLowerCase()
        .split(' ')
        .join('-');
    }
  },
  data() {
    return {
      basics: {
        title: 'Grunddaten',
        entries: [
          {
            title: 'Familienname',
            required: true
          },
          {
            title: 'Vorname meines Kindes',
            required: true
          },
          {
            title: 'Geburtsdatum meines Kindes',
            required: true,
            type: 'date'
          },
          {
            title: 'Straße',
            required: true
          },
          {
            title: 'Wohnort',
            required: true
          },
          {
            title: 'Telefon',
            required: true,
            type: 'tel'
          }
        ]
      },
      offers: {
        title: 'Angebote',
        entries: [
          {
            title: 'Piratenfest an der Ilm',
            date: '26. Juni 2017',
            org: 'Sportjugend Weimar'
          },
          {
            title: 'Bauspielplatz',
            date: '26. bis 28. Juni 2017',
            org: 'Kramixxo & Waggong'
          },
          {
            title: 'Papier-Werkstatt',
            date: '26. bis 28. Juni 2017',
            org: 'Weimarer Mal- und Zeichenschule e.V.'
          },
          {
            title: 'Indianer und ihre Tiere',
            date: '27. bis 28. Juni 2017',
            org: 'Camsin e.V.'
          },
          {
            title: 'Filz-Werkstatt',
            date: '29. bis 30. Juni 2017',
            org: 'Weimarer Mal- und Zeichenschule e.V.'
          },
          {
            title: 'Indianer und ihre Tiere',
            date: '29. bis 30. Juni 2017',
            org: 'Camsin e.V.'
          },
          {
            title: 'Das Alien vom Planeten Alpha Omega Pi',
            date: '3. bis 7. Juli 2017',
            org: 'Buchkinder_Weimar'
          },
          {
            title: 'Graffiti',
            date: '3. bis 4. Juli 2017',
            org: '„Für Euch“ e.V. – Schulförderverein des Johannes Landenberger Förderzentrums'
          },
          {
            title: 'Fahrrad-Tour aus dem Feiniger Radweg',
            date: '4. Juli 2017',
            org: 'Team Jugendarbeit Weimar'
          },
          {
            title: 'Die große Schatzsuche',
            date: '10. bis 12. Juli 2017',
            org: 'Weimarer Mal- und Zeichenschule e.V.'
          },
          {
            title: 'Skateboard-Kurs',
            date: '12. bis 14. Juli 2017',
            org: 'Nordlicht e.V.'
          },
          {
            title: 'Kinderzirkus',
            date: '17. bis 19. Juli 2017',
            org: 'Tasifan'
          },
          {
            title: 'Klettern',
            date: '25. Juli 2017',
            org: 'Sektion Weimar des Deutschen Alpenvereins e.V.'
          },
          {
            title: 'Klettern',
            date: '26. Juli 2017',
            org: 'Sektion Weimar des Deutschen Alpenvereins e.V.'
          },
          {
            title: 'GrenzbeWEGnung',
            date: '31. Juli bis 4. August 2017',
            org: 'WE-DANCE e.V.'
          },
          {
            title: 'Angeln',
            date: '31. Juli bis 1. August 2017',
            org: 'Nordlicht e.V.'
          },
          {
            title: 'Jiddisch – Wir singen tanzen spielen',
            date: '2. bis 6. August 2017',
            org: 'other music e.V.'
          },
          {
            title: 'Angeln',
            date: '2. bis 3. August 2017',
            org: 'Nordlicht e.V.'
          },
          {
            title: 'Natur-Erlebnis-Camp',
            date: '7. bis 9. August 2017',
            org: 'Kramixxo & Waggong'
          },
          {
            title: 'Geräusche-Jagd',
            date: '8. August 2017',
            org: 'Radio LOTTE Weimar'
          },
          {
            title: 'Schlauchboot-Tour',
            date: '9. August 2017',
            org: 'erlebniswelten'
          }
        ]
      },
      conditions: {
        title: 'Allergien, Krankheiten, …',
        entries: [
          {
            title: 'Allergien',
            placeholder: 'Heuschnupfen, …',
            emptyMessage: 'Liste ist leer. Neue Einträge hinzufügen ↓'
          },
          {
            title: 'Krankheiten',
            placeholder: 'BEISPIEL, …',
            emptyMessage: 'Liste ist leer. Neue Einträge hinzufügen ↓'
          }
          // { title: 'Hitzeempfindlichkeit' },
          // { title: 'Medikamente' },
          // { title: 'Ernährungsbesonderheiten' },
          // { title: 'Behinderung' },
          // { title: 'Sonstiges' },
          // { title: 'Behandlungserlaubnis bei Erkrankungen und Unfällen' },
          // { title: 'Krankenkasse' }
        ]
      }
    };
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
  margin-bottom: 1.5rem;
}
</style>
