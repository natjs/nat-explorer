<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="mail")
				.header
					.dot
					text.title Simple Mail
				text.code
					| Nat.mail('hi@natjs.com')

			.case(@click="mailMulti")
				.header
					.dot
					text.title Multiple recipients
				text.code
					| Nat.mail(['hi@natjs.com', 'push@natjs.com'])

			.case(@click="callWithContnCb")
				.header
					.dot
					text.title Mail with content and callback
				text.code
					| Nat.mail('hi@natjs.com', {
					| 	subject: 'Subject',
					| 	body: 'content goes here.'
					| }, () => {
					| 	Nat.toast('email popup')
					| })


</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'mail',

	data() {
		return {
			name: 'Mail'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		mail() {
			Nat.mail('hi@natjs.com')
		},

		mailMulti() {
			Nat.mail(['hi@natjs.com', 'push@natjs.com'])
		},

		callWithContnCb() {
			Nat.mail('hi@natjs.com', {
				subject: 'Subject',
				body: 'content goes here.'
			}, () => {
				Nat.toast('email popup')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
