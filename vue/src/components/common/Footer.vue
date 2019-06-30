<template>
  <mdb-footer color="elegant-color-dark" class="font-small pt-4 mt-4">
    <mdb-container class="text-left">
      <mdb-row>
        <mdb-col sm="6">
          <h5 class="title">URCoach</h5>
          <p></p>
        </mdb-col>
        <mdb-col sm="6">
          <h5 class="title">운동 다이어리</h5>
          <ul>
            <li class="list-unstyled">
              <a href="/">다이어리</a>
            </li>
            <li class="list-unstyled">
              <a href="/daynew">작성</a>
            </li>
            <li class="list-unstyled">
              <a href="/dayview">조회</a>
            </li>
            <li class="list-unstyled">
              <a href="/dayedit">수정</a>
            </li>
          </ul>
        </mdb-col>
      </mdb-row>
    </mdb-container>
    <div class="footer-copyright text-right py-3">
      <mdb-container fluid>
        &copy; {{ (new Date()).getFullYear() }} <a href="https://github.com/afigurekim/">afigurekim</a>
      </mdb-container>
    </div>
  </mdb-footer>
</template>

<script>
import { mdbFooter, mdbContainer, mdbRow, mdbCol } from 'mdbvue'
export default {
  name: 'Footer',
  components: { mdbFooter, mdbContainer, mdbRow, mdbCol }
}
</script>

<style scoped>
</style>
