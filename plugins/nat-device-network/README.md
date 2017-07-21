# nat-device-network

- [Documentation](http://natjs.com/#/#network)
- [Github](https://github.com/natjs/weex-nat-device-network)

## Installation
```
weexpack plugin add nat-device-network
```

```
npm install natjs --save
```

## Usage

Use in weex file (.we)

```html
<script>
import 'Nat' from 'natjs'

// get network status
Nat.network.status((err, ret) => {
    console.log(ret)
})

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
