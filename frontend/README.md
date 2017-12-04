# frontend

## Build Setup

```bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run e2e tests
npm run e2e

# run all tests
npm test
```

## Documentation

### Registration

The Registration component (in `frontend/src/components/Registration.vue`) wraps the main
registration form.

It makes an asynchronous HTTP request to the resource `/static/form-data.json`. This is a big data
structure containing all information for rendering the registration form. Once the data is loaded
and parsed, the Registration component renders the form with the following algorithm.

1. Let `formData` be the form data
2. Load the form data via an asynchronous HTTP request and parse it into `formData`.
3. Add a `<form>` element. Inside `<form>`:

   1. Use a heading to label the form with `formData.title`.
   2. Use `formData.title` to provide a label for `<form>`.
   3. For each `section` in `formData.sections`: Add a `<section>` element. Inside `<section>`:

      1. Use `section.title` to provide a label for `<section>`.
      2. For each `component` in `section.components`: Add a `<component>` element.

         ```
         <component :is="component.name" :params="component.params" />
         ```

         Use `component.name` to identify the component via
         [Vue.js `is` keyword](https://vuejs.org/v2/api/#is).

         Use `component.params` as data to pass to the components via
         [Vue.js Props](https://vuejs.org/v2/guide/components.html#Props).

   4. Add an `<input type="submit">` element
