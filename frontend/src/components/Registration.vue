<template>
  <form class="form" action="">
    <h1>Ferienpass Weimar – Anmeldung</h1>

    <section class="form-section" :aria-labelledby="`${toIdentifier(basics.title)}-label`">
      <h2 class="form-section__title" :id="`${toIdentifier(basics.title)}-label`">
        {{ basics.title }}
      </h2>

      <div class="form-item" v-for="(textField, index) of basics.textFields" :key="index">
        <text-field :textField="textField" :toIdentifier="toIdentifier"/>
      </div>
    </section>

    <section class="form-section" :aria-labelledby="`${toIdentifier(offers.title)}-label`">
      <h2 class="form-section__title" :id="`${toIdentifier(offers.title)}-label`">
        {{ offers.title }}
      </h2>

      <p>Mein Kind möchte an folgenden Veranstaltungen teilnehmen:</p>

      <div class="form-item" v-for="(checkbox, index) of offers.checkboxes" :key="index">
        <checkbox-offer :checkbox="checkbox" :toIdentifier="toIdentifier"/>
      </div>

      <p><b>Hinweis:</b> Die Bestätigung des Platzes erfolgt bei der Anmeldung entsprechend der zur Verfügung stehenden Kapazitäten für die Angebote. Sollte ein Angebot seitens der Veranstalter aus unvorhergesehenen Gründen abgesagt werden, besteht kein Anspruch auf ein Ersatzangebot. Der gezahlte Beitrag für dieses Angebot wird Ihnen komplett zurück erstattet.</p>
    </section>

    <section class="form-section">
      <h2 class="form-section__title">{{ conditions.title }}</h2>

      <p>Worauf muss bei meinem Kind besonders geachtet werden?</p>

      <dynamic-list
        v-for="(dynamicList, index) of conditions.dynamicLists"
        :key="index"
        :dynamicList="dynamicList"
        :toIdentifier="toIdentifier"
      />

      <div class="form-item" v-for="(checkbox, index) of conditions.checkboxes" :key="index">
        <h3>Hitzeempfindlichkeit</h3>
        <checkbox :checkbox="checkbox" :toIdentifier="toIdentifier"/>
      </div>

      <h3>In Notfällen zu informieren</h3>

      <div class="form-item" v-for="(textField, index) of emergencyContact.textFields" :key="index">
        <text-field :textField="textField" :toIdentifier="toIdentifier"/>
      </div>

      <h3>Hausarzt</h3>

      <div class="form-item" v-for="(textField, index) of familyDoctor.textFields" :key="index">
        <text-field :textField="textField" :toIdentifier="toIdentifier"/>
      </div>

    </section>
  </form>
</template>

<script>
import TextField from './form/TextField.vue';
import CheckboxOffer from './form/CheckboxOffer.vue';
import DynamicList from './form/DynamicList.vue';
import Checkbox from './form/Checkbox.vue';

export default {
  name: 'Registration',
  components: {
    TextField,
    CheckboxOffer,
    DynamicList,
    Checkbox
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
        textFields: [
          {
            label: 'Familienname',
            required: true
          },
          {
            label: 'Vorname meines Kindes',
            required: true
          },
          {
            label: 'Geburtsdatum meines Kindes',
            required: true,
            type: 'date'
          },
          {
            label: 'Straße',
            required: true
          },
          {
            label: 'Wohnort',
            required: true
          },
          {
            label: 'Telefon',
            required: true,
            type: 'tel'
          }
        ]
      },
      offers: {
        title: 'Angebote',
        checkboxes: [
          {
            label: 'Piratenfest an der Ilm',
            date: '26. Juni 2017',
            org: 'Sportjugend Weimar'
          },
          {
            label: 'Bauspielplatz',
            date: '26. bis 28. Juni 2017',
            org: 'Kramixxo & Waggong'
          },
          {
            label: 'Papier-Werkstatt',
            date: '26. bis 28. Juni 2017',
            org: 'Weimarer Mal- und Zeichenschule e.V.'
          },
          {
            label: 'Indianer und ihre Tiere',
            date: '27. bis 28. Juni 2017',
            org: 'Camsin e.V.'
          },
          {
            label: 'Filz-Werkstatt',
            date: '29. bis 30. Juni 2017',
            org: 'Weimarer Mal- und Zeichenschule e.V.'
          },
          {
            label: 'Indianer und ihre Tiere',
            date: '29. bis 30. Juni 2017',
            org: 'Camsin e.V.'
          },
          {
            label: 'Das Alien vom Planeten Alpha Omega Pi',
            date: '3. bis 7. Juli 2017',
            org: 'Buchkinder_Weimar'
          },
          {
            label: 'Graffiti',
            date: '3. bis 4. Juli 2017',
            org: '„Für Euch“ e.V. – Schulförderverein des Johannes Landenberger Förderzentrums'
          },
          {
            label: 'Fahrrad-Tour aus dem Feiniger Radweg',
            date: '4. Juli 2017',
            org: 'Team Jugendarbeit Weimar'
          },
          {
            label: 'Die große Schatzsuche',
            date: '10. bis 12. Juli 2017',
            org: 'Weimarer Mal- und Zeichenschule e.V.'
          },
          {
            label: 'Skateboard-Kurs',
            date: '12. bis 14. Juli 2017',
            org: 'Nordlicht e.V.'
          },
          {
            label: 'Kinderzirkus',
            date: '17. bis 19. Juli 2017',
            org: 'Tasifan'
          },
          {
            label: 'Klettern',
            date: '25. Juli 2017',
            org: 'Sektion Weimar des Deutschen Alpenvereins e.V.'
          },
          {
            label: 'Klettern',
            date: '26. Juli 2017',
            org: 'Sektion Weimar des Deutschen Alpenvereins e.V.'
          },
          {
            label: 'GrenzbeWEGnung',
            date: '31. Juli bis 4. August 2017',
            org: 'WE-DANCE e.V.'
          },
          {
            label: 'Angeln',
            date: '31. Juli bis 1. August 2017',
            org: 'Nordlicht e.V.'
          },
          {
            label: 'Jiddisch – Wir singen tanzen spielen',
            date: '2. bis 6. August 2017',
            org: 'other music e.V.'
          },
          {
            label: 'Angeln',
            date: '2. bis 3. August 2017',
            org: 'Nordlicht e.V.'
          },
          {
            label: 'Natur-Erlebnis-Camp',
            date: '7. bis 9. August 2017',
            org: 'Kramixxo & Waggong'
          },
          {
            label: 'Geräusche-Jagd',
            date: '8. August 2017',
            org: 'Radio LOTTE Weimar'
          },
          {
            label: 'Schlauchboot-Tour',
            date: '9. August 2017',
            org: 'erlebniswelten'
          }
        ]
      },
      conditions: {
        title: 'Allergien, Krankheiten, …',
        dynamicLists: [
          {
            label: 'Allergien',
            emptyMessage: 'Bei meinem Kind muss auf folgende Allergie(n) geachtet werden.',
            textField: {
              label: 'Neuen Eintrag hinzufügen',
              placeholder: 'z. B. Heuschnupfen',
              hideLabel: true
            }
          },
          {
            label: 'Krankheiten',
            emptyMessage: 'Krankheiten des Kindes bitte hier angeben.',
            textField: {
              label: 'Neuen Eintrag hinzufügen',
              placeholder: 'z. B. Epilepsie',
              hideLabel: true
            }
          },
          {
            label: 'Medikamente',
            emptyMessage: 'Vom Kind einzunehmende Medikamente hier eintragen.',
            textField: {
              label: 'Neuen Eintrag hinzufügen',
              placeholder: 'z. B. Diazepam',
              hideLabel: true
            }
          }
        ],
        checkboxes: [
          {
            label: 'My Kind ist Hitze-empfindlich.'
          }
        ]
      },
      emergencyContact: {
        textFields: [
          {
            label: 'Name',
            required: true
          },
          {
            label: 'Anschrift',
            required: true
          },
          {
            label: 'Telefon',
            required: true,
            type: 'tel'
          }
        ]
      },
      familyDoctor: {
        textFields: [
          {
            label: 'Name',
            required: true
          },
          {
            label: 'Anschrift',
            required: true
          },
          {
            label: 'Telefon',
            required: true,
            type: 'tel'
          }
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
  margin-bottom: 0.75rem;
}
</style>
