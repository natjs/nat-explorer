<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="vibrate")
				.header
					.dot
					text.title Simple Vibrate
				text.code
					| Nat.vibrate()

			.case(@click="setVibrateDuration")
				.header
					.dot
					text.title Set vibrate duration (Android Only)
				text.code
					| Nat.vibrate(2000)

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'vibration',

	data() {
		return {
			name: 'Vibration'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		vibrate() {
			Nat.vibrate()
		},

		setVibrateDuration() {
			Nat.vibrate(2000)
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
