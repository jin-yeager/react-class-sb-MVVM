package shop.ingong.demo;

import org.springframework.web.bind.annotation.*;
import shop.ingong.myba.DaoEmp;
import shop.ingong.myba.EmpVo;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EmpController {

    private final DaoEmp dao = new DaoEmp();

    /** 전체 조회 */
    @GetMapping("/emp_list.do")
    public List<EmpVo> empList() {
        return dao.selectList();
    }

    /** 단건 조회 */
    @GetMapping("/emp_detail.do")
    public EmpVo empDetail(@RequestParam("e_id") int id) {
        return dao.select(new EmpVo(id, "", "", ""));
    }

    /** 등록 */
    @PostMapping("/emp_add.do")
    public Map<String, Integer> empAdd(@RequestBody EmpVo vo) {
        int cnt = dao.insert(vo);
        return Map.of("cnt", cnt);
    }

    /** 수정 */
    @PostMapping("/emp_mod.do")
    public Map<String, Integer> empMod(@RequestBody EmpVo vo) {
        int cnt = dao.update(vo);
        return Map.of("cnt", cnt);
    }

    /** 삭제 */
    @PostMapping("/emp_del.do")
    public Map<String, Integer> empDel(@RequestBody EmpVo vo) {
        int cnt = dao.delete(vo);
        return Map.of("cnt", cnt);
    }
}
