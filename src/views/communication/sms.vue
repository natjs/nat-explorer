<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="sms")
				.header
					.dot
					text.title Simple Sms
				text.code
					| Nat.sms('10010')

			.case(@click="smsMulti")
				.header
					.dot
					text.title Multiple recipients
				text.code
					| Nat.sms(['10010', '10086'])

			.case(@click="smsWithContnCb")
				.header
					.dot
					text.title Sms with content and callback
				text.code
					| Nat.sms('10010', 'message goes here.', () => {
					| 	Nat.toast('sms popup')
					| })


</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'sms',

	data() {
		return {
			name: 'SMS'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		sms() {
			Nat.sms('10010')
		},

		smsMulti() {
			Nat.sms(['10010', '10086'])
		},

		smsWithContnCb() {
			Nat.sms('10010', 'message goes here.', () => {
				Nat.toast('sms popup')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
