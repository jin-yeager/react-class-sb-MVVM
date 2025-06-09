package shop.ingong.myba;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.ArrayList;

public class DaoEmp {
	private final SqlSessionFactory sqlMapper = SqlSessionFactoryManager.getSqlSessionFactory();

	public ArrayList<EmpVo> selectList() {
		try (SqlSession session = sqlMapper.openSession()) {
			return (ArrayList) session.selectList("emp.selectList");
		}
	}

	public EmpVo select(EmpVo vo) {
		try (SqlSession session = sqlMapper.openSession()) {
			return session.selectOne("emp.select", vo);
		}
	}

	public int insert(EmpVo vo) {
		try (SqlSession session = sqlMapper.openSession()) {
			int cnt = session.insert("emp.insert", vo);
			session.commit();
			return cnt;
		}
	}

	public int update(EmpVo vo) {
		try (SqlSession session = sqlMapper.openSession()) {
			int cnt = session.update("emp.update", vo);
			session.commit();
			return cnt;
		}
	}

	public int delete(EmpVo vo) {
		try (SqlSession session = sqlMapper.openSession()) {
			int cnt = session.delete("emp.delete", vo);
			session.commit();
			return cnt;
		}
	}
}
