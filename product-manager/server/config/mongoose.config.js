const mongoose = require('mongoose')

//extracing the .env variables
const dbName = process.env.DB
const uName = process.env.ATLAS_USERNAME
const pWord = process.env.ATLAS_PASSWORD
const hostName = process.env.HOSTNAME

const connectionString = `mongodb+srv://${uName}:${pWord}@${hostName}/${dbName}?retryWrites=true&w=majority`



mongoose.connect(connectionString, {
    useNewUrlParser: true,
	useUnifiedTopology: true,
})
    .then(() => {
        console.log('Established connection to the database.')
    })
    .catch(err => {
        console.log('Could not establish a connection to Mongo: ', err)
    })