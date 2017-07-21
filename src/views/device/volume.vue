<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="getVolume")
				.header
					.dot
					text.title Get volume
				text.code
					| Nat.volume.get((err, ret) => {
					| 	Nat.toast(JSON.stringify(ret))
					| })

			.case(@click="setVolume")
				.header
					.dot
					text.title Set volume
				text.code
					| Nat.volume.set(1, (err, ret) => {
					| 	Nat.toast(JSON.stringify(ret))
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'volume',

	data() {
		return {
			name: 'Volume'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		getVolume() {
			Nat.volume.get((err, ret) => {
				Nat.toast(JSON.stringify(ret))
			})
		},

		setVolume() {
			Nat.volume.set(1, (err, ret) => {
				Nat.toast(JSON.stringify(ret))
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
