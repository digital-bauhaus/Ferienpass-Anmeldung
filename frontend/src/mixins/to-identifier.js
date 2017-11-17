export const toIdentifier = {
  methods: {
    toIdentifier: function(value) {
      return value
        .toLowerCase()
        .split(' ')
        .join('-');
    }
  }
};
