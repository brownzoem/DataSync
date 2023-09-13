<template>
  <v-app id="inspire" class="app">

    <v-app-bar title="dbSync" elevation="1">

      <v-spacer></v-spacer>

      <v-btn icon @click="toggleTheme">
        <v-icon>
          {{ darkMode ? 'mdi-white-balance-sunny' : 'mdi-moon-waning-crescent' }}
        </v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-account</v-icon>
      </v-btn>

    </v-app-bar>
    <v-navigation-drawer
    permanent
    floating
  >
    <template v-slot:prepend>
      <v-list-item
        lines="two"
        prepend-icon="mdi-account"
        title="Zoe Brown"
        subtitle="Status: Busy"
      ></v-list-item>
    </template>

    <v-divider></v-divider>

    <v-list density="compact" nav>
      <v-list-item to="/" prepend-icon="mdi-view-dashboard" title="Dashboard" value="home"></v-list-item>
      <!-- <v-list-item to="/tests" prepend-icon="mdi-google-analytics" title="Tests" value="account"></v-list-item>
      <v-list-item to="/tasks" prepend-icon="mdi-format-list-checks" title="Tasks" value="account"></v-list-item> -->
    </v-list>
  </v-navigation-drawer>

    <v-main>
      <router-view />
    </v-main>

  </v-app>
</template>

<script>
import { useTheme } from 'vuetify'

export default {
  setup () {
    const theme = useTheme()

    return {
      theme,
      toggleTheme: () => theme.global.name.value = theme.global.current.value.dark ? 'light' : 'dark'
    }
  }
}
</script>
