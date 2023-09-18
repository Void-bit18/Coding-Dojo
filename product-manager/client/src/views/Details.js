import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, Link, useNavigate } from "react-router-dom";

const Details = (props) => {
    const navigate = useNavigate()

    const [product, setProduct] = useState({})
    const {id} = useParams()

    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/products/' + productId)
            .then(res => console.log(res))
            .then(navigate('/'))
            .catch(err => console.error(err))
    }

    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' +id)
            .then(res => setProduct(res.data))
            .catch(err => console.error(err))
    }, [])

    return(
        <div>
            <h1>{product.title}</h1>
            <h2>{product.price}</h2>
            <h3>{product.description}</h3>
            <Link to = {'/products/' + product._id + "/update"}>Edit</Link>
            <button onClick={() => { deleteProduct(product._id) }}>Delete</button>
        </div>
    )
}

export default Details 