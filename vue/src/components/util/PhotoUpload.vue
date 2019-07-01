<template>
  <div id="PhotoUpload">
    <upload-image url=""></upload-image>
  </div>
</template>

<script>
import UploadImage from 'vue-upload-image'
export default {
  name: 'PhotoUpload',
  data: function () {
    return {}
  },
  methods: {
  },
  components: {
    UploadImage
  }
}
</script>

<style>

</style>
