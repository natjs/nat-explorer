<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="getHeading")
				.header
					.dot
					text.title Get compass heading
				text.code
					| Nat.compass.get((err, ret) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(ret, null, 2))
					| })

			.case(@click="watchHeading")
				.header
					.dot
					text.title Watch compass heading
				text.code
					| Nat.compass.watch((err, ret) => {
					| 	times++
					|
					| 	if (err) {
					| 		Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	this.result = 'TIMES: ' + times + '\n\nHeading: ' + ret.heading
					| })

			.case(v-if="this.result")
				text.code {{ this.result }}

			.case(@click="clearWatchHeading")
				.header
					.dot
					text.title Clear watch compass heading
				text.code
					| Nat.compass.clearWatch((err) => {
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
	name: 'compass',

	data() {
		return {
			name: 'Compass',
			result: null
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		getHeading() {
			Nat.compass.get((err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(ret, null, 2))
			})
		},

		watchHeading() {
			let times = 0

			Nat.compass.watch((err, ret) => {
				times++

				if (err) {
					Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					return
				}

				this.result = 'TIMES: ' + times + '\n\nHeading: ' + ret.heading
			})
		},

		clearWatchHeading() {
			Nat.compass.clearWatch((err) => {
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
