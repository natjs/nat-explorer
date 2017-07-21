# nat-device-volume

- [Documentation](http://natjs.com/#/#volume)
- [Github](https://github.com/natjs/weex-nat-device-volume)

## Installation
```
weexpack plugin add nat-device-volume
```

```
npm install natjs --save
```

## Usage

Use in weex file (.we)

```html
<script>
import 'Nat' from 'natjs'

// get
Nat.volume.get((err, ret) => {
    console.log(ret)
})

// set
Nat.video.set(0.5)

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
