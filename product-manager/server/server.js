require('dotenv').config()

const express = require('express')
const cors = require('cors')
const app = express()


require('./config/mongoose.config')

app.use(cors(), express.json(), express.urlencoded({extended: true}))

const allRoutes = require('./routes/product.routes')
allRoutes(app)

app.listen(8000, () => {console.log('Server online!')})