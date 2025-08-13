package com.thejoa.boot3.board;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa.boot3.member.Member;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	//ver-1 @Autowired  BoardService service;
	private final BoardService service;
	/*	paging	*/
	/*	paging	*/
	@GetMapping("/board/list")
	public String list(Model model   ,
		   @RequestParam( value="page" , defaultValue="0")	int page){
		
		model.addAttribute("list"   , service.getPaging(page));  //10개씩
		
		System.out.println("........" + this.service.findAll().size());
		
		model.addAttribute("paging" , new PagingDto(this.service.findAll().size() , page)   );  //##전체리스트뽑고
		return "board/list"; // board 폴더안에 / list파일
	} // http://localhost:8080/board/list
	
	/*	basic	*/
	/*	basic	
	@GetMapping("/board/list")
	public String list(Model model){
		model.addAttribute("list" , service.findAll());  //##전체리스트뽑고
		return "board/list"; // board 폴더안에 / list파일
	} // http://localhost:8080/board/list
	*/
	
	@GetMapping("/board/detail/{id}")
	public String detail( @PathVariable  Long id,  Model model){
		model.addAttribute("dto" , service.find(id)); 
		return "board/detail"; // board 폴더안에 / list파일
	} // http://localhost:8080/board/detail/5 (있는번호)

	///////////////////////////////////////////////////////////////
	@GetMapping("/board/insert")
	public String insert_get(Principal principal, Model model){ 
		model.addAttribute("username", principal.getName());
		return "board/write"; 
	}
	// http://localhost:8080/board/insert    ( 글쓰기 폼)
	@PostMapping("/board/insert")
	public String insert_post( MultipartFile file  , Board board  , Member member){  
		board.setMember(member);
		service.insert(file , board);   
		return "redirect:/board/list"; 
	} // form테스트   ( 글쓰기 기능 - 갱신된리스트 )
	///////////////////////////////////////////////////////////////
	//  @RequestParam - form, query string, 데이터 헤더로부터 데이터 추출
	//  @PathVariable - url 경로의 변수를 추출할때 사용
	///// insert, update, delete
	@GetMapping("/board/update/{id}")
	public String update_get( @PathVariable Long id , Model model){ 
		model.addAttribute("dto",service.update_view(id));
		return "board/edit"; 
	}
	// http://localhost:8080/board/update/5    ( 글수정 폼)
	
	@PostMapping("/board/update")
	public String update_post(MultipartFile file  ,  Board board  , RedirectAttributes rttr){ 
		String msg = "fail";
		if( service.update(file, board) > 0) {  msg = "글 수정완료!";}
		rttr.addFlashAttribute("msg", msg);
		return "redirect:/board/detail/" + board.getId(); 
	} // 폼태그에서 테스트   
	
	
	@GetMapping("/board/delete/{id}")
	public String delete_get( @PathVariable Long id , Model model){
		model.addAttribute("id" , id);
		return "board/delete"; 
	}
	// http://localhost:8080/board/delete   ( 글삭제 폼)
	
	@PostMapping("/board/delete")
	public String delete_post( Board board , RedirectAttributes rttr ){ 
		String msg = "fail";
		if( service.delete(board)  > 0) { msg="글삭제성공!";}
		rttr.addFlashAttribute("msg", msg);
		return "redirect:/board/list"; 
	} // http://localhost:8080/board/update    ( 글수정 기능 - 갱신된리스트 )
	 
}

//@PreAuthorize("isAuthenticated()")	
//@PreAuthorize("hasRole('ADMIN')")	
//@PreAuthorize("isAnonymous()")
//@PostMapping("/board/insert")
/** Restful Api
detail?bno=10  쿼리스트링
 Restful Api  :   localhost:8080/board/detail/bno/10   쿼리스트링
	1) resultful - http url을 기반으로 자원에 접근해서 서비스를 제공하는 애플리케이션
	2) api
	3) method ( GET : 검색 / POST : 생성 / PATCH(부분업데이트) , PUT(전체업데이트) / DELETE(삭제) )
	4) DATA -  json, xml
**/





