import { Routes, Route, Link } from 'react-router-dom';
import Main from './views/Main'
import Details from './views/Details'
import Update from './views/Update'

function App() {
  return (
    <div className="App">
      <Link to = '/'>Home</Link>
      <Routes>
        <Route element = {<Main/>} path = '/'></Route>
        <Route element = {<Details/>} path = '/:id'></Route>
        <Route element = {<Update/>} path = 'products/:id/update'></Route>
      </Routes>
    </div>
  );
}

export default App;
