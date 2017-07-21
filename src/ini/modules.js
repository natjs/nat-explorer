const modules = [{
	name: 'Communication',
	functions: [{
		name: 'Call',
		path: 'views/communication/call.js'
	}, {
		name: 'Mail',
		path: 'views/communication/mail.js'
	}, {
		name: 'Sms',
		path: 'views/communication/sms.js'
	}]
}, {
	name: 'Media',
	functions: [{
		name: 'Image',
		path: 'views/media/image.js'
	}, {
		name: 'Audio',
		path: 'views/media/audio.js'
	}, {
		name: 'Video',
		path: 'views/media/video.js'
	}]
}, {
	name: 'Camera',
	functions: [{
		name: 'Capture Image',
		path: 'views/camera/captureImage.js'
	}, {
		name: 'Capture Video',
		path: 'views/camera/captureVideo.js'
	}]
}, {
	name: 'Recorder',
	functions: [{
		name: 'Recorder',
		path: 'views/recorder/recorder.js'
	}]
}, {
	name: 'Modal',
	functions: [{
		name: 'Alert',
		path: 'views/modal/alert.js'
	}, {
		name: 'Confirm',
		path: 'views/modal/confirm.js'
	}, {
		name: 'Prompt',
		path: 'views/modal/prompt.js'
	}, {
		name: 'Toast',
		path: 'views/modal/toast.js'
	}]
}, {
	name: 'Network',
	functions: [{
		name: 'Fetch',
		path: 'views/network/fetch.js',
		hints: 'stream'
	}, {
		name: 'download',
		path: 'views/network/download.js',
		hints: 'transfer'
	}, {
		name: 'upload',
		path: 'views/network/upload.js',
		hints: 'transfer'
	}]
}, {
	name: 'Geolocation',
	functions: [{
		name: 'Geolocation',
		path: 'views/geolocation/geolocation.js',
		hints: 'geo'
	}]
}, {
	name: 'Sensor',
	functions: [{
		name: 'Accelerometer',
		path: 'views/sensor/accelerometer.js'
	}, {
		name: 'Compass',
		path: 'views/sensor/compass.js'
	}]
}, {
	name: 'Device',
	functions: [{
		name: 'Info',
		path: 'views/device/info.js'
	}, {
		name: 'Network',
		path: 'views/device/network.js'
	}, {
		name: 'Vibration',
		path: 'views/device/vibration.js'
	}, {
		name: 'Screen',
		path: 'views/device/screen.js'
	}, {
		name: 'Volume',
		path: 'views/device/volume.js'
	}, {
		name: 'Battery',
		path: 'views/device/battery.js'
	}]
}]

export default modules
