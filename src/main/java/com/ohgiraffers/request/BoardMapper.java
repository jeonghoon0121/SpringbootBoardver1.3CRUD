package com.ohgiraffers.request;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> findAllPosts();
    void registNewPost(BoardDTO newBoardDTO);
    void updatePost(BoardDTO updateBoardDTO);
    void deletePostID(BoardDTO updateBoardDTO);
    void deletePostNumber(BoardDTO updateBoardDTO);
    void deletePostTitle(BoardDTO updateBoardDTO);
    void deletePost(BoardDTO updateBoardDTO);
}
