<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.button.pick(@click="pick")
				text.button-txt Pick a file

			.case(@click="upload")
				.header
					.dot
					text.title Simple Upload
				text.code
					| Nat.upload(this.url, {
					| 	path: this.filePath
					| }, (err, res) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(res))
					| })

			.case(@click="uploadWithOptsnHook")
				.header
					.dot
					text.title Upload with options and hooks
				text.code
					| Nat.upload(this.url, {
					| 	path: this.filePath,
					| 	formData: {
					| 		framework: 'nat'
					| 	},
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
	name: 'upload',

	data() {
		return {
			name: 'Upload',
			url: 'http://120.26.129.194:3600/',
			filePath: null
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		upload() {
			if (!this.filePath) {
				Nat.toast('Please pick a file first :)')
				return
			}

			Nat.upload(this.url, {
				path: this.filePath
			}, (err, res) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(res))
			})
		},

		uploadWithOptsnHook() {
			if (!this.filePath) {
				Nat.toast('Please pick a file first :)')
				return
			}

			Nat.upload(this.url, {
				path: this.filePath,
				formData: {
					framework: 'nat'
				},
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
		},

		pick() {
			Nat.image.pick()
			.then(ret => {
				this.filePath = ret.paths[0]
				Nat.toast('picked: ' + this.filePath)
			})
			.catch(err => {
				Nat.toast('[ERROR] ' + JSON.stringify(err))
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';

.pick {
	width: 296px;
	margin-top: 24px;
	margin-bottom: 48px;
}
</style>
