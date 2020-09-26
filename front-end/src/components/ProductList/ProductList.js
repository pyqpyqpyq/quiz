// import   Component  from 'react';
import React, { Fragment ,Component} from 'react';
import {getAPI} from '../API/api'
import 'bootstrap/dist/css/bootstrap.css'
 
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
  render(){
    const result = this.state.products.map(m => 
       <div className="col-md-3">
          <img id="avator" src={m.avatar}/><br/>
          <label>{m.name}</label><br/>
          <label>单价:{m.price}/{m.unit}</label><br/>
          <button className="btn btn-primary">添加到购物车</button>
      </div>
  )

  return (
    <Fragment>
      <h1> This is ProductList Page</h1>
      {result}
    </Fragment>
  );
}};
