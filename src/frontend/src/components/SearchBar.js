import React from 'react'

function searchPharmaProduct () {



}

const SearchBar = () =>
  
  <div className={'w3-container w3-half'}>
    <input id ="searchBar" className={'w3-input w3-border w3-round-xxlarge'} type={'search'} onKeyUp={searchPharmaProduct}/>
  </div>

export default SearchBar