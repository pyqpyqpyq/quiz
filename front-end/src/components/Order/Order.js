import React, { Component, Fragment } from "react";
import { deleteAPI, getAPI } from "../API/api";
import { Link } from 'react-router-dom';
import './Order.scss';
export default class ProductList extends Component {
  state = {
    cart: [
      // { id: 1, number: 1, name: "可乐1", price: 1, unit: "瓶" },
      // { id: 2, number: 2, name: "可乐2", price: 2, unit: "瓶" },
      // { id: 3, number: 3, name: "可乐3", price: 3, unit: "瓶" },
    ],
  };
  async componentDidMount() {
    const cart = await getAPI("http://localhost:8080/cart");
    this.setState({
      cart: cart,
    });
  }
  async deleteCart(itemName){
    await deleteAPI("http://localhost:8080/cart",itemName) 
    const cartnew = await getAPI("http://localhost:8080/cart");
     this.setState({
      cart: cartnew,
    })
  }
  render() {
    if (this.state.cart.length === 0) {
      return (
        <div className="order-no-data">
          <p>
            暂无订单，返回<Link to="/">商城页面</Link>继续购买
          </p>
        </div>
      );
    }
    return (
      <body>
        <div className="order">
          <table className="table">
            <thead>
              <tr>
                <th>姓名</th>
                <th>单价</th>
                <th>数量</th>
                <th>单位</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              {this.state.cart.map((item) => (
                <tr key={item.name}>
                  <td>{item.name}</td>
                  <td>{item.price}</td>
                  <td>{item.number}</td>
                  <td>{item.unit}</td>
                  <td>
                    <button className='btn' onClick={()=>this.deleteCart(item.name)}>删除</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </body>
    );
  }
}

// export default Order;
