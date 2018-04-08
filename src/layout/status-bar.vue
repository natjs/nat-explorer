<template lang="pug">
	#status-bar(v-if="show && platform === 'iOS'")
		.bar-x(:style="style" v-if="isX")
		.bar(:style="style")
</template>

<script>
import env from '@/utils/env'

export default {
	name: 'status-bar',

	data() {
		return {
			platform: env.platform,
			style: {
				backgroundColor: this.backgroundColor
			}
		}
	},

	computed: {
		isX() {
			return env.platform === 'iOS' && env.deviceWidth === 1125 && env.deviceHeight === 2436
		}
	},

	props: {
		backgroundColor: {
			type: String,
			default: '#fff'
		},
		show: {
			type: Boolean,
			default: true
		}
	}
}
</script>

<style scoped>
.bar {
	width: 750px;
	height: 40px;
	background-color: #fff;
}
.bar-x {
	width: 750px;
	height: 40px;
	background-color: #fff;
}
</style>
