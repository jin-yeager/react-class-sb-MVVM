package shop.ingong.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.ingong.myba.DaoMem;
import shop.ingong.myba.MemVo;

@RestController
@RequestMapping("/mem")
public class MemController {

    private final DaoMem dao = new DaoMem();

    // 전체 조회
    @GetMapping
    public List<MemVo> list() {
        return dao.selectList();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public MemVo one(@PathVariable int id) {
        // id를 사용하여 MemVo 객체를 생성
        MemVo vo = new MemVo(id, "", "", "");  // 나머지 필드는 빈 문자열로 초기화
        return dao.select(vo);  // 생성한 MemVo 객체를 사용해 데이터 조회
    }

    // 추가
    @PostMapping
    public Map<String, Integer> add(@RequestBody MemVo vo) {
        int cnt = dao.insert(vo);
        return Map.of("cnt", cnt);
    }

    // 수정
    @PostMapping("/mod")
    public Map<String, Integer> mod(@RequestBody MemVo vo) {
        int cnt = dao.update(vo);
        return Map.of("cnt", cnt);
    }

    /** 삭제 (POST /mem/del) */
    @PostMapping("/del")
    public Map<String, Integer> del(@RequestBody MemVo vo) {
        int cnt = dao.delete(vo);
        return Map.of("cnt", cnt);
    }
}
