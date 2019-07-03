<template>
  <picture-input
    ref="pictureInput"
    width="300"
    height="400"
    margin="0"
    radius="5"
    accept="image/jpeg,image/png"
    size="10"
    button-class="btn"
    :custom-strings="{
      upload: '사진 업로드를<br>지원하지 않는<br>기기입니다',
      drag: '사진을 여기에<br>드래그 해주세요<br><small>(3MB 이내 .jpg, .png)</small>'
    }"
    @change="onChange">
  </picture-input>
</template>

<script>
import PictureInput from 'vue-picture-input'
export default {
  name: 'PhotoUpload',
  data () {
    return {
    }
  },
  components: {
    PictureInput
  },
  methods: {
    onChange (image) {
      console.log('New picture selected!')
      if (image) {
        console.log('Picture loaded.')
        this.image = image
      } else {
        console.log('FileReader API not supported: use the <form>, Luke!')
      }
    }
  }
}
</script>

<style>

</style>
