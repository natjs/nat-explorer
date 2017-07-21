const env = {
	isNative: typeof window !== 'object',
	platform: weex.config.env.platform,
	deviceWidth: weex.config.env.deviceWidth,
	deviceHeight: weex.config.env.deviceHeight,
	cdnUri: 'http://cdn.instapp.io/nat/',

	get baseUrl() {
		let url
		let bundleUrl = weex.config.bundleUrl
		let isAndroid = bundleUrl.indexOf('file://assets/') > -1
		let isiOS = bundleUrl.indexOf('file:///') > -1

		if (isAndroid) {
			url = 'file://assets/dist/'
		} else if (isiOS) {
			url = bundleUrl.substring(0, bundleUrl.lastIndexOf('/') + 1)
		} else {
			let host = 'localhost:8080'
			let matches = /\/\/([^\/]+?)\//.exec(bundleUrl)
			host = (matches && matches.length >= 2) ? matches[1] : host
			url = 'http://' + host + '/dist/'
		}

		return url
	}
}

export default env
