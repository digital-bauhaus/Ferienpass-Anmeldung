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

/*
* Resets
*/
body,
h1,
h2,
h3,
h4,
h5,
h6,
ul,
ol,
dl {
  margin: 0;
  padding: 0;
}

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
input,
textarea {
  -webkit-appearance: none;
  -moz-appearance: none;
  overflow: visible;
  color: inherit;
  font: inherit;
  border: 0;
  margin: 0;
  padding: 0;
}

html {
  font-size: 1.25rem;
  line-height: 1.5;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell,
    'Open Sans', 'Helvetica Neue', sans-serif;
  overflow-y: scroll;
}

h1,
h2,
h3,
h4,
h5,
h6,
p {
  margin-top: 1.5rem;
  margin-bottom: 1.5rem;
}

ul,
ol {
  margin-bottom: 1.5rem;
  margin-left: 1.5rem;
}

/*
base.form-elements.css
*/
button:disabled,
input:disabled {
  color: #888;
}

button::placeholder,
input::placeholder {
  color: #444;
  opacity: 1;
}

textarea {
  display: block;
  width: 100%;
  resize: vertical;
}

:focus {
  outline: 2px solid orange;
}

[tabindex='-1']:focus {
  outline: none;
}

.button {
  padding: 4px;
  border: 2px solid;
  border-radius: 8px;
  background-color: #fff;
}

.button:focus {
  outline: none;
  box-shadow: 0 0 0 2px #fff, 0 0 0 4px cornflowerblue;
}

.button--wide {
  padding-right: 48px;
  padding-left: 48px;
}

.button--inline {
  width: 32px;
  height: 32px;
  line-height: 1;
}

.delete-button:hover {
  background-color: tomato;
  border-color: #222;
}

/*
trumps.visually-hidden.css
*/
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
  width: 80%;
  max-width: 1000px;
  margin: 3rem auto;
}
</style>
