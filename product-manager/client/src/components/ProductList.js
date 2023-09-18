import React from 'react'
import axios from 'axios'
import {Link, useNavigate} from 'react-router-dom'

const ProductList = (props) => {
    const {removeFromDom} = props
    const navigate = useNavigate()

    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/products/' + productId)
            .then(res => {removeFromDom(productId)})
            .then(res => console.log(res))
            .then(navigate('/'))
            .catch(err => console.error(err))
    }
    console.log(props)

    return (
        <>
            {props.products.map((product, i) => 
                <div key={i}>
                    <Link to={"/" + product._id}>{product.title}</Link><span> | </span>
                    <Link to={"/products/" + product._id + "/update"}>Edit</Link><span> | </span>
                    <button onClick={() => { deleteProduct(product._id) }}>Delete</button>
                    {/* <a href={'/' + product._id} key = {i}>{product.title}</a> */}
                </div>
                )}
        </>
    )
}
export default ProductList
