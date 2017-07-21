# nat-recorder

- [Documentation](http://natjs.com/#/#recorder)
- [Github](https://github.com/natjs/weex-nat-recorder)

## Installation
```
weexpack plugin add nat-recorder
```

```
npm install natjs --save
```

## Usage

Use in weex file (.we)

```html
<script>
import 'Nat' from 'natjs'

Nat.recorder.start()

Nat.recorder.pause()

Nat.recorder.stop((err, ret) => {
    console.log(ret)
})

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
