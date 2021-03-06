package com.p1.messenger.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.p1.messenger.model.Comment;
import com.p1.messenger.service.CommentService;

@Path("/")
public class CommentResource {

	private CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}

	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	@PUT
	@Path("{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id,
			Comment comment) {
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	@Path("{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.removecomment(messageId, commentId);
	}
}
