package shop.ingong.myba;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

public class DaoMem {
	SqlSessionFactory sqlMapper = SqlSessionFactoryManager.getSqlSessionFactory();

	public ArrayList<MemVo> selectList() {
		return (ArrayList) sqlMapper.openSession().selectList("mem.selectList");
	}

	public MemVo select(MemVo vo) {
		return sqlMapper.openSession().selectOne("mem.select",vo);
	}

	public int insert(MemVo vo) {
		SqlSession session = sqlMapper.openSession();
		int cnt = session.update("mem.insert",vo);
		session.commit();
		session.close();
		return cnt;
	}

	public int update(MemVo vo) {
		return sqlMapper.openSession(true).update("mem.update",vo);
	}

	public int delete(MemVo vo) {
		return sqlMapper.openSession(true).update("mem.delete",vo);
	}

}
