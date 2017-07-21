<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="captureImage")
				.header
					.dot
					text.title Take a photo
				text.code
					| Nat.camera.captureImage({}, (err, ret) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(ret, null, 2))
					| 	this.path = ret.path
					| })

			.button.preview(@click="preview")
				text.button-txt Preview

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'captureImage',

	data() {
		return {
			name: 'Capture Image',
			path: null
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		captureImage() {
			Nat.camera.captureImage({}, (err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(ret, null, 2))
				this.path = ret.path
			})
		},

		preview() {
			if (!this.path) {
				Nat.toast('Please take your photo first :)')
				return
			}

			Nat.image.preview(this.path)
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';

.preview {
	width: 256px;
}
</style>
