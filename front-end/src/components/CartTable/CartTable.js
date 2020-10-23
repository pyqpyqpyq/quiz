import React, { Component, Fragment } from "react";
import { deleteAPI, getAPI } from "../API/api";
import { Link } from 'react-router-dom';
import './CartTable.scss';
export default class CartTable extends Component {
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
    return (
      <body>
        <div className="order">
          <table className="table">
            <thead>
              <tr>
                <th>姓名</th>
                <th>数量</th>
              </tr>
            </thead>
            <tbody>
              {this.state.cart.map((item) => (
                <tr key={item.name}>
                  <td>{item.name}</td>
                  <td>{item.number}</td>
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
