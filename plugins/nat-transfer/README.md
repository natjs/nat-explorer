# nat-transfer

- [Documentation](http://natjs.com/#/#transfer)
- [Github](https://github.com/natjs/weex-nat-transfer)

## Installation
```
weexpack plugin add nat-transfer
```

```
npm install natjs --save
```

## Usage

Use in weex file (.we)

```html
<script>
import 'Nat' from 'natjs'

Nat.download({
    url: 'http://domain.com/file'
})

Nat.upload({
    url: 'http://domain.com/upload',
    path: 'filepath'
})

</script>
```

See the Nat [Documentation](http://natjs.com/) for more details.
