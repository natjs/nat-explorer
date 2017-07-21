<template lang="pug">
	.navbar
		.back(@click="pop")
			image.arrow(:src="cdnUri + 'back_arrow.png'")
			text.back-txt Back
</template>

<script>
import env from '@/utils/env'
const navigator = weex.requireModule('navigator')

export default {
	name: 'nav-bar',

	data () {
		return {
			cdnUri: env.cdnUri
		}
	},

	methods: {
		pop() {
			navigator.pop()
		}
	}
}
</script>

<style scoped>
.navbar {
	width: 750px;
	height: 88px;
	background-color: #fff;
}

.back {
	width: 186px;
	height: 88px;
	padding-left: 12px;
	padding-right: 12px;
	flex-direction: row;
	justify-content: flex-start;
	align-items: center;
}

.arrow {
	width: 40px;
	height: 40px;
	margin-right: 2px;
}

.back-txt {
	color: #3D83FB;
	font-size: 34px;
	line-height: 34px;
	padding-top: 3px;
	padding-bottom: 3px;
	height: 40px;
}
</style>
