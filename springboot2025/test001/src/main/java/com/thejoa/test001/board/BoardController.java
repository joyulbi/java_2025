package com.thejoa.test001.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    // 1. 목록 보기
    @GetMapping("/board/list")
    public String list(Model model) {
        model.addAttribute("list", service.findAll());
        return "board/list";  // → templates/board/list.html
    }

    // 2. 상세 보기
    @GetMapping("/board/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("dto", service.find(id));  // 조회 + 조회수 증가
        return "board/detail";  // → templates/board/detail.html
    }

    // 3. 글쓰기 폼
    @GetMapping("/board/insert")
    public String insertForm() {
        return "board/write";  // → templates/board/write.html
    }

    // 4. 글쓰기 처리
    @PostMapping("/board/insert")
    public String insertSubmit(Board board) {
        service.insert(board);
        return "redirect:/board/list";
    }

    // 5. 수정 폼
    @GetMapping("/board/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("dto", service.updateView(id));  // 수정할 데이터 전달
        return "board/edit";  // → templates/board/edit.html
    }

    // 6. 수정 처리 (비밀번호 일치 시)
	@PostMapping("/board/update")
	public String update_post(Board board,RedirectAttributes rttr){
		String msg="fail";
		if(service.update(board)>0) {msg="글 수정 성공!";}
		rttr.addFlashAttribute("msg",msg);
		//service.update(board);
		return "redirect:/board/detail/"+board.getId(); 
	}

    // 7. 삭제 폼
	@GetMapping("/board/delete/{id}")
	public String delete_get(@PathVariable Long id , Model model){
		model.addAttribute("id", id);
		return "board/delete"; 
	}

    // 8. 삭제 처리 (비밀번호 일치 시)
	@PostMapping("/board/delete")
	public String delete_post(Board board, RedirectAttributes rttr){
		String msg="fail";
		if(service.delete(board)>0) {msg="글삭제 성공!";}
		rttr.addFlashAttribute("msg",msg);
		return "redirect:/board/list"; 
	}
}
