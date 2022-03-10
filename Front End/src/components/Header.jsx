import { Link } from "react-router-dom";

export default function Footer(){
    return (
        <div style={{display: "flex", justifyContent: "space-around", backgroundColor: "lightBlue"}}>
            <Link to='/'>Home</Link>
            <Link to='/post1'>Post 1</Link>
            <Link to='/post2'>Post 2</Link>
            <Link to='/post3'>Post 3</Link>
            <Link to='/comments'>Comments</Link>
            <a href="mailto:admin@whiskeyandwaveforms.com">Contact Me</a>
        </div>
    )
}