# nat-device-screen

- [Documentation](http://natjs.com/#/#screen)
- [Github](https://github.com/natjs/weex-nat-device-screen)

## Installation
```
weexpack plugin add nat-device-screen
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
Nat.screen.info((err, ret) => {
    console.log(ret)
})

// get brightness
Nat.brightness.get((err, ret) => {
    console.log(ret)
})

// set brightness
Nat.screen.brightness.set(1)

// get orientation status
Nat.screen.orientation.status((err, ret) => {
    console.log(ret)
})

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
