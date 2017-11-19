<template>
  <form class="form" action="/api/register" method="post">
    <h1>{{ title }}</h1>

    <section
      v-for="(section, index) of sections" :key="index"
      class="form-section"
      :aria-labelledby="`${toIdentifier(section.title)}-label`"
    >
      <h2 class="form-section__title" :id="`${toIdentifier(section.title)}-label`">
        {{ section.title }}
      </h2>

      <component v-for="(entry, index) of section.entries" :key="index" :is="entry.component" :params="entry.params"/>
    </section>
  </form>
</template>

<script>
import Checkbox from './form/Checkbox';
import CheckboxOffer from './form/CheckboxOffer';
import DynamicList from './form/DynamicList';
import Group from './form/Group';
import ParagraphList from './form/ParagraphList';
import RadioButton from './form/RadioButton';
import RadioGroup from './form/RadioGroup';
import TextField from './form/TextField';

export default {
  name: 'Registration',
  data() {
    return {
      title: 'Ferienpass Weimar – Anmeldung',
      sections: [
        {
          title: 'Grunddaten',
          entries: [
            {
              component: Group,
              params: {
                title: 'Grunddaten',
                hideTitle: true,
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
              }
            }
          ]
        },
        {
          title: 'Angebote',
          entries: [
            {
              component: Group,
              params: {
                title: 'Angebote',
                hideTitle: true,
                introduction: 'Mein Kind möchte an folgenden Veranstaltungen teilnehmen:',
                note:
                  'Hinweis: Die Bestätigung des Platzes erfolgt bei der Anmeldung entsprechend der zur Verfügung stehenden Kapazitäten für die Angebote. Sollte ein Angebot seitens der Veranstalter aus unvorhergesehenen Gründen abgesagt werden, besteht kein Anspruch auf ein Ersatzangebot. Der gezahlte Beitrag für dieses Angebot wird Ihnen komplett zurück erstattet.',
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
                      org:
                        '„Für Euch“ e.V. – Schulförderverein des Johannes Landenberger Förderzentrums'
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
              }
            }
          ]
        },
        {
          title: 'Allergien, Krankheiten, …',
          entries: [
            {
              component: DynamicList,
              params: {
                title: 'Allergien',
                emptyMessage: 'Bei meinem Kind muss auf folgende Allergie(n) geachtet werden.',
                textField: {
                  component: TextField,
                  params: {
                    label: 'Neuen Eintrag hinzufügen',
                    placeholder: 'z. B. Heuschnupfen',
                    hideLabel: true
                  }
                }
              }
            },
            {
              component: DynamicList,
              params: {
                title: 'Krankheiten',
                emptyMessage: 'Krankheiten des Kindes bitte hier angeben.',
                textField: {
                  component: TextField,
                  params: {
                    label: 'Neuen Eintrag hinzufügen',
                    placeholder: 'z. B. Epilepsie',
                    hideLabel: true
                  }
                }
              }
            },
            {
              component: Group,
              params: {
                title: 'Hitzeempfindlichkeit',
                entries: [
                  {
                    component: Checkbox,
                    params: {
                      label: 'Mein Kind ist hitzeempfindlich.'
                    }
                  }
                ]
              }
            },
            {
              component: DynamicList,
              params: {
                title: 'Medikamente',
                emptyMessage: 'Vom Kind einzunehmende Medikamente hier eintragen.',
                textField: {
                  component: TextField,
                  params: {
                    label: 'Neuen Eintrag hinzufügen',
                    placeholder: 'z. B. Diazepam',
                    hideLabel: true
                  }
                }
              }
            },
            {
              component: Group,
              params: {
                title: 'Ernährungsbesonderheiten',
                entries: [
                  {
                    component: Checkbox,
                    params: {
                      label: 'Vegetarier'
                    }
                  },
                  {
                    component: Checkbox,
                    params: {
                      label: 'Laktose-Unverträglichkeit'
                    }
                  },
                  {
                    component: Checkbox,
                    params: {
                      label: 'Eier-Unverträglichkeit'
                    }
                  }
                ]
              }
            },
            {
              component: DynamicList,
              params: {
                title: 'Weitere Ernährungsbesonderheiten',
                emptyMessage: 'Bitte beschreiben.',
                textField: {
                  component: TextField,
                  params: {
                    label: 'Neuen Eintrag hinzufügen',
                    placeholder: 'z. B. Milchpulver-Unverträglichkeit',
                    hideLabel: true
                  }
                }
              }
            },
            {
              component: RadioGroup,
              params: {
                title: 'Behandlungserlaubnis bei Erkrankungen und Unfällen',
                entries: [
                  {
                    component: RadioButton,
                    params: {
                      label: 'Ja'
                    }
                  },
                  {
                    component: RadioButton,
                    params: {
                      label: 'Nein'
                    }
                  }
                ]
              }
            },
            {
              component: Group,
              params: {
                title: 'Krankenkasse',
                entries: [
                  {
                    component: TextField,
                    params: {
                      label: 'Name',
                      required: true
                    }
                  }
                ]
              }
            },
            {
              component: Group,
              params: {
                title: 'In Notfällen zu informieren',
                entries: [
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
            },
            {
              component: Group,
              params: {
                title: 'Hausarzt',
                entries: [
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
            }
          ]
        },
        {
          title: 'Angaben bei Behinderung',
          entries: []
        },
        {
          title: 'Erklärung',
          entries: [
            {
              component: RadioGroup,
              params: {
                title: 'Mein Kind darf alleine heimgehen?',
                entries: [
                  {
                    component: RadioButton,
                    params: {
                      label: 'Ja'
                    }
                  },
                  {
                    component: RadioButton,
                    params: {
                      label: 'Nein'
                    }
                  },
                  {
                    component: RadioButton,
                    params: {
                      label: 'Es wird abgeholt'
                    }
                  }
                ]
              }
            },
            {
              component: RadioGroup,
              params: {
                title: 'Mein Kind darf reiten?',
                entries: [
                  {
                    component: RadioButton,
                    params: {
                      label: 'Ja'
                    }
                  },
                  {
                    component: RadioButton,
                    params: {
                      label: 'Nein'
                    }
                  }
                ]
              }
            },
            {
              component: RadioGroup,
              params: {
                title: 'Mein Kind darf schwimmen?',
                entries: [
                  {
                    component: RadioButton,
                    params: {
                      label: 'Ja'
                    }
                  },
                  {
                    component: RadioButton,
                    params: {
                      label: 'Nein'
                    }
                  }
                ]
              }
            }
          ]
        },
        {
          title: 'Datenschutzerklärung',
          entries: [
            {
              component: ParagraphList,
              params: {
                entries: [
                  'Mit Ihrer Unterschrift nimmt das Kinderbüro Weimar die oben genannten Daten und Kontakte auf. Diese Informationen werden im EDV-System des Kinderbüros gespeichert. Personenbezogene Daten werden dabei durch geeignete technische und organisatorische Maßnahmen vor der Kenntnis Dritter geschützt. Sonstige Informationen zu den Kindern werden vom Kinderbüro nur verarbeitet oder genutzt, wenn sie zur Umsetzung der Ziele des Ferienpasses nützlich sind und keine Anhaltspunkte bestehen, dass die betroffene Person ein schutzwürdiges Interesse hat, das der Verarbeitung oder Nutzung entgegensteht.',
                  'Nur das Kinderbüro und Personen, die zur Durchführung der Ferienpass-Angebote Kenntnis über bestimmte Informationen haben müssen, haben Zugang zu den Daten.',
                  'Bei Abmeldung des Kindes werden die in §1 genannten Daten aus dem Verzeichnis gelöscht.',
                  'Alle personenbezogenen Daten werden nach Ablauf eines Jahres gelöscht.'
                ]
              }
            }
          ]
        }
      ]
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
