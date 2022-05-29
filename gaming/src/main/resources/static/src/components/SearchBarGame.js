import React from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'

class SearchBarGame extends React.Component {
    state = {
        name: ""
    }

    onSearch = (e) => {
        console.log(this.state.name);
        e.preventDefault();
        this.props.onSubmit(this.state.name);
    }

    render() {
        return(
            <div>
                <form className="search" onSubmit={this.onSearch}>
                    <p><FontAwesomeIcon className="glass" icon={faMagnifyingGlass}/></p>
                    <input id="text" value={this.state.name} type="text" onChange={(e) => this.setState({name: e.target.value})}></input>
                </form>
            </div>
            
        )
    }
}

export default SearchBarGame;