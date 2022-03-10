import { Component } from "react";
import CommentService from "../services/CommentService";
class UpdateComment extends Component {
    constructor(props){
        super(props)
        this.state={
            id:this.props.match.params.id,
            name:'',
            comment_text:''
        }
        this.idHandler=this.idHandler.bind(this);
        this.nameHandler=this.nameHandler.bind(this);
        this.comment_textHandler=this.comment_textHandler.bind(this);
        this.updateComment=this.updateComment.bind(this);
     }
     componentDidMount(){
         CommentService.getCommentsById(this.state.id).then((res => {let comment = res.data; this.setState({name:comment.name,comment_text:comment.comment_text})}));
     }
     
     nameHandler=(event)=>{this.setState({name: event.target.value})}
     comment_textHandler=(event)=>{this.setState({comment_text: event.target.value})}
     updateComment = (e) => {
         e.preventDefault();
         let comment={
            id: this.state.id,
            name: this.state.name,
            comment_text: this.state.comment_text
         }
         CommentService.updateComment(comment,this.state.id).then((res => {this.props.history.push('/comments')}))
     }
     cancel(){this.props.history.push('/comments')}
     render(){
         return(
            <div>
            <div className="container">
                <div className="row">
                   <div className="card col-md-6 offset-md-3 offset-md-3">
                       <h3 className="text-center">Update Comment</h3>
                       <div className="card-body">
                           <form>  
                                <div className="form-group">
                                   <label>Name: </label>
                                   <input placeholder="Name" name="name" className="form-control"
                                      value={this.state.name} onChange={this.nameHandler} />
                                </div>   
                                <div className="form-group">
                                   <label>Comment: </label>
                                   <input placeholder="Comment" name="comment" className="form-control"
                                      value={this.state.comment_text} onChange={this.comment_textHandler} />
                                </div>   
                                 <button className="btn btn-success" onClick={this.updateComment}> Update </button>
                                 <button className="btn btn-danger" onClick={this.cancel.bind(this)}> Cancel </button>                    
                           </form>
                       </div>
                   </div>
                </div>
            </div>
         </div>
         )
     }
}
export default UpdateComment;