<template lang="pug">
	div
		status-bar
		list(:show-scrollbar="false")
			cell
				image.logo(:src="cdnUri + 'logo.png'")
				div.app-name
					text.bold Nat
					text.light Explorer
			cell(v-for="item in modules")
				module(:name="item.name", :functions="item.functions")

</template>

<script>
import env from '@/utils/env'
import modules from '@/ini/modules'
import StatusBar from '@/layout/status-bar'
import Module from '@/components/module'

export default {
	data() {
		return {
			cdnUri: env.cdnUri,
			baseUrl: env.baseUrl,
			modules
		}
	},

	components: {
		StatusBar,
		Module
	}
}
</script>

<style lang="less" scoped>
@import './assets/css/base.less';

.logo {
	width: 82px;
	height: 84px;
	margin-top: 32px;
	margin-left: 48px;
	margin-bottom: 18px;
}

.app-name {
	height: 100px;
	margin-left: 48px;
	margin-right: 48px;
	margin-bottom: 48px;
	flex-direction: row;
	align-items: center;
}

.bold {
	.c-ink;
	.fz-72;
	font-weight: 700;
}

.light {
	.c-ink;
	.fz-72;
	font-weight: 200;
	margin-left: 24px;
}

</style>
