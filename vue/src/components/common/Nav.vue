<template>
  <mdb-navbar position="top" dark color="elegant-color-dark">
    <mdb-navbar-brand>
      <router-link to="/">
        <img height="30" alt="URCoach" :src="logo" />
      </router-link>
    </mdb-navbar-brand>
    <mdb-navbar-toggler>
      <mdb-navbar-nav>
        <mdb-nav-item href="/" waves-fixed class="active">다이어리</mdb-nav-item>
        <mdb-nav-item href="/daynew" waves-fixed>작성</mdb-nav-item>
        <mdb-nav-item href="/dayview" waves-fixed>조회</mdb-nav-item>
        <mdb-nav-item href="/dayedit" waves-fixed>수정</mdb-nav-item>
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>
</template>

<script>
import { mdbNavbar, mdbNavItem, mdbNavbarNav, mdbNavbarToggler, mdbNavbarBrand } from 'mdbvue'
export default {
  name: 'Nav',
  components: { mdbNavbar, mdbNavItem, mdbNavbarNav, mdbNavbarToggler, mdbNavbarBrand },
  data () {
    return { logo: require('@/assets/urcoach.png') }
  }
}
</script>

<style>
</style>
