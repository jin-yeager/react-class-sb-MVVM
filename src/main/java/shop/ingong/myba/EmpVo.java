package shop.ingong.myba;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpVo {
	private int e_id;
	private String e_name;
	private String gen;
	private String addr;
}
