import { Route, Routes } from 'react-router-dom';
import './App.css';
import AddComment from './components/AddComment';
import Comments from './components/Comments';
import Header from './components/Header';
import Home from './components/Home';
import Post1 from './components/Post1';
import Post2 from './components/Post2';
import Post3 from './components/Post3';


function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/post1' element={<Post1 />} />
            <Route path='/post2' element={<Post2 />} />
            <Route path='/post3' element={<Post3 />} />
            <Route path='/comments' element={<Comments />} />
            <Route path='/addcomment' element={<AddComment />} />
      </Routes>
    </div>
  );
}

export default App;
