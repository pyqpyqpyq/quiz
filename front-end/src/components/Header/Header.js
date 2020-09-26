import React, { Component } from 'react';
import { Link } from 'react-router-dom';

export default class Header extends Component {
render(){
  return (
    <nav className="nav">
      <Link to="/" className="nav-link">
        商城
      </Link>
      <Link to="/Order" className="nav-link">
        订单
      </Link>
      <Link to="/AddProduct" className="nav-link">
        添加商品
      </Link>
    </nav>
  );
}
}
