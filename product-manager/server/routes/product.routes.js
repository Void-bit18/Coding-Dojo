const ProductController = require('../controllers/product.controller')

module.exports = app => {
    //test
    app.get('/api/test', ProductController.test)
    
    //get all product route
    app.get('/api/products', ProductController.getAll)

    //get one product route
    app.get('/api/products/:id', ProductController.findOneProduct)

    // create product route
    app.post('/api/products', ProductController.createProduct)

    //update product
    app.patch('/api/products/:id', ProductController.updateProduct)

    //delete product
    app.delete('/api/products/:id', ProductController.deleteProduct)
}