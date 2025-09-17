package com.ohgiraffers.request;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService =boardService;
    }

    @GetMapping("/list")
    public String findPostList(Model model){

        List<BoardDTO> boardDTOList = boardService.findAllPosts();
        System.out.println("컨트롤러1");
        System.out.println("boardDTOList = " + boardDTOList);

        for(BoardDTO boards : boardDTOList){
            System.out.println("boards = " + boards);
        }
        System.out.println(boardDTOList);
        System.out.println("컨트롤러2");
        model.addAttribute("boardDTOList",boardDTOList);
        return "board/list";
    }
    @GetMapping("/regist")
    public void registPost() {}
    @PostMapping("/regist")
    public String registPost(BoardDTO newBoardDTO, RedirectAttributes rttr) {
        System.out.println("컨트롤러1");
        boardService.registNewPost(newBoardDTO);
        System.out.println("컨트롤러2");
        System.out.println(newBoardDTO);
        System.out.println("컨트롤러3");
        rttr.addFlashAttribute("successMessage", "글등록에 성공하셨습니다.");
        System.out.println("컨트롤러4");
        return "redirect:/board/list";
    }
    @GetMapping("/update")
    public void updatePost(){}

    @PostMapping("/update")
    public String updatePost(BoardDTO updateBoardDTO, RedirectAttributes rttr){
        System.out.println("업데이트 컨트롤러");
        boardService.updatePost(updateBoardDTO);
        System.out.println(updateBoardDTO);
        rttr.addFlashAttribute("successMessage","글수정에성공하셨씁니다.");
        return "redirect:/board/list";
    }
    @GetMapping("/delete")
    public void deletePost(){}
    @PostMapping("/delete")
    public String deletePost(BoardDTO deleteBoardDTO, RedirectAttributes rttr){
        boardService.deletePost(deleteBoardDTO);
        rttr.addFlashAttribute("successMessage","삭제에성공하셨습니다.");
        return "redirect:/board/list";
    }
    @GetMapping("/delete1")
    public void deletePost1(){}

    @PostMapping("/delete1")
    public String deletePost1(BoardDTO deleteBoardDTO, RedirectAttributes rttr){
        boardService.deletePostNumber(deleteBoardDTO);
        rttr.addFlashAttribute("successMessage","삭제에성공하셨습니다.");
        return "redirect:/board/list";
    }
    @GetMapping("/delete2")
    public void deletePost2(){}

    @PostMapping("/delete2")
    public String deletePost2(BoardDTO deleteBoardDTO, RedirectAttributes rttr){
        boardService.deletePostTitle(deleteBoardDTO);
        rttr.addFlashAttribute("successMessage","삭제에성공하셨습니다.");
        return "redirect:/board/list";
    }
    @GetMapping("/delete3")
    public void deletePost3(){}

    @PostMapping("/delete3")
    public String deletePost3(BoardDTO deleteBoardDTO, RedirectAttributes rttr){
        boardService.deletePostID(deleteBoardDTO);
        rttr.addFlashAttribute("successMessage","삭제에성공하셨습니다.");
        return "redirect:/board/list";
    }

}
