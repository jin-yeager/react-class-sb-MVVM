package shop.ingong.myba;

import java.util.List;

public class DaoEmpTest {
	public static void main(String[] args) {
		
		DaoEmp de = new DaoEmp();

		List<EmpVo> list = de.selectList();

		list.forEach(System.out::println);
	}

}
