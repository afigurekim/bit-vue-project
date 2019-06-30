<template>
  <div>
    <Nav></Nav>
    <Calendar></Calendar>
    <Footer></Footer>
  </div>
</template>

<script>
import Nav from '@/components/common/Nav.vue'
import Calendar from '@/components/diary/Calendar.vue'
import Footer from '@/components/common/Footer.vue'
export default {
  name: 'Home',
  components: {
    Nav, Calendar, Footer
  }
}
</script>

<style>
</style>
