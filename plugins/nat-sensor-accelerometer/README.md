# nat-sensor-accelerometer

- [Documentation](http://natjs.com/#/#accelerometer)
- [Github](https://github.com/natjs/weex-nat-sensor-accelerometer)

## Installation
```
weexpack plugin add nat-sensor-accelerometer
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
Nat.accelerometer.get((err, ret) => {
    console.log(ret)
})

// watch
Nat.accelerometer.watch((err, ret) => {
    console.log(ret)
})

// clearWatch
Nat.accelerometer.clearWatch()

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
