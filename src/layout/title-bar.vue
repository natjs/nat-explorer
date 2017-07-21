<template lang="pug">
	text.title {{ title }}
</template>

<style scoped>
.title {
	font-size: 72px;
	font-weight: bold;
	line-height: 72px;
	height: 100px;
	padding-top: 14px;
	padding-bottom: 14px;
	margin-top: 8px;
	margin-bottom: 32px;
}
</style>

<script>
export default {
	name: 'title-bar',

	data() {
		return {
		}
	},

	props: {
		title: {
			type: String,
			required: true
		}
	}
}
</script>
