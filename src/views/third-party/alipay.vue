<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="pay")
				.header
					.dot
					text.title Pay
				text.code
					| Nat.alipay.pay({
					|     info: {},
					|     scheme: ''
					| }, (err, ret) => {
					|     if (err) {
					|         Nat.toast('[ERROR] ' + JSON.stringify(err))
					|         return
					|     }
					|     
					|     Nat.toast(JSON.stringify(ret))
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'alipay',

	data() {
		return {
			name: 'Alipay'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		pay() {
			Nat.alipay.pay({
				info: {},
				scheme: ''
			}, (err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(ret))
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
