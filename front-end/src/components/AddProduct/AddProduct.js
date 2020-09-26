import React, { Fragment ,Component} from 'react';
import { postAPI } from '../API/api';
import 'bootstrap/dist/css/bootstrap.css'

export default class AddProduce extends Component {
  state = {
    name: 'abc',
    price: 20,
    unit: '包',
    picUrl: 'ccc'
  }
  render() {
    return (
      <form id="container" onSubmit={this.submitForm}>
        <div className="form-group" id="title">
          <h1>添加商品</h1>
        </div>
        <div className="form-group">
          <label htmlFor="name" className="col-sm-2">
            <h4>名称</h4>
          </label>
          <input className="form-control" value={this.state.name}
            id="name" onChange={this.filedChange} />
        </div>
        <div className="form-group">
          <label htmlFor="price" className="col-sm-2">
            <h4>价格</h4>
          </label>
          <input className="form-control" value={this.state.price}
            id="price" onChange={this.filedChange} />
        </div>
        <div className="form-group">
          <label htmlFor="unit" className="col-sm-2">
            <h4>单位</h4>
          </label>
          <input className="form-control" value={this.state.unit}
            id="unit" onChange={this.filedChange} />
        </div>
        <div className="form-group">
          <label htmlFor="picUrl" className="col-sm-2">
            <h4>图片</h4>
          </label>
          <input className="form-control" value={this.state.avator}
            id="picUrl" onChange={this.filedChange} />
        </div>
        <div className="form-group" id="submit-btn">
          <input value="Submit" type="submit" className="btn btn-primary"
            disabled={this.state.name == '' || this.state.unit == '' || this.state.picUrl == ''} />
        </div>
      </form>
    );
  }

  filedChange = (event) => {
    const eventId = event.target.id;
    const changedValue = event.target.value;
    console.log(changedValue);
    switch (eventId) {
      case "name":
        this.setState({
          name: changedValue
        });
        break;
      case "price":
        this.setState({
          price: changedValue
        });
        break;
      case "unit":
        this.setState({
          unit: changedValue
        });
        break;
      case "picUrl":
        this.setState({
          picUrl: changedValue
        });
        break;
      default:
        break;
    };
  }

  submitForm = (event) => {
    event.preventDefault();
    const obj = {
      "name": this.state.name,
      "price": this.state.price,
      "unit": this.state.unit,
      "avatar": this.state.picUrl
    }
    postAPI("http://localhost:8080/products",obj);
  }

}