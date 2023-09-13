<template>
  <v-card title="Latency" >
    <BarChart />
  </v-card>
</template>

<script>
import BarChart from './LineChart.vue'
export default {
  components: {BarChart}
}
</script>
