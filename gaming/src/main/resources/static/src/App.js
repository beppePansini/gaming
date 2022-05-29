import './App.css';
import { useState, useEffect } from 'react';
import ShowGame from './components/ShowGame';
import SearchBarGame from './components/SearchBarGame'

/*
https://www.youtube.com/watch?v=VVn9OG9nfH0&ab_channel=Amigoscode

https://www.youtube.com/watch?v=nI8PYZNFtac&t=1589s&ab_channel=DaveGray

*/ 


function App() {
  const [games, setGames] = useState([]);
  const [category, setCategory] = useState("");
  const [categories, setCategories] = useState([]);
  const [creators, setCreators] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/game')
    .then((response) => response.json())
    .then(data => setGames(data));  

    fetch('http://localhost:8080/category/')
    .then(response => response.json())
    .then(data => setCategories(data)); 

    fetch('http://localhost:8080/creator')
    .then(response => response.json())
    .then(data => setCreators(data));
  }, []);

  useEffect(() => {
    if(category) {
      fetch('http://localhost:8080/game?categoryId=' + category)
      .then(response => response.json())
      .then(data => setGames(data));
    }
  }, [category]);

  const loadGames = (name) => {
    fetch('http://localhost:8080/game?name=' + name)
    .then(response => response.json())
    .then(data => {
        setGames(data);
  })}

  /*const showGameByCategory = (categoryId) => {
    fetch('http://localhost:8080/game?category=' + categoryId)
    .then(response => response.json())
    .then(data => setGames(data));
  }*/

  const addGame = (newGame) => {
    fetch('http://localhost:8080/game/add', {
      method: 'POST',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(newGame)
    });
    setGames([...games.concat(newGame)]); 
  }

  const updateGame = (game) => {
    fetch('http://localhost:8080/game', game, {
      method: 'PUT'})
    .then(response => response.json())
    .then(data => {
      setGames(data);
    })
  }

  const deleteGames = (id) => {
    fetch('http://localhost:8080/game/' + id, {
      method: 'DELETE'})
    .then(response => response.text())
    .then(() => {
      setGames(games.filter(game => game.id !== id));
    })
  }

  const changeCategory = (evt) => {
    setCategory(evt.target.value);
  }

  return (
    <div className="App">
      <div className="col-sm">
        <h1>ALL STAR GAME</h1>
        <select onChange={(e) => changeCategory(e)}>
            {categories.map(item => {
              return(
                <option key={item.id} value={item.id}>{item.name}</option>
              );
            })}
        </select>
        <SearchBarGame onSubmit={loadGames}/>
        <h4>I NOSTRI GIOCHI:</h4>
        {games.map(g =>
          <ShowGame key={g.id} game={g} />
        )}        
      </div>
    </div>
  );
}

export default App;
