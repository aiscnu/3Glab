const { createServer } = require('http')
const { parse } = require('url')
const next = require('next')

const dev = process.env.NODE_ENV !== 'production'
const hostname = 'localhost'
const port = 3000
// when using middleware `hostname` and `port` must be provided below
const app = next({ dev, hostname, port })
const handle = app.getRequestHandler()

const apiPaths = {
    '/api': {
        target: 'http://localhost:8080',
        pathRewrite: {
            '^/api': '/api'
        },
        changeOrigin: true
    }
}

const isDevelopment = process.env.NODE_ENV !== 'production'

app.prepare().then(() => {
  const server = express()

  if (isDevelopment) {
    server.use('/api', createProxyMiddleware(apiPaths['/api']));
  }

  server.all('*', (req, res) => {
    return handle(req, res)
  })

  server.listen(port, (err) => {
    if (err) throw err
    console.log(`> Ready on http://localhost:${port}`)
  })
}).catch(err => {
    console.log('Error:::::', err)
})