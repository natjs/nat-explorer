# nat-device-info

- [Documentation](http://natjs.com/#/#device)
- [Github](https://github.com/natjs/weex-nat-device-info)

## Installation
```
weexpack plugin add nat-device-info
```

```
npm install natjs --save
```

## Usage

Use in weex file (.we)

```html
<script>
import 'Nat' from 'natjs'

// get info
Nat.device.info((err, ret) => {
    console.log(ret)
})

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
