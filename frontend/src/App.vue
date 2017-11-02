<template>
  <main>
    <router-view/>
  </main>
</template>

<script>
export default {
  name: 'app'
};
</script>

<style>
html {
  font-size: 1.5em;
  line-height: 1.5;
  font-family: Georgia, 'Times New Roman', Times, serif;
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
  padding: 0;
}
</style>
