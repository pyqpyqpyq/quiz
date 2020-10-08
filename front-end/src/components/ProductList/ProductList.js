// import   Component  from 'react';
import React, { Fragment ,Component} from 'react';
import {getAPI} from '../API/api'
import { postAPI } from '../API/api';
import 'bootstrap/dist/css/bootstrap.css';
import './ProductList.scss';
 
export default class  ProductList extends Component{
  state = {
    products: []
  }
  async componentDidMount(){
    const products = await getAPI('http://localhost:8080/products');
    this.setState({
      products: products
    })
  }

  addToCart(item){
    const cartItem = {
      "avatar": item.avatar,
      "name": item.name,
      "price": item.price,
      "unit": item.unit,
    }
      postAPI("http://localhost:8080/cart",cartItem);
  }

  render(){
    const result = this.state.products.map(item => 
       <div className="col-md-3">
          <img id="avator" src={item.avatar} alt='avatar'/><br/>
          <label>{item.name}</label><br/>
          <label>单价:{item.price}/{item.unit}</label><br/>
          <button className="btn btn-primary" onClick={()=>this.addToCart(item)}>添加</button>
      </div>
  )

  return (
    <Fragment>
      {result}
    </Fragment>
  );
}};
