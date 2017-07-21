# nat-camera

- [Documentation](http://natjs.com/#/#camera)
- [Github](https://github.com/natjs/weex-nat-camera)

## Installation
```
weexpack plugin add nat-camera
```

```
npm install natjs --save
```

## Usage

Use in weex file (.we)

```html
<script>
import 'Nat' from 'natjs'

// take a photo
Nat.camera.captureImage((err, ret) => {
    console.log('Path: ', ret.path)
})

// record a video
Nat.camera.captureVideo((err, ret) => {
    console.log('Path: ', ret.path)
})

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
