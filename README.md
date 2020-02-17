## メモ

### Server Side

- `Access-Control-Allow-Credentials`を`true`で返すようにする
- `Access-Control-Allow-Origin`を`*`で返すことはできず許可するOriginを明示的に指定する
    - Springならこんな感じ

```
@CrossOrigin(allowCredentials = "true", origins = {"http://localhost:4200", "http://localhost:5000"})
```

### Client Side

- withCredentialsの設定が必要
    - xhr系なら`xhr.withCredentials = true;`
    - fetch系なら`credentials: 'include'`
    - これらをラップするライブラリを使うならそれぞれのお作法に則る
    
