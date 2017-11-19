export const toIdentifier = {
  methods: {
    toIdentifier: function(value) {
      return value
        .toLowerCase()
        .replace(/[^\w ]+/g, '')
        .replace(/ +/g, '-');
    }
  }
};
