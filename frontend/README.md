# frontend

## Build Setup

```bash
# install dependencies
npm install

# serve with hot reload at localhost:8090
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

The Registration component (in `frontend/src/components/Registration.vue`) wraps the main registration form.

It makes an asynchronous HTTP request to the resource `/static/form-data.json`. This is a big data structure containing all information for rendering the registration form. Once the data is loaded and parsed, the Registration component renders the form with the following algorithm.

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

         Use `component.name` to identify the form component via [Vue.js `is` keyword](https://vuejs.org/v2/api/#is).

         Use `component.params` as data to pass to the components via [Vue.js Props](https://vuejs.org/v2/guide/components.html#Props).

   4. Add an `<input type="submit">` element

### Form Components

The application uses a variety of form components. Generally, they follow a predictable pattern: All required parameters that are required to render a form control are passed from a parent context to the form component via the `params` property.

The most basic component definition minus its template and styles looks like this:

```
export default {
  name: 'TextArea',
  props: ['params']
};
```

A component named `TextArea` is defined. It expects a property named `params` to be bound to it upon usage.

#### TextField (`<input type="text">`)

**`params`**:

* `params.label` (required)
* `params.hideLabel` (optional): Allows hiding the label visually by toggling the `visually-hidden` class on the label.
* `params.type` (optional): Specify the `type` attribute for the `<input>` element. Possible values include: `number`, `tel`, `url`.
* `params.placeholder` (optional): Specify the `placeholder` attribute for the `<input>` element.
* `params.required` (optional): Specify the `placeholder` attribute for the `<input>` element.

**`value`**:

A text field has a special property `value` which allows a parent component to propagate the `value` attribute to the text field component. The `DynamicList` component uses this property to clear the input’s value after it has been consumed.

**`onInput`**:

A custom `valueChange` event is fired whenever a text field’s value changes. This enables parent components to register event listeners listening for the `valueChange` event.

**`onEnter`**:

A custom `enter` event is fired whenever the <kbd>Enter</kbd> key is pressed inside a text field.

#### Checkbox (`<input type="checkbox">`)

A checkbox should usually appear within an appropriate group component (i.e. `Group`). This allows to group multiple related controls (e.g. multiple checkboxes) together.

**`params`**:

* `params.label` (required)
* `params.required` (optional): Specify the `placeholder` attribute for the `<input>` element.
* `params.date`, `params.org` (optional): Specifying these additional properties renders a visually different label.

**`onChecked`**:

A custom `checked` event is fired whenever the checkbox’s checked state changes. This enables parent components to register event listeners listening for the `checked` event.

#### RadioButton (`<input type="radio">`)

Multiple, related radio buttons must be grouped together in a `RadioGroup` component. This ensures that the radio buttons carry the same name attribute which identifies them as belonging together.

**`params`**:

* `params.label` (required)

**`name`**:

A radio button has a special, required property `name` that is used to set the grouping `name` attribute on the `<input>` element. The `RadioGroup` component takes care of passing _the same_ value to the `name` property. This way, multiple radio buttons inside a radio group form a group of _related_ controls that interact with each other.

#### TextArea (`<textarea>`)

**`params`**:

* `params.label` (required)
* `params.hideLabel` (optional): Allows hiding the label visually by toggling the `visually-hidden` class on the label.

#### DynamicList
