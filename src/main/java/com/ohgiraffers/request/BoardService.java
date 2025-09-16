package com.ohgiraffers.request;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

//    @Transactional
//    public void registNewPost(BoardDTO boardDTO) {
//        boardMapper.registNewPost(boardDTO);
//    }

    public List<BoardDTO> findAllPosts() {
        System.out.println("서비스1");
        System.out.println(boardMapper.findAllPosts());
        System.out.println("서비스2");
        System.out.println(boardMapper.findAllPosts());
        return boardMapper.findAllPosts();
    }
    @Transactional
    public void registNewPost(BoardDTO newBoardDTO) {
        System.out.println("registNewPost 서비스1");
        boardMapper.registNewPost(newBoardDTO);
        System.out.println("registNewPost 서비스2");
    }
    @Transactional
    public void updatePost(BoardDTO updateBoardDTO) {
        boardMapper.updatePost(updateBoardDTO);
    }
    @Transactional
    public void deletePostNumber(BoardDTO deleteBoardDTO) {
        boardMapper.deletePostNumber(deleteBoardDTO);
    }
    @Transactional
    public void deletePostTitle(BoardDTO deleteBoardDTO) {
        boardMapper.deletePostTitle(deleteBoardDTO);
    }
    @Transactional
    public void deletePostID(BoardDTO deleteBoardDTO) {
        boardMapper.deletePostID(deleteBoardDTO);
    }
    @Transactional
    public void deletePost(BoardDTO deleteBoardDTO) {
        boardMapper.deletePost(deleteBoardDTO);
    }

}
