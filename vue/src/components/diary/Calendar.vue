<template>
  <mdb-container>
    <mdb-row>
      <mdb-col>
        <mdb-card>
          <mdb-view class="px-4 py-3 white-text" gradient="aqua">
            <h2 class="card-header-title text-left">운동 다이어리</h2>
            <p class="mb-0 text-left">다이어리를 조회할 날짜를 캘린더에서 클릭해주세요</p>
          </mdb-view>
          <mdb-card-body>
            <FullCalendar
              @dateClick="handleDateClick"
              defaultView="dayGridMonth"
              themeSystem="bootstrap"
              locale="ko"
              :plugins="calendarPlugins"
              :header="{
                left: 'prev',
                center: 'title',
                right: 'next'
              }"
              :firstDay="1"
            />
          </mdb-card-body>
        </mdb-card>
      </mdb-col>
    </mdb-row>
  </mdb-container>
</template>

<script>
import {
  mdbContainer,
  mdbRow,
  mdbCol,
  mdbCard,
  mdbCardImage,
  mdbCardHeader,
  mdbCardBody,
  mdbCardTitle,
  mdbCardText,
  mdbCardFooter,
  mdbCardUp,
  mdbCardAvatar,
  mdbCardGroup,
  mdbBtn,
  mdbView,
  mdbMask,
  mdbIcon
} from 'mdbvue'
import FullCalendar from '@fullcalendar/vue'
import dayGridPlugin from '@fullcalendar/daygrid'
import bootstrapPlugin from '@fullcalendar/bootstrap'
import interactionPlugin from '@fullcalendar/interaction'
import axios from 'axios'
export default {
  name: 'Calendar',
  components: {
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbCard,
    mdbCardImage,
    mdbCardHeader,
    mdbCardBody,
    mdbCardTitle,
    mdbCardText,
    mdbCardFooter,
    mdbCardUp,
    mdbCardAvatar,
    mdbCardGroup,
    mdbBtn,
    mdbView,
    mdbMask,
    mdbIcon,
    FullCalendar
  },
  data () {
    return {
      context: 'http://localhost:9000/diary',
      calendarPlugins: [
        dayGridPlugin,
        bootstrapPlugin,
        interactionPlugin
      ]
    }
  },
  methods: {
    handleDateClick (arg) {
      axios.get(`${this.context}/exists/${arg.dateStr}`)
        .then(res => {
          this.$router.push({
            name: `${res.data}`,
            params: {
              newdate: arg.dateStr
            }
          })
        })
        .catch(e => {
          alert('ERROR')
        })
    }
  }
}
</script>

<style>
</style>
