import CommentService from "../services/CommentService";
import { Component } from 'react';
import { Link } from "react-router-dom";
 class AddComment extends Component {
     constructor(props){
        super(props)
        this.state={
            name:'',
            email:'',
            comment_text:''
        }
        this.nameHandler=this.nameHandler.bind(this);
        this.emailHandler=this.emailHandler.bind(this);
        this.comment_textHandler=this.comment_textHandler.bind(this);
     }
     nameHandler=(event)=>{
         this.setState({
             name: event.target.value
         })
     }
     emailHandler=(event)=>{
        this.setState({
            email: event.target.value
        })
    }
    comment_textHandler=(event)=>{
        this.setState({
            comment_text: event.target.value
        })
    }
    saveComment = (e) =>{
        e.preventDefault();
        let comment={
            name: this.state.name,
            email: this.state.email,
            comment_text: this.state.comment_text
        };
        console.log(comment);
        CommentService.addComment(comment).then(res =>{
            this.props.history.push('/comments');
        }).catch(err =>{
            console.log(err+"Not saved");
        })
    }
    cancel(){
        this.props.history.push('/comments');
    }
    render(){
        return(
            <div>
            <div>
            <div>
            <div>
                    <h3>Add Comment</h3>
                    <div>
                        <form>
                            <div>
                                <label>Name: </label>
                                <input placeholder="name" name="name" className="form-control" value={this.state.name} onChange={this.nameHandler} />
                            </div>
                            <div className="form-group">
                                <label>E-Mail: </label>
                                <input placeholder="E-Mail" name="email" className="form-control" value={this.state.email} onChange={this.emailHandler} />
                            </div>
                            <div className="form-group">
                                <label>Comment: </label>
                                <input placeholder="Comment" name="comment" className="form-control" value={this.state.comment_text} onChange={this.comment_textHandler} />
                            </div>
                            <button className="btn btn-success" onClick={this.saveComment}> <Link to='/comments'> Save </Link></button>
                            <button> <Link to='/comments' >Cancel </Link> </button>
                        </form>
                    </div>
                </div>
                </div>
                </div>
            </div>
        )
    }
 }
export default AddComment;