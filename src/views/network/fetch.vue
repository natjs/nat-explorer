<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="fetch")
				.header
					.dot
					text.title Simple Fetch
				text.code
					| Nat.fetch(this.url, (err, res) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| Nat.toast(JSON.stringify(res))
					| })

			.case(@click="fetchWithOpts")
				.header
					.dot
					text.title Fetch with options
				text.code
					| Nat.fetch(this.url, {
					| 	method: 'PUT',
					| 	type: 'json'
					| }, (err, res) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| Nat.toast(JSON.stringify(res))
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'fetch',

	data() {
		return {
			name: 'Fetch',
			url: 'https://suggest.taobao.com/sug?q=htc'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		fetch() {
			Nat.fetch(this.url, (err, res) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(res))
			})
		},

		fetchWithOpts() {
			Nat.fetch(this.url, {
				method: 'PUT',
				type: 'json'
			}, (err, res) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(res))
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
