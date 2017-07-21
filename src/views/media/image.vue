<template lang="pug">
	div
		status-bar
		nav-bar
		scroller.content(:show-scrollbar="false")
			title-bar(:title="name")

			.case(@click="pick")
				.header
					.dot
					text.title Pick image from gallery
				text.code
					| Nat.image.pick({
					| 	showCamera: true
					| }, (err, ret) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast(JSON.stringify(ret))
					| 	this.path = ret.paths[0]
					| })

			.case(@click="preview")
				.header
					.dot
					text.title Preview
				text.code
					| Nat.image.preview([
					| 	'http://cdn.instapp.io/nat/samples/bnw.jpeg',
					| 	'http://cdn.instapp.io/nat/samples/fibonacci.jpeg',
					| ].concat(this.path))

			.case(@click="info")
				.header
					.dot
					text.title Get image info
				text.code
					| Nat.image.info(this.path, (err, ret) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast({
					| 		message: JSON.stringify(ret, null, 2),
					| 		duration: 7000
					| 	})
					| })

			.case(@click="exif")
				.header
					.dot
					text.title Get image EXIF info
				text.code
					|
					| Nat.image.exif(this.path, (err, ret) => {
					| 	if (err) {
					| 		Nat.toast('[ERROR] ' + JSON.stringify(err))
					| 		return
					| 	}
					|
					| 	Nat.toast({
					| 		message: JSON.stringify(ret, null, 2),
					| 		duration: 7000
					| 	})
					| })

</template>

<script>
import Nat from 'natjs'
import StatusBar from '@/layout/status-bar'
import NavBar from '@/layout/nav-bar'
import TitleBar from '@/layout/title-bar'

export default {
	name: 'image',

	data() {
		return {
			name: 'Image',
			path: 'http://cdn.instapp.io/nat/samples/yellow-metal.jpg'
		}
	},

	components: {
		StatusBar,
		NavBar,
		TitleBar
	},

	methods: {
		pick() {
			Nat.image.pick({
				showCamera: true
			}, (err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast(JSON.stringify(ret))
				this.path = ret.paths[0]
			})
		},

		preview() {
			Nat.image.preview([
				'http://cdn.instapp.io/nat/samples/bnw.jpeg',
				'http://cdn.instapp.io/nat/samples/fibonacci.jpeg',
			].concat(this.path))
		},

		info() {
			Nat.image.info(this.path, (err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast({
					message: JSON.stringify(ret, null, 2),
					duration: 7000
				})
			})
		},

		exif() {
			Nat.image.exif(this.path, (err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}

				Nat.toast({
					message: JSON.stringify(ret, null, 2),
					duration: 7000
				})
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../../assets/css/case.less';
</style>
