package hyu.eos.esc2019

import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/article") //클래스 내부를 한꺼번에 매핑 가능
class ApiController {
    @GetMapping("/api/article") // 모든 article 목록을 배열로 받아올 예정(여러개의 article 호출)
    fun getArticles(): Article = Article(1, "NES", "내용", "제목", LocalDateTime.now())

    @GetMapping("/{id}")
    //URL의 id와 일치하는 한 article을 불러올 예정
    fun getArticle(@PathVariable id : String) = Article( id.toInt(), "NES", "내용", "제목", LocalDateTime.now())

    @PostMapping("/")
    //TODO : 받아온 body 데이터를 사용해서 article을 만듦
    fun createArticle() : Article = Article( 1, "NES", "내용", "제목", LocalDateTime.now())

    @PutMapping("/")
    //TODO :  id 에 해당되는 article 수정할 예정
    fun updateArticle(@PathVariable id: String) : Article = Article(id.toInt(), "NES", "내용", "제목", LocalDateTime.now())

    @DeleteMapping("/{id}")
    //TODO : id에 해당되는 article을 삭제할 예정
    fun deleteArticle(@PathVariable id:String) : Article = Article(id.toInt(), "NES", "내용", "제목", LocalDateTime.now())


}