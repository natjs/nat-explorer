<template lang="pug">
	div.module
		text.title {{ name }}
		.cell(v-for="func in functions", @click="push(func.path)")
			text.name {{ func.name }}
			image.arrow(:src="cdnUri + 'arrow.png'")
</template>

<script>
import env from '@/utils/env'
const navigator = weex.requireModule('navigator')

export default {
	name: 'module',

	data() {
		return {
			cdnUri: env.cdnUri,
			baseUrl: env.baseUrl
		}
	},

	props: {
		name: {
			type: String,
			required: true
		},

		functions: {
			type: Array,
			required: true
		}
	},

	methods: {
		push(path) {
			navigator.push({
				url: this.baseUrl + path
			})
		}
	}
}
</script>

<style lang="less" scoped>
@import '../assets/css/base.less';

.module {
	margin-left: 48px;
	margin-right: 48px;
	margin-bottom: 48px;
}

.title {
	.c-ink;
	.fz-32;
	.bottom-line;
	font-weight: 200;
	padding-top: 8px;
	padding-bottom: 20px;
}

.cell {
	.bottom-line;
	height: 84px;
	padding-left: 24px;
	padding-right: 12px;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
}

.arrow {
	width: 15px;
	height: 27px;
}

.name {
	.c-ink;
	.fz-32;
	font-weight: 700;
}
</style>
