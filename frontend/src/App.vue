<template>
  <main class="page-content">
    <router-view/>
  </main>
</template>

<script>
export default {
  name: 'app'
};
</script>

<style>
*,
*::before,
*::after {
  box-sizing: border-box;
}

html {
  font-size: 1.5em;
  line-height: 1.5;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell,
    'Open Sans', 'Helvetica Neue', sans-serif;
}

/*
* Resets
*/
fieldset {
  margin: 0;
  padding: 0;
  border: 0;
}

legend {
  padding: 0;
  border: 0;
}

button,
input {
  -webkit-appearance: none;
  -moz-appearance: none;
  overflow: visible;
  font: inherit;
  border: 0;
  margin: 0;
  padding: 0;
}

button:disabled,
input:disabled {
  color: #888;
}

:focus {
  outline: 0.125rem solid orange;
}

[tabindex='-1'] {
  outline: none;
}

.button {
  padding: 0.25rem;
  border: 0.125rem solid;
  border-radius: 0.5rem;
  background-color: #fff;
  line-height: 1;
}

.button--delete {
  padding-right: 0.5rem;
  padding-left: 0.5rem;
}

.button--delete:hover {
  background-color: tomato;
  border-color: #222;
}

.button:focus {
  outline: none;
  box-shadow: 0 0 0 0.125rem #fff, 0 0 0 0.25rem cornflowerblue;
}

.visually-hidden {
  position: absolute !important;
  clip: rect(1px, 1px, 1px, 1px);
  padding: 0 !important;
  border: 0 !important;
  height: 1px !important;
  width: 1px !important;
  overflow: hidden;
}
</style>

<style scoped>
.page-content {
  max-width: 1000px;
  margin: 3rem auto;
}
</style>
