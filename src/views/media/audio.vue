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
					| Nat.audio.play(this.path, (err) => {
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
					| Nat.audio.pause((err) => {
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
					| Nat.audio.stop((err) => {
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
	name: 'audio',

	data() {
		return {
			name: 'Audio',
			path: 'http://cdn.instapp.io/nat/samples/audio.mp3'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		play() {
			Nat.audio.play(this.path, (err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('started')
			})
		},

		pause() {
			Nat.audio.pause((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast('paused')
			})
		},

		stop() {
			Nat.audio.stop((err) => {
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
