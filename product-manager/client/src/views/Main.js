import React, {useEffect, useState} from 'react'
import ProductForm from '../components/ProductForm'
import ProductList from '../components/ProductList'
import axios from 'axios'

const Main = (props) => {
    const [products, setProducts] = useState([])
    const [load, setLoad] = useState(false)



    useEffect(() => {
        axios.get('http://localhost:8000/api/products')
            .then(res => {
                setProducts(res.data)
                setLoad(true)
            })
            .catch(err => console.error(err))
    }, [])

    const removeFromDom = productId => {
        setProducts(products.filter(product => product._id !== productId))
    }
    
    return (
        <div>
            <ProductForm/>
            <br/>
            {load && <ProductList products = {products} removeFromDom={removeFromDom}/>}
        </div>
    )
}


export default Main