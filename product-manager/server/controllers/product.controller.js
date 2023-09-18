const Product = require('../models/product.model')

module.exports = {
    
    test: (req, res) => {
        res.json({msg: 'Hello!'})
    },

    //find all controller
    getAll: (req, res) => {
        Product.find()
            .then(products => res.json(products))
            .catch(err => res.json(err))
    },
    //find one controller
    findOneProduct: (req, res) => {
        Product.findById({_id: req.params.id})
            .then(product => res.json(product))
            .catch(err => res.json(err))

    },
    
    //create controller
    createProduct: (req, res) => { 
        // res.json(req.body)
        Product.create(req.body)
            .then(created => res.json(created))
            .catch(err => res.json(err))
    },
    //update controller
    updateProduct: (req, res) => {
        Product.findOneAndUpdate({_id: req.params.id}, req.body, {new: true})
            .then(updated => res.json (updated))
            .catch(err => res.json(err))
    }, 
    //delete controller
    deleteProduct: (req, res) => {
        Product.deleteOne({_id: req.params.id})
            .then(deleted => res.json(deleted))
            .catch(err => res.json(err))
    }
}