import axios from "axios";
const BaseUrl = "https://whiskeyandwaveforms.herokuapp.com/api/comment_data";
class CommentService{
    getComments(){
        return axios.get(BaseUrl+"/all_comments");
    }
    getCommentsById(id){
        return axios.get(BaseUrl+"/comment/id"+id);
    }
    getCommentsByName(name){
        return axios.get(BaseUrl+"/comment/name"+name)
    }
    updateComment(id,comment){
        return axios.put(BaseUrl+"/updatecomment/id"+id,comment)
    }
    addComment(comment){
        return axios.post(BaseUrl+"/add_comment",comment)
    }
    deleteComment(id){
        return axios.delete(BaseUrl+"/comment/delete/"+id)
    }
}
export default new CommentService();