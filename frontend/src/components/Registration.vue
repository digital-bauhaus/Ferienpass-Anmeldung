<template>
  <form class="form" action="" method="post">
    <h1>Ferienpass Weimar – Anmeldung</h1>

    <section class="form-section" :aria-labelledby="`${toIdentifier(basics.title)}-label`">
      <h2 class="form-section__title" :id="`${toIdentifier(basics.title)}-label`">
        {{ basics.title }}
      </h2>

      <div class="form-item" v-for="(entry, index) of basics.entries" :key="index">
        <component :is="entry.component" :params="entry.params"/>
      </div>
    </section>

    <section class="form-section" :aria-labelledby="`${toIdentifier(offers.title)}-label`">
      <h2 class="form-section__title" :id="`${toIdentifier(offers.title)}-label`">
        {{ offers.title }}
      </h2>

      <p>Mein Kind möchte an folgenden Veranstaltungen teilnehmen:</p>

      <div class="form-item" v-for="(entry, index) of offers.entries" :key="index">
        <component :is="entry.component" :params="entry.params"/>
      </div>

      <p><b>Hinweis:</b> Die Bestätigung des Platzes erfolgt bei der Anmeldung entsprechend der zur Verfügung stehenden Kapazitäten für die Angebote. Sollte ein Angebot seitens der Veranstalter aus unvorhergesehenen Gründen abgesagt werden, besteht kein Anspruch auf ein Ersatzangebot. Der gezahlte Beitrag für dieses Angebot wird Ihnen komplett zurück erstattet.</p>
    </section>

    <section class="form-section" :aria-labelledby="`${toIdentifier(conditions.title)}-label`">
      <h2 class="form-section__title" :id="`${toIdentifier(conditions.title)}-label`">
        {{ conditions.title }}
      </h2>

      <p>Worauf muss bei meinem Kind besonders geachtet werden?</p>

      <div class="form-item" v-for="(entry, index) of conditions.entries" :key="index">
        <h3 v-if="entry.title">{{ entry.title }}</h3>

        <component :is="entry.component" :params="entry.params"/>
      </div>
    </section>
  </form>
</template>

<script>
import TextField from './form/TextField.vue';
import Checkbox from './form/Checkbox.vue';
import CheckboxOffer from './form/CheckboxOffer.vue';
import DynamicList from './form/DynamicList.vue';

export default {
  name: 'Registration',
  components: {
    TextField,
    CheckboxOffer,
    DynamicList,
    Checkbox
  },
  data() {
    return {
      basics: {
        title: 'Grunddaten',
        entries: [
          {
            component: TextField,
            params: {
              label: 'Familienname',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Vorname meines Kindes',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Geburtsdatum meines Kindes',
              required: true,
              type: 'date'
            }
          },
          {
            component: TextField,
            params: {
              label: 'Straße',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Wohnort',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Telefon',
              required: true,
              type: 'tel'
            }
          }
        ]
      },
      offers: {
        title: 'Angebote',
        entries: [
          {
            component: CheckboxOffer,
            params: {
              label: 'Piratenfest an der Ilm',
              date: '26. Juni 2017',
              org: 'Sportjugend Weimar'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Bauspielplatz',
              date: '26. bis 28. Juni 2017',
              org: 'Kramixxo & Waggong'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Papier-Werkstatt',
              date: '26. bis 28. Juni 2017',
              org: 'Weimarer Mal- und Zeichenschule e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Indianer und ihre Tiere',
              date: '27. bis 28. Juni 2017',
              org: 'Camsin e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Filz-Werkstatt',
              date: '29. bis 30. Juni 2017',
              org: 'Weimarer Mal- und Zeichenschule e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Indianer und ihre Tiere',
              date: '29. bis 30. Juni 2017',
              org: 'Camsin e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Das Alien vom Planeten Alpha Omega Pi',
              date: '3. bis 7. Juli 2017',
              org: 'Buchkinder_Weimar'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Graffiti',
              date: '3. bis 4. Juli 2017',
              org: '„Für Euch“ e.V. – Schulförderverein des Johannes Landenberger Förderzentrums'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Fahrrad-Tour aus dem Feiniger Radweg',
              date: '4. Juli 2017',
              org: 'Team Jugendarbeit Weimar'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Die große Schatzsuche',
              date: '10. bis 12. Juli 2017',
              org: 'Weimarer Mal- und Zeichenschule e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Skateboard-Kurs',
              date: '12. bis 14. Juli 2017',
              org: 'Nordlicht e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Kinderzirkus',
              date: '17. bis 19. Juli 2017',
              org: 'Tasifan'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Klettern',
              date: '25. Juli 2017',
              org: 'Sektion Weimar des Deutschen Alpenvereins e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Klettern',
              date: '26. Juli 2017',
              org: 'Sektion Weimar des Deutschen Alpenvereins e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'GrenzbeWEGnung',
              date: '31. Juli bis 4. August 2017',
              org: 'WE-DANCE e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Angeln',
              date: '31. Juli bis 1. August 2017',
              org: 'Nordlicht e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Jiddisch – Wir singen tanzen spielen',
              date: '2. bis 6. August 2017',
              org: 'other music e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Angeln',
              date: '2. bis 3. August 2017',
              org: 'Nordlicht e.V.'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Natur-Erlebnis-Camp',
              date: '7. bis 9. August 2017',
              org: 'Kramixxo & Waggong'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Geräusche-Jagd',
              date: '8. August 2017',
              org: 'Radio LOTTE Weimar'
            }
          },
          {
            component: CheckboxOffer,
            params: {
              label: 'Schlauchboot-Tour',
              date: '9. August 2017',
              org: 'erlebniswelten'
            }
          }
        ]
      },
      conditions: {
        title: 'Allergien, Krankheiten, …',
        entries: [
          {
            component: DynamicList,
            params: {
              title: 'Allergien',
              emptyMessage: 'Bei meinem Kind muss auf folgende Allergie(n) geachtet werden.',
              textField: {
                label: 'Neuen Eintrag hinzufügen',
                placeholder: 'z. B. Heuschnupfen',
                hideLabel: true
              }
            }
          },
          {
            component: DynamicList,
            params: {
              title: 'Krankheiten',
              emptyMessage: 'Krankheiten des Kindes bitte hier angeben.',
              textField: {
                label: 'Neuen Eintrag hinzufügen',
                placeholder: 'z. B. Epilepsie',
                hideLabel: true
              }
            }
          },
          {
            component: DynamicList,
            params: {
              title: 'Medikamente',
              emptyMessage: 'Vom Kind einzunehmende Medikamente hier eintragen.',
              textField: {
                label: 'Neuen Eintrag hinzufügen',
                placeholder: 'z. B. Diazepam',
                hideLabel: true
              }
            }
          },
          {
            title: 'Hitzeempfindlichkeit',
            component: Checkbox,
            params: {
              label: 'Mein Kind ist hitze-empfindlich.'
            }
          },
          {
            title: 'In Notfällen zu informieren'
          },
          {
            component: TextField,
            params: {
              label: 'Name',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Anschrift',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Telefon',
              required: true,
              type: 'tel'
            }
          },
          {
            title: 'Hausarzt'
          },
          {
            component: TextField,
            params: {
              label: 'Name',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Anschrift',
              required: true
            }
          },
          {
            component: TextField,
            params: {
              label: 'Telefon',
              required: true,
              type: 'tel'
            }
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
