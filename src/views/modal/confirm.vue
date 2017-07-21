<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="confirm")
				.header
					.dot
					text.title Simple Confirm
				text.code
					| Nat.confirm('This is a confirm dialog')

			.case(@click="confirmCustom")
				.header
					.dot
					text.title Confirm with title, message and buttons
				text.code
					| Nat.confirm({
					| 	title: 'Title',
					| 	message: 'This is a confirm dialog',
					| 	okButton: 'I know',
					| 	cancelButton: 'Ignore'
					| })

			.case(@click="confirmWithCb")
				.header
					.dot
					text.title Confirm with callback
				text.code
					| Nat.confirm('This is a confirm dialog with callback', (err, ret) => {
					| 	Nat.toast((ret) ? 'confirmed' : 'canceled')
					| })


</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'confirm',

	data() {
		return {
			name: 'Confirm'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		confirm() {
			Nat.confirm('This is a confirm dialog')
		},

		confirmCustom() {
			Nat.confirm({
				title: 'Title',
				message: 'This is a confirm dialog',
				okButton: 'I know',
				cancelButton: 'Ignore'
			})
		},

		confirmWithCb() {
			Nat.confirm('This is a confirm dialog with callback', (err, ret) => {
				Nat.toast((ret) ? 'confirmed' : 'canceled')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
