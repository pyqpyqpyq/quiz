import React, { Component } from 'react';
import ProductList from './components/ProductList/ProductList';
import Order from './components/Order/Order';
import AddProduct from './components/AddProduct/AddProduct';
import Header from './components/Header/Header';
import './App.css';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

class App extends Component {
  render(){
  return (
    <BrowserRouter>
      <Header />
      <Switch>
        <Route exact path="/ProductList" component={ProductList} />
        <Route exact path="/Order" component={Order} />
        <Route exact path="/AddProduct" component={AddProduct} />
        <Route path="/" component={ProductList} />
      </Switch>
    </BrowserRouter>
  );}
}

export default App;
