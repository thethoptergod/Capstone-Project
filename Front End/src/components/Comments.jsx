import { Component } from "react";
import { Link } from "react-router-dom";
import CommentService from "../services/CommentService";

class Comments extends Component{
    constructor(props){
        super(props)
        this.state={
            comments:[]
        }
        this.addComment=this.addComment.bind(this);
        this.updateComment=this.updateComment.bind(this);
        this.deleteComment=this.deleteComment.bind(this);
    }
    componentDidMount(){
        CommentService.getComments().then((res => this.setState({comments:res.data})));
    }
    addComment(){
        // this.props.history.push('/addcomment');
    }
    updateComment(id){
        this.props.history.push(`/updatecomment/${id}`);
    }
    deleteComment(id){
        this.props.history.push(`/deletecomment/${id}`);
    }
    render(){
        return (
            <div style={{textAlign: 'center'}}>
                <h2>Comments</h2>
                <div> 
                    <button className="btn btn-primary"> <Link to='/addcomment'> Add Comment </Link></button>
                </div>
                <div>
                    <p></p>
                </div>
                <div style={{display: "flex", justifyContent:"center"}}>
                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Text</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.comments.map(
                                     comment =>
                                     <tr key={comment.id}>
                                         <td>{comment.name}</td>
                                         <td>{comment.comment_text}</td>
                                     </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>

            </div>
        )
    }
}
export default Comments;