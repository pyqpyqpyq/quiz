import React, { Component, Fragment } from "react";
import { getAPI } from "../API/api";

export default class ProductList extends Component {
  state = {
    cart: [
      // { id: 1, number: 1, name: "可乐1", price: 1, unit: "瓶" },
      // { id: 2, number: 2, name: "可乐2", price: 2, unit: "瓶" },
      // { id: 3, number: 3, name: "可乐3", price: 3, unit: "瓶" },
    ],
  };
  async componentDidMount(){
    const cart = await getAPI('http://localhost:8080/cart');
    this.setState({
      cart: cart
    })
  }
  render() {
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
              {this.state.cart.map((item)=>
              <tr key={item.name}>
                <td>{item.name}</td>
                <td>{item.price}</td>
                <td>{item.number}</td>
                <td>{item.unit}</td>
                <td><button onClick>删除</button></td> 
              </tr>)}
            </tbody>
          </table>
        </div>
        <footer>
        TW Mall @2018 Created by ForCheng
        </footer>
      </body>
    );
  }
}

// export default Order;
