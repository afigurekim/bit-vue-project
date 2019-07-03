import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Nav from '@/components/common/Nav'
import Footer from '@/components/common/Footer'
import PhotoUpload from '@/components/util/PhotoUpload'
import Calendar from '@/components/diary/Calendar'
import DayNew from '@/components/diary/DayNew'
import DayEdit from '@/components/diary/DayEdit'
import DayView from '@/components/diary/DayView'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    { path: '/', name: 'Home', component: Home },
    { path: '/nav', name: 'Nav', compontnet: Nav },
    { path: '/footer', name: 'Footer', component: Footer },
    { path: '/calendar', name: 'Calendar', component: Calendar },
    { path: '/daynew/:newdate', name: 'DayNew', component: DayNew },
    { path: '/dayedit/:newdate', name: 'DayEdit', component: DayEdit },
    { path: '/dayview/:newdate', name: 'DayView', component: DayView },
    { path: '/photoupload', name: 'PhotoUpload', component: PhotoUpload }
  ]
})
