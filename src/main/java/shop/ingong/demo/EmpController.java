package shop.ingong.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shop.ingong.myba.DaoEmp;
import shop.ingong.myba.EmpVo;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EmpController {

    // 전체 조회
    @GetMapping("/emp_list.ajax")
    public Map<String, Object> ajaxEmpList() {
        DaoEmp de = new DaoEmp();
        ArrayList<EmpVo> list = de.selectList();

        // 로그 확인용
        System.out.println("사원 수: " + list.size());
        list.forEach(System.out::println);

        // JSON 형태로 감싸서 반환
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }

    // 단건 조회
    @GetMapping("/emp_detail.ajax")
    public Map<String, Object> ajaxEmpDetail(@RequestParam("e_id") String e_id) {
        DaoEmp de = new DaoEmp();
        EmpVo detailVo = de.select(new EmpVo(e_id, "", "", ""));

        System.out.println("조회된 VO: " + detailVo);

        Map<String, Object> map = new HashMap<>();
        map.put("vo", detailVo);
        return map;
    }

    // 등록
    @PostMapping("/emp_add.ajax")
    public Map<String, Object> ajaxEmpAdd(@RequestBody EmpVo pvo) {
        DaoEmp de = new DaoEmp();
        int cnt = de.insert(pvo);

        System.out.println("추가할 VO: " + pvo + ", 결과: " + cnt);

        Map<String, Object> map = new HashMap<>();
        map.put("cnt", cnt);
        return map;
    }

    // 수정
    @PostMapping("/emp_mod.ajax")
    public Map<String, Object> ajaxEmpMod(@RequestBody EmpVo pvo) {
        DaoEmp de = new DaoEmp();
        int cnt = de.update(pvo);

        System.out.println("수정할 VO: " + pvo + ", 결과: " + cnt);

        Map<String, Object> map = new HashMap<>();
        map.put("cnt", cnt);
        return map;
    }

    // 삭제
    @PostMapping("/emp_del.ajax")
    public Map<String, Object> ajaxEmpDel(@RequestBody EmpVo pvo) {
        DaoEmp de = new DaoEmp();
        int cnt = de.delete(pvo);

        System.out.println("삭제할 VO: " + pvo + ", 결과: " + cnt);

        Map<String, Object> map = new HashMap<>();
        map.put("cnt", cnt);
        return map;
    }
}
