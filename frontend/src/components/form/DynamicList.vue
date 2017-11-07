<template>
  <div class="form-item dynamic-list">
    <h3 :id="toIdentifier(listData.title)" tabindex="-1">{{ listData.title }}</h3>

    <ul class="dynamic-list__items">
      <li class="list-item" v-for="(item, index) of listItems" :key="index">
        <span class="list-item__content">{{ item }}</span>
        <button class="button button--delete" type="button" :aria-label="`Entferne ${item}.`" @click="remove(index, item)">×</button>
      </li>
    </ul>

    <div class="dynamic-list__empty-message">
      <p>{{ listData.emptyMessage }}</p>
    </div>

    <div class="add-item">
      <label class="add-item__label">
        <span class="visually-hidden">Neuen Eintrag hinzufügen</span>
        <input class="add-item__input" type="text" :placeholder="listData.placeholder" v-model="newItem" @keydown="handleInput">
      </label>
      <button class="button add-item__control" type="button" :disabled="inputIsEmpty" @click="add">Hinzufügen</button>
    </div>

    <div class="visually-hidden" role="status" aria-live="polite">
      {{ feedback }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'DynamicList',
  props: ['listData', 'toIdentifier'],
  data() {
    return {
      newItem: '',
      feedback: '',
      listItems: []
    };
  },
  computed: {
    inputIsEmpty() {
      return this.newItem.trim() === '';
    }
  },
  methods: {
    handleInput(event) {
      if (event.keyCode === 13 && !this.inputIsEmpty) {
        this.add();
      }
    },
    add() {
      this.listItems.push(this.newItem);
      this.feedback = `${this.newItem} hinzugefügt.`;
      this.newItem = '';
    },
    remove(index, item) {
      this.listItems.splice(index, 1);
      document.querySelector(`#${this.toIdentifier(this.listData.title)}`).focus();
      this.feedback = `${item} entfernt.`;
    }
  }
};
</script>


<style scoped>
.dynamic-list__items:empty,
.dynamic-list__items:not(:empty) ~ .dynamic-list__empty-message {
  display: none;
}

.dynamic-list__items {
  margin-top: 0;
  margin-bottom: 0;
}

.list-item {
  display: flex;
}

.list-item::before {
  content: '\2012';
  position: relative;
  left: -0.75rem;
}

.list-item__content {
  flex-grow: 1;
}

.add-item {
  margin-top: 0.75rem;
  display: flex;
}

.add-item__label {
  flex-grow: 1;
  margin-right: 1rem;
}
</style>
