import React from 'react'

let total = 0
const CartCard = () =>
  <div>
    <table className="w3-table-all w3-small">
      <tr>
        <th>Name</th>
        <th>Batch</th>
        <th>Quantity</th>
        <th>Marked Price</th>
        <th>Discount %</th>
        <th>Price</th>
      </tr>
      <tr>
        <td>Cerocine</td>
        <td>Cerocine</td>
        <td><input size="1" maxLength={"2"}/></td>
        <td>Cerocine</td>
        <td><input size="1" maxLength={"2"}/></td>
        <td>Cerocine</td>
      
      </tr>
    </table>

    <br/>
    <button className={'w3-button w3-block w3-teal w3-round-xxlarge w3-circle'}>Total {total}</button>
  </div>

export default CartCard



