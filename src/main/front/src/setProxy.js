
const {createProxyMiddelware} = require('http-proxy-middleware')

module.exports = function(app){
    app.use(
        '/user',
        createProxyMiddelware({
            target:'http://localhost:8080',
            changeOrigin:true,
        })
    )
}