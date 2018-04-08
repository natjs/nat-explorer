// { "framework": "Vue"} 

/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 51);
/******/ })
/************************************************************************/
/******/ ({

/***/ 1:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
	value: true
});

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

var env = {
	isNative: (typeof window === 'undefined' ? 'undefined' : _typeof(window)) !== 'object',
	platform: weex.config.env.platform,
	deviceWidth: weex.config.env.deviceWidth,
	deviceHeight: weex.config.env.deviceHeight,
	cdnUri: 'http://cdn.instapp.io/nat/',

	get baseUrl() {
		var url = void 0;
		var bundleUrl = weex.config.bundleUrl;
		var isAndroid = bundleUrl.indexOf('file://assets/') > -1;
		var isiOS = bundleUrl.indexOf('file:///') > -1;

		if (isAndroid) {
			url = 'file://assets/dist/';
		} else if (isiOS) {
			url = bundleUrl.substring(0, bundleUrl.lastIndexOf('/') + 1);
		} else {
			var host = 'localhost:8080';
			var matches = /\/\/([^\/]+?)\//.exec(bundleUrl);
			host = matches && matches.length >= 2 ? matches[1] : host;
			url = 'http://' + host + '/dist/';
		}

		return url;
	}
};

exports.default = env;

/***/ }),

/***/ 2:
/***/ (function(module, exports) {

module.exports = {
  "bar": {
    "width": "750",
    "height": "40",
    "backgroundColor": "#ffffff"
  },
  "bar-x": {
    "width": "750",
    "height": "40",
    "backgroundColor": "#ffffff"
  }
}

/***/ }),

/***/ 3:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
	value: true
});

var _env = __webpack_require__(1);

var _env2 = _interopRequireDefault(_env);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = {
	name: 'status-bar',

	data: function data() {
		return {
			platform: _env2.default.platform,
			style: {
				backgroundColor: this.backgroundColor
			}
		};
	},


	computed: {
		isX: function isX() {
			return _env2.default.platform === 'iOS' && _env2.default.deviceWidth === 1125 && _env2.default.deviceHeight === 2436;
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
}; //
//
//
//
//
//

/***/ }),

/***/ 4:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return (_vm.show && _vm.platform === 'iOS') ? _c('div', {
    attrs: {
      "id": "status-bar"
    }
  }, [(_vm.isX) ? _c('div', {
    staticClass: ["bar-x"],
    style: _vm.style
  }) : _vm._e(), _c('div', {
    staticClass: ["bar"],
    style: _vm.style
  })]) : _vm._e()
},staticRenderFns: []}
module.exports.render._withStripped = true

/***/ }),

/***/ 51:
/***/ (function(module, exports, __webpack_require__) {

var __vue_exports__, __vue_options__
var __vue_styles__ = []

/* styles */
__vue_styles__.push(__webpack_require__(2)
)

/* script */
__vue_exports__ = __webpack_require__(3)

/* template */
var __vue_template__ = __webpack_require__(4)
__vue_options__ = __vue_exports__ = __vue_exports__ || {}
if (
  typeof __vue_exports__.default === "object" ||
  typeof __vue_exports__.default === "function"
) {
if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
__vue_options__ = __vue_exports__ = __vue_exports__.default
}
if (typeof __vue_options__ === "function") {
  __vue_options__ = __vue_options__.options
}
__vue_options__.__file = "/Users/acathur/Developments/nat/nat-explorer/src/layout/status-bar.vue"
__vue_options__.render = __vue_template__.render
__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
__vue_options__._scopeId = "data-v-1dc6752c"
__vue_options__.style = __vue_options__.style || {}
__vue_styles__.forEach(function (module) {
  for (var name in module) {
    __vue_options__.style[name] = module[name]
  }
})
if (typeof __register_static_styles__ === "function") {
  __register_static_styles__(__vue_options__._scopeId, __vue_styles__)
}

module.exports = __vue_exports__
module.exports.el = 'true'
new Vue(module.exports)


/***/ })

/******/ });