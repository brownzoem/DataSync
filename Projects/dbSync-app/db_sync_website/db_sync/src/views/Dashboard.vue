<template>
  <v-container>
    <!-- <v-row align="center" justify="center">
      <v-col>
        <Status/>
      </v-col>
    </v-row> -->
    <v-row>
      <v-col>
        <v-card title="Min Latency">
          <v-card-text>{{min_val}}</v-card-text>
        </v-card>
      </v-col>
      <v-col>
        <v-card title="Max Latency">
          <v-card-text>{{max_val}}</v-card-text>
        </v-card>
      </v-col>
      <v-col>
        <v-card title="Avgerage Latency">
          <v-card-text>{{avg_val}}</v-card-text>
        </v-card>
      </v-col>
      <v-col>
        <v-card title="90th Percentile Latency">
          <v-card-text>{{perc}}</v-card-text>
        </v-card>
      </v-col>
    </v-row>
    <!-- <v-row>
      <v-col>
        <Latency/>
      </v-col>
    </v-row> -->
    <v-row>
      <v-col>
        <PGTable/>
      </v-col>
    </v-row>
    <!-- <v-row>
      <v-col>
        <Performance/>
      </v-col>
    </v-row> -->
    <!-- <v-row>
      <v-col>
        <CBLogs/>
      </v-col>
      <v-col>
        <PGLogs/>
      </v-col>
    </v-row> -->
  </v-container>
</template>

<script>
import Status from '../components/Status.vue'
import Latency from '../components/Latency.vue'
import Performance from '@/components/Performance.vue';
import CBLogs from '@/components/CBLogs.vue';
import PGLogs from '@/components/PGLogs.vue';
import PGTable from '@/components/PGTable.vue';
import CustomerService from "@/clients/customerdb.js"

export default {
  data: () => {
    return {
      min_val: null,
      max_val: null,
      avg_val: null,
      perc: null
    }
  },
  methods: {
     async loadItems() {
      this.loading = true
      await CustomerService.getLatency().then((response) => {
        this.min_val = response.data[0][0]
        this.avg_val = response.data[0][1]
        this.max_val = response.data[0][2]
        this.perc = response.data[0][3]

      })
    }
  },
  created() {
    this.loadItems()
  },
  components: {Status, Latency, Performance, CBLogs, PGLogs, PGTable},
}
</script>
