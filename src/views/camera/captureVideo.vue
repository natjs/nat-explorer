<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="captureVideo")
				.header
					.dot
					text.title Record a video
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
	name: 'captureVideo',

	data() {
		return {
			name: 'Capture Video',
			path: null
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		captureVideo() {
			Nat.camera.captureVideo({}, (err, ret) => {
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
				Nat.toast('Please take your video first :)')
				return
			}

			Nat.video.play(this.path)
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
