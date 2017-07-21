<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="call")
				.header
					.dot
					text.title Simple Call
				text.code
					| Nat.call('10010')

			.case(@click="callWithCb")
				.header
					.dot
					text.title Call with callback
				text.code
					| Nat.call('10010', () => {
					| 	Nat.toast('called')
					| })


</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'call',

	data() {
		return {
			name: 'Call'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		call() {
			Nat.call('10010')
		},

		callWithCb() {
			Nat.call('10010', () => {
				Nat.toast('called')
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
