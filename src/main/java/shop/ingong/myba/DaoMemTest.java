package shop.ingong.myba;

import java.util.List;

public class DaoMemTest {
	public static void main(String[] args) {
		
		DaoMem de = new DaoMem();

		List<MemVo> list = de.selectList();

		list.forEach(System.out::println);
	}

}
