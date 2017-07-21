<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="prompt")
				.header
					.dot
					text.title Simple Prompt
				text.code
					| Nat.prompt('This is a prompt dialog')

			.case(@click="promptCustom")
				.header
					.dot
					text.title Custom Prompt
				text.code
					| Nat.prompt({
					| 	title: 'Title',
					| 	message: 'This is a prompt dialog',
					| 	text: 'Set default text here',
					| 	okButton: 'I know',
					| 	cancelButton: 'Ignore'
					| })

			.case(@click="promptWithCb")
				.header
					.dot
					text.title Prompt with callback
				text.code
					| Nat.prompt('This is a prompt dialog with callback', (err, ret) => {
					| 	Nat.toast((ret.result) ? ret.data : 'canceled')
					| })


</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'prompt',

	data() {
		return {
			name: 'Prompt'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		prompt() {
			Nat.prompt('This is a prompt dialog')
		},

		promptCustom() {
			Nat.prompt({
				title: 'Title',
				message: 'This is a prompt dialog',
				text: 'Set default text here',
				okButton: 'I know',
				cancelButton: 'Ignore'
			})
		},

		promptWithCb() {
			Nat.prompt('This is a prompt dialog with callback', (err, ret) => {
				Nat.toast((ret.result) ? ret.data : 'canceled')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
