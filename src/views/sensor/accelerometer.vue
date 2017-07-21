<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="getAcceleration")
				.header
					.dot
					text.title Get acceleration
				text.code
					| Nat.accelerometer.get((err, ret) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(ret, null, 2))
					| })

			.case(@click="watchAcceleration")
				.header
					.dot
					text.title Watch acceleration
				text.code
					| Nat.accelerometer.watch((err, ret) => {
					| 	times++
					|
					| 	if (err) {
					| 		Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	this.result = 'TIMES: ' + times + '\n\nx: ' + ret.x + '\ny: ' + ret.y + '\nz: ' + ret.z
					| })

			.case(v-if="this.result")
				text.code {{ this.result }}

			.case(@click="clearWatchAcceleration")
				.header
					.dot
					text.title Clear watch acceleration
				text.code
					| Nat.accelerometer.clearWatch((err) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					| 	Nat.toast('cleared')
					| })


</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'accelerometer',

	data() {
		return {
			name: 'Accelerometer',
			result: null
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		getAcceleration() {
			Nat.accelerometer.get((err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(ret, null, 2))
			})
		},

		watchAcceleration() {
			let times = 0

			Nat.accelerometer.watch((err, ret) => {
				times++

				if (err) {
					Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					return
				}

				this.result = 'TIMES: ' + times + '\n\nx: ' + ret.x + '\ny: ' + ret.y + '\nz: ' + ret.z
			})
		},

		clearWatchAcceleration() {
			Nat.accelerometer.clearWatch((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}
				Nat.toast('cleared')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
