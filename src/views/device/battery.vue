<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="getBatteryStatus")
				.header
					.dot
					text.title Get battery status
				text.code
					| Nat.battery.status((err, ret) => {
					| 	Nat.toast(JSON.stringify(ret, null, 2))
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'battery',

	data() {
		return {
			name: 'Battery'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		getBatteryStatus() {
			Nat.battery.status((err, ret) => {
				Nat.toast(JSON.stringify(ret, null, 2))
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
