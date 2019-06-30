<template>
  <div id="PhotoUpload">
    <file-pond
      name="test"
      ref="pond"
      label-idle="사진을 여기에 드래그 해주세요 (jpg, png)"
      allow-multiple="false"
      accepted-file-types="image/jpeg, image/png"
      server="/api"
      image-preview-height="400"
      image-crop-aspect-ratio="3:4"
      image-resize-target-width="300"
      image-resize-target-height="400"
      v-bind:files="myFiles"
      v-on:init="handleFilePondInit"/>
  </div>
</template>

<script>
import vueFilePond from 'vue-filepond'
import 'filepond/dist/filepond.min.css'
import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css'
import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type'
import FilePondPluginImagePreview from 'filepond-plugin-image-preview'
import FilePondPluginImageCrop from 'filepond-plugin-image-crop'
import FilePondPluginImageResize from 'filepond-plugin-image-resize'
const FilePond = vueFilePond(FilePondPluginFileValidateType, FilePondPluginImagePreview, FilePondPluginImageCrop, FilePondPluginImageResize)
export default {
  name: 'PhotoUpload',
  data: function () {
    return {}
  },
  methods: {
    handleFilePondInit: function () {
      console.log('FilePond has initialized')
    }
  },
  components: {
    FilePond
  }
}
</script>

<style>

</style>
