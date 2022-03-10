import Post1 from "./Post1";
import Post2 from "./Post2";
import Post3 from "./Post3";
import Comments from "./Comments";
function Home(){
    return(
        <div>
        <div style={{textAlign: "center"}}>
            <strong>Welcome to Whiskey and Waveforms!<br></br></strong>
            <span>A blog dedicated to whiskey and music</span>
        </div>
        <div style={{textAlign: "center"}}>
            <Post1 />
            <Post2 />
            <Post3 />
            <Comments />
        </div>
        </div>
    )
}
export default Home;