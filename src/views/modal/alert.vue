<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="alert")
				.header
					.dot
					text.title Simple Alert
				text.code
					| Nat.alert('What\'s up')

			.case(@click="alertCustom")
				.header
					.dot
					text.title Alert with title, message and button
				text.code
					| Nat.alert({
					| 	title: 'Title',
					| 	message: 'This is an alert dialog',
					| 	okButton: 'I know'
					| })

			.case(@click="alertWithCb")
				.header
					.dot
					text.title Alert with callback
				text.code
					| Nat.alert('This is an alert with callback', () => {
					| 	Nat.toast('alerted.')
					| })


</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'alert',

	data() {
		return {
			name: 'Alert'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		alert() {
			Nat.alert('What\'s up')
		},

		alertCustom() {
			Nat.alert({
				title: 'Title',
				message: 'This is an alert dialog',
				okButton: 'I know'
			})
		},

		alertWithCb() {
			Nat.alert('This is an alert with callback', () => {
				Nat.toast('alerted.')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
