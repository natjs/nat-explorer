<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="getScreenInfo")
				.header
					.dot
					text.title Get screen info
				text.code
					| Nat.screen.info((err, ret) => {
					| 	Nat.toast(JSON.stringify(ret, null, 2))
					| })

			.case(@click="getBrightness")
				.header
					.dot
					text.title Get screen brightness
				text.code
					| Nat.screen.brightness.get((err, ret) => {
					| 	Nat.toast(ret)
					| })

			.case(@click="setBrightness")
				.header
					.dot
					text.title Set screen brightness
				text.code
					| Nat.screen.brightness.set(1, (err, ret) => {
					| 	Nat.toast(ret)
					| })

			.case(@click="getOrientation")
				.header
					.dot
					text.title Get screen orientation status
				text.code
					| Nat.screen.orientation.status((err, ret) => {
					| 	Nat.toast(ret)
					| })

			//- .case(@click="lockScreenOrientation")
			//- 	.header
			//- 		.dot
			//- 		text.title Lock screen orientation
			//- 	text.code
			//- 		| Nat.screen.orientation.lock((err, ret) => {
			//- 		| 	Nat.toast(ret)
			//- 		| })

			//- .case(@click="unlockScreenOrientation")
			//- 	.header
			//- 		.dot
			//- 		text.title Unlock screen orientation
			//- 	text.code
			//- 		| Nat.screen.orientation.unlock((err, ret) => {
			//- 		| 	Nat.toast(ret)
			//- 		| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'screen',

	data() {
		return {
			name: 'Screen'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		getScreenInfo() {
			Nat.screen.info((err, ret) => {
				Nat.toast(JSON.stringify(ret, null, 2))
			})
		},

		getBrightness() {
			Nat.screen.brightness.get((err, ret) => {
				Nat.toast(JSON.stringify(ret))
			})
		},

		setBrightness() {
			Nat.screen.brightness.set(1, (err, ret) => {
				Nat.toast(JSON.stringify(ret))
			})
		},

		getOrientation() {
			Nat.screen.orientation.status((err, ret) => {
				Nat.toast(JSON.stringify(ret))
			})
		},

		lockScreenOrientation() {
			Nat.screen.orientation.lock((err, ret) => {
				Nat.toast(JSON.stringify(ret))
			})
		},

		unlockScreenOrientation() {
			Nat.screen.orientation.unlock((err, ret) => {
				Nat.toast(JSON.stringify(ret))
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
