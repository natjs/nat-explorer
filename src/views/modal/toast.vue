<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")
				
			.case(@click="toast")
				.header
					.dot
					text.title Simple Toast
				text.code
					| Nat.toast('What\'s up')

			.case(@click="toastCustom")
				.header
					.dot
					text.title Toast with custom duration and position
				text.code
					| Nat.toast({
					| 	message: 'What\'s up',
					| 	duration: 5000,
					| 	position: 'top'
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'toast',

	data() {
		return {
			name: 'Toast'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		toast() {
			Nat.toast('What\'s up')
		},

		toastCustom() {
			Nat.toast({
				message: 'What\'s up',
				duration: 5000,
				position: 'top'
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
