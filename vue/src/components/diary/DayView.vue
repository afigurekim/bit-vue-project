<template>
  <div>
    <Nav></Nav>
    <mdb-container>
      <mdb-card>
        <mdb-view class="px-4 py-3 white-text" gradient="aqua">
          <h2 class="card-header-title text-left">다이어리 보기</h2>
          <p class="mb-0 text-left">{{ `${year}년 ${month}월 ${date}일` }}</p>
        </mdb-view>
        <mdb-card-body>
          <mdb-row>
              <mdb-col col="12" sm="6" lg="4">
                <img class="img-fluid rounded" alt="사용자 사진" :src="photo" />
              </mdb-col>
              <mdb-col col="12" sm="6" lg="8" class="text-left" disabled>
                  <section class="input">
                    <mdb-input class="mb-2 mt-0" disabled v-model="diaryDays">
                      <span class="input-group-text md-addon" slot="prepend">운동 경과일</span>
                      <span class="input-group-text md-addon" slot="append">일</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled v-model="diaryGoal">
                      <span class="input-group-text md-addon" slot="prepend">목표 달성률</span>
                      <span class="input-group-text md-addon" slot="append">%</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled v-model="diaryFat">
                      <span class="input-group-text md-addon" slot="prepend">체지방률</span>
                      <span class="input-group-text md-addon" slot="append">%</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled v-model="diaryWater">
                      <span class="input-group-text md-addon" slot="prepend">체수분률</span>
                      <span class="input-group-text md-addon" slot="append">%</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled v-model="diaryMuscle">
                      <span class="input-group-text md-addon" slot="prepend">근육량</span>
                      <span class="input-group-text md-addon" slot="append">kg</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled v-model="diarySkeletal">
                      <span class="input-group-text md-addon" slot="prepend">골격근량</span>
                      <span class="input-group-text md-addon" slot="append">kg</span>
                    </mdb-input>
                    <mdb-input type="textarea" label="소감" v-model="diaryComment" readonly :rows="10" />
                    <div class="text-right">
                      <mdb-btn color="default" @click="handleEditClick">수정</mdb-btn>
                      <mdb-btn color="danger" @click="handleDeleteClick">삭제</mdb-btn>
                      <mdb-btn color="primary" @click="handleReturnClick">돌아가기</mdb-btn>
                    </div>
                  </section>
              </mdb-col>
          </mdb-row>
        </mdb-card-body>
      </mdb-card>
    </mdb-container>
    <Footer></Footer>
  </div>
</template>

<script>
import Nav from '@/components/common/Nav.vue'
import Footer from '@/components/common/Footer.vue'
import axios from 'axios'
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
  mdbIcon,
  mdbInput,
  mdbNumericInput
} from 'mdbvue'

export default {
  name: 'DayView',
  components: {
    Nav,
    Footer,
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
    mdbInput,
    mdbNumericInput
  },
  data () {
    return {
      context: 'http://localhost:9000/diary',
      newdate: this.$route.params.newdate,
      datearr: '',
      year: '',
      month: '',
      date: '',
      diaryDate: '',
      diaryDays: '',
      diaryGoal: '',
      diaryFat: '',
      diaryWater: '',
      diaryMuscle: '',
      diarySkeletal: '',
      diaryComment: '',
      photo: require('@/assets/diary_01.jpg')
    }
  },
  methods: {
    dateSplit () {
      this.datearr = this.newdate.split('-')
      this.year = this.datearr[0]
      this.month = this.datearr[1]
      this.date = this.datearr[2]
    },
    read () {
      axios.get(`${this.context}/find/${this.newdate}`)
        .then(res => {
          this.diaryDate = `${res.data.diaryDate}`
          this.diaryDays = `${res.data.diaryDays}`
          this.diaryGoal = `${res.data.diaryGoal}`
          this.diaryFat = `${res.data.diaryFat}`
          this.diaryWater = `${res.data.diaryWater}`
          this.diaryMuscle = `${res.data.diaryMuscle}`
          this.diarySkeletal = `${res.data.diarySkeletal}`
          this.diaryComment = `${res.data.diaryComment}`
        })
        .catch(e => {
          alert('ERROR')
          this.$router.push({
            name: 'Home'
          })
        })
    },
    handleEditClick () {
      this.$router.push({
        name: 'DayEdit',
        params: {
          newdate: this.newdate
        }
      })
    },
    handleDeleteClick () {
      if (confirm(`${this.newdate} 일기를 삭제하시겠습니까?\n(확인: 삭제, 취소: 돌아가기)`)) {
        axios.delete(`${this.context}/delete/${this.newdate}`)
          .then(() => {
            alert(`${this.newdate} 일기가 삭제되었습니다.`)
            this.$router.push({
              name: 'Home'
            })
          })
          .catch(e => {
            alert('ERROR')
            this.$router.push({
              name: 'Home'
            })
          })
      }
    },
    handleReturnClick () {
      this.$router.push({
        name: 'Home'
      })
    }
  },
  beforeMount () {
    this.dateSplit()
    this.read()
  }
}
</script>

<style scoped>
section.preview {
  border: 1px solid #e0e0e0;
  padding: 15px;
}
</style>
