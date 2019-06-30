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
                    <mdb-input class="mb-2 mt-0" disabled value="20">
                      <span class="input-group-text md-addon" slot="prepend">운동 경과일</span>
                      <span class="input-group-text md-addon" slot="append">일</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled value="30">
                      <span class="input-group-text md-addon" slot="prepend">목표 달성률</span>
                      <span class="input-group-text md-addon" slot="append">%</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled value="20">
                      <span class="input-group-text md-addon" slot="prepend">체지방률</span>
                      <span class="input-group-text md-addon" slot="append">%</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled value="60">
                      <span class="input-group-text md-addon" slot="prepend">체수분률</span>
                      <span class="input-group-text md-addon" slot="append">%</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled value="19.5">
                      <span class="input-group-text md-addon" slot="prepend">근육량</span>
                      <span class="input-group-text md-addon" slot="append">kg</span>
                    </mdb-input>
                    <mdb-input class="mb-2 mt-0" disabled value="22.5">
                      <span class="input-group-text md-addon" slot="prepend">골격근량</span>
                      <span class="input-group-text md-addon" slot="append">kg</span>
                    </mdb-input>
                    <mdb-input type="textarea" label="소감" value="얼음이 있을 뿐이다 그들에게 생명을 불어 넣는 것은 따뜻한 봄바람이다 풀밭에 속잎나고 가지에 싹이 트고 꽃 피고 새 우는 봄날의 천지는 얼마나 기쁘며 얼마나 아름다우냐? 이것을 얼음 속에서 불러 내는 것이 따뜻한" disabled :rows="5" />
                    <div class="text-right">
                      <mdb-btn color="default">수정</mdb-btn>
                      <mdb-btn color="danger">삭제</mdb-btn>
                      <mdb-btn color="primary">돌아가기</mdb-btn>
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
import PhotoUpload from '@/components/util/PhotoUpload.vue'
import { mdbContainer, mdbRow, mdbCol, mdbCard, mdbCardImage, mdbCardHeader, mdbCardBody, mdbCardTitle, mdbCardText, mdbCardFooter, mdbCardUp, mdbCardAvatar, mdbCardGroup, mdbBtn, mdbView, mdbMask, mdbIcon, mdbInput, mdbNumericInput } from 'mdbvue'

export default {
  name: 'DayView',
  components: { Nav, Footer, mdbContainer, mdbRow, mdbCol, mdbCard, mdbCardImage, mdbCardHeader, mdbCardBody, mdbCardTitle, mdbCardText, mdbCardFooter, mdbCardUp, mdbCardAvatar, mdbCardGroup, mdbBtn, mdbView, mdbMask, mdbIcon, mdbInput, mdbNumericInput, PhotoUpload },
  computed: {
    year () { return (new Date()).getUTCFullYear() },
    month () { return (new Date()).getUTCMonth() + 1 },
    date () { return (new Date()).getUTCDate() }
  },
  data () {
    return { photo: require('@/assets/diary_01.jpg') }
  }
}
</script>

<style scoped>
section.preview {
  border: 1px solid #e0e0e0;
  padding: 15px;
}
</style>
