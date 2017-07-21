<template lang="pug">
	.bar(:style="style" v-if="platform === 'iOS'")
</template>

<script>
import env from '@/utils/env'

export default {
	name: 'status-bar',

	data () {
		return {
			platform: env.platform,
			style: {
				backgroundColor: this.backgroundColor
			}
		}
	},

	props: {
		backgroundColor: {
			type: String,
			default: '#fff'
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
</style>
