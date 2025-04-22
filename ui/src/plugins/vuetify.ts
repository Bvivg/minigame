import "vuetify/styles";
import "@mdi/font/css/materialdesignicons.css";

import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import { h } from "vue";

export const vuetify = createVuetify({
  components,
  directives,
  icons: {
    defaultSet: "mdi", // 👉 выбираем MDI по умолчанию
    sets: {
      mdi: {
        component: (props) => h("i", { ...props, class: "mdi " + props.icon }),
      },
    },
  },
});
