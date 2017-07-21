<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="start")
				.header
					.dot
					text.title Start record
				text.code
					| Nat.recorder.start({}, (err) => {
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
					| Nat.recorder.pause((err) => {
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
					| Nat.recorder.stop((err) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast('stopped, path: ' + ret.path)
					| })

			.button.play(@click="play")
				text.button-txt Play

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'recorder',

	data() {
		return {
			name: 'Recorder',
			path: null
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		start() {
			Nat.recorder.start({}, (err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('started')
			})
		},

		pause() {
			Nat.recorder.pause((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('paused')
			})
		},

		stop() {
			Nat.recorder.stop((err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('stopped, path: ' + ret.path)
				this.path = ret.path
			})
		},

		play() {
			if (!this.path) {
				Nat.toast('Please record your audio first :)')
				return
			}

			Nat.audio.play(this.path)
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';

.play {
	width: 256px;
	margin-bottom: 96px;
}
</style>
