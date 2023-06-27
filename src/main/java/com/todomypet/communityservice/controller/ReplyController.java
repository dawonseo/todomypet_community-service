package com.todomypet.communityservice.controller;

import com.todomypet.communityservice.dto.PostReplyReqDTO;
import com.todomypet.communityservice.dto.PostReplyResDTO;
import com.todomypet.communityservice.dto.SuccessResDTO;
import com.todomypet.communityservice.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/board/{postId}/reply")
    public SuccessResDTO<PostReplyResDTO> postReply(@RequestHeader String userId,
                                                    @PathVariable String postId,
                                                    @RequestBody PostReplyReqDTO postReplyReqDTO) {
        String responseId = replyService.postReply(userId, postId, postReplyReqDTO);
        PostReplyResDTO response = PostReplyResDTO.builder().id(responseId).build();
        return new SuccessResDTO<>(response);
    }

    @DeleteMapping("/board/{postId}/reply/{replyId}")
    public SuccessResDTO<Void> deleteReply(@RequestHeader String userId,
                                           @PathVariable String postId,
                                           @PathVariable String replyId) {
        replyService.deleteReply(userId, postId, replyId);
        return new SuccessResDTO<>(null);
    }
}