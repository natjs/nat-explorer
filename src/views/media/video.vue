<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")
				
			.case(@click="play")
				.header
					.dot
					text.title Play
				text.code
					| Nat.video.play(this.path, (err) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast('started')
					| })

			.case(@click="pause")
				.header
					.dot
					text.title Pause
				text.code
					| Nat.video.pause((err) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast('paused')
					| })

			.case(@click="stop")
				.header
					.dot
					text.title Stop
				text.code
					| Nat.video.stop((err) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast('stopped')
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'video',

	data() {
		return {
			name: 'Video',
			path: 'http://cdn.instapp.io/nat/samples/video.mp4'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		play() {
			Nat.video.play(this.path, (err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('started')
			})
		},

		pause() {
			Nat.video.pause((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('paused')
			})
		},

		stop() {
			Nat.video.stop((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('stopped')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
