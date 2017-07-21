<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="getLocation")
				.header
					.dot
					text.title Get location
				text.code
					| Nat.geolocation.get((err, ret) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(ret, null, 2))
					| })

			.case(@click="watchLocation")
				.header
					.dot
					text.title Watch location
				text.code
					| Nat.geolocation.watch((err, ret) => {
					| 	times++
					|
					| 	if (err) {
					| 		Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	this.result = JSON.stringify(ret, null, 2)
					| })

			.case(v-if="this.result")
				text.code {{ this.result }}

			.case(@click="clearWatchLocation")
				.header
					.dot
					text.title Clear watch location
				text.code
					| Nat.geolocation.clearWatch((err) => {
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
	name: 'geolocation',

	data() {
		return {
			name: 'Geolocation',
			result: null
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		getLocation() {
			Nat.geolocation.get((err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(ret, null, 2))
			})
		},

		watchLocation() {
			let times = 0

			Nat.geolocation.watch((err, ret) => {
				times++

				if (err) {
					Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					return
				}

				this.result = JSON.stringify(ret, null, 2)
			})
		},

		clearWatchLocation() {
			Nat.geolocation.clearWatch((err) => {
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
