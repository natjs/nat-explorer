<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")
				
			.case(@click="download")
				.header
					.dot
					text.title Simple Download
				text.code
					| Nat.download(this.url, (err, res) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(res))
					| })

			.case(@click="downloadWithOptsnHook")
				.header
					.dot
					text.title Download with options and hooks
				text.code
					| Nat.download(this.url, {
					| 	headers: {
					| 		'nat-version': '0.0.1'
					| 	}
					| }, {
					| 	onProgress: (p) => {
					| 		Nat.toast('Progressing: ' + p)
					| 	}
					| }, (err, res) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(res))
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'download',

	data() {
		return {
			name: 'Download',
			url: 'http://cdn.instapp.io/nat/samples/audio.mp3'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		download() {
			Nat.download(this.url, (err, res) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(res))
			})
		},

		downloadWithOptsnHook() {
			Nat.download(this.url, {
				headers: {
					'nat-version': '0.0.1'
				}
			}, {
				onProgress: (p) => {
					Nat.toast('Progressing: ' + p)
				}
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
