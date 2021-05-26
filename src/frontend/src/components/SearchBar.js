import React, { useState } from 'react'

function searchProduct (searchTerm) {
  
  console.log(searchTerm)
}

const SearchBar = () => {
  const [searchTerm, setSearchTerm] = useState('')
  
  return <div className={'w3-container w3-half'}>
    <input id="searchBar" value={searchTerm} className={'w3-input w3-border w3-round-xxlarge'} type={'search'}
           onChange={(event) => setSearchTerm(event.target.value)}
           onKeyUp={() => searchProduct(searchTerm)}/>
  </div>
}
export default SearchBar