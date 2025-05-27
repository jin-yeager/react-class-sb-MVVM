package shop.ingong.myba;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {

	private static final SqlSessionFactory sqlMapper;
	static {
		String resource = "shop/ingong/myba/SqlMapConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			System.out.println("초기화 에러");
		}
		sqlMapper = new SqlSessionFactoryBuilder().build(reader);

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlMapper;
	}
}
