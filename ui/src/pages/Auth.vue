<template>
  <v-img class="mx-auto my-6" max-width="228"
    src="https://cdn.vuetifyjs.com/docs/images/logos/vuetify-logo-v3-slim-text-light.svg"></v-img>

  <v-card class="mx-auto pa-12 pb-8" elevation="8" max-width="448" rounded="lg">
    <div class="text-subtitle-1 text-medium-emphasis">Account</div>

    <v-text-field density="compact" placeholder="Enter your username"
      :prepend-inner-icon="`mdi-account${filled ? '' : '-outline'}`" variant="outlined"></v-text-field>

    <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
      Password
    </div>

    <v-text-field :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'" :type="visible ? 'text' : 'password'"
      density="compact" placeholder="Enter your password" prepend-inner-icon="mdi-lock-outline" variant="outlined"
      @click:append-inner="visible = !visible"></v-text-field>

    <v-btn class="mb-8" color="blue" size="large" variant="tonal" block>
      Log In
    </v-btn>

    <v-card-text class="text-center">
      <a class="text-blue text-decoration-none" href="#" rel="noopener noreferrer" target="_blank">
        Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
      </a>
    </v-card-text>
  </v-card>
</template>

<script setup>
import { computed, reactive, ref } from 'vue'

const loginCredentials = reactive({
  username: '',
  password: ''
})

const visible = ref(false)

const filled = computed(() => 
  loginCredentials.username.length > 0 ? true : false

)
</script>

<style scoped></style>
