<template>
  <label class="checkbox">

    <input
      class="checkbox__control visually-hidden"
      type="checkbox"
      :name="params.name"
      :required="params.required"
      :data-minimum-age="params.projekt ? params.projekt.minimumAge : ''"
      :data-id="params.projekt ? params.projekt.id : ''"
      @change="onChecked"
    >

    <span class="checkbox__tick"></span>

    <span class="checkbox__label">
      <template v-if="params.projekt">
        <span style="font-weight: bold;">{{ params.label }}</span>
        <ul class="meta-list">
          <li>{{ params.projekt.date[2] }}.{{ params.projekt.date[1] }}.{{ params.projekt.date[0] }} - {{ params.projekt.endDate[2] }}.{{ params.projekt.endDate[1] }}.{{ params.projekt.endDate[0] }}</li>
          <li>Ab {{ params.projekt.minimumAge }} Jahren</li>
          <li>{{ params.projekt.org }}</li>
        </ul>
      </template>
      <template v-else>
        {{ params.label }}
      </template>
    </span>
  </label>
</template>

<script>
export default {
  name: 'Checkbox',
  props: ['params'],
  methods: {
    onChecked(event) {
      this.$emit('change', event);
    }
  }
};
</script>

<style scoped>
.checkbox {
  display: flex;
  align-items: center;
  position: relative;
  margin-bottom: 0.75rem;
}

.checkbox__label {
  padding-right: 24px;
  padding-left: 8px;
}

.checkbox__tick {
  flex-shrink: 0;
  position: relative;
  width: 1.5rem;
  height: 1.5rem;
  margin: 2px;
  border-radius: 8px;
  border: 2px solid;
  background-color: #fff;
}

.checkbox__control:disabled ~ .checkbox__tick {
  color: #888;
  background-color: #eee;
}

.checkbox__control:disabled ~ .checkbox__label {
  color: #888;
}

/*
We explicitly set the height of the control to be as tall as its next parent context.
This is necessary for when one navigates to a control outside the current viewport.
Then, current scrolling distance would adjust as much as to fit in the full control.
Making it 100% the height of its parenting context should cover the whole component,
not only the control. The reason this is problematic is the control being visually
hidden, thus only having a dimension of 1 by 1 pixels. In other words, without this,
the componente would only become partially visible.
*/
.checkbox__control {
  position: absolute !important;
  top: 0 !important;
  height: 100% !important;
  outline: none;
}

.checkbox__control:focus ~ .checkbox__tick {
  box-shadow: 0 0 0 2px cornflowerblue;
}

.checkbox__control:checked ~ .checkbox__tick::before {
  content: '\2713';
  width: 100%;
  height: 100%;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.meta-list {
  list-style: none;
  margin: 0;
  font-size: 0.9em;
}
</style>
