<template>
  <Line
    id="chartId"
    :options="chartOptions"
    :data="chartData"
  />
</template>

<script>
import { Line } from 'vue-chartjs'
import { Chart as ChartJS, Title, Tooltip, Legend, LineElement, CategoryScale, LinearScale, PointElement } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, LineElement, CategoryScale, LinearScale, PointElement)

export default {
  name: 'MyLineChart',
  components: { Line },
  data() {
    return {
      chartId: 'MyLineChart',
      chartData: {
        labels: [ '0', '100', '500' ],
        datasets: [ { data: [500, 200, 120] } ]
      },
      chartOptions: {
        responsive: true,
          scales: {
          y: {
            type: 'linear',
            min: 0,
            max: 1000,
            ticks: {
              stepSize: 100
            },
            scaleLabel: {
              display: true,
              labelString: 'Latency time (ms)'
            }
          },
          x: {
            type: 'linear',
            min: 0,
            max: 1000,
            ticks: {
              stepSize: 100
            },
            scaleLabel: {
              display: true,
              labelString: 'Requests per second'
            }
          }
        }
      }
    }
  }
}
</script>
