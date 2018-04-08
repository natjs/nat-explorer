<template lang="pug">
	div
		status-bar(:show="false")
		list(:show-scrollbar="false")
			cell
				image.logo(:src="cdnUri + 'logo.png'")
				div.app-name
					text.bold Nat
					text.light Explorer
			cell(v-for="(item, i) in modules" :key="i")
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
	height: 82px;
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
	color: @ink;
	font-size: @font-size-xl;
	font-weight: 700;
}

.light {
	color: @ink;
	font-size: @font-size-xl;
	font-weight: 200;
	margin-left: 24px;
}

</style>
