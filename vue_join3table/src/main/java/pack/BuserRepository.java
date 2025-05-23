package pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuserRepository extends JpaRepository<Buser, Integer> {
    // buser와 jikwon을 조인하고, 그 결과로 gogek과 조인

    @Query("select new pack.BuserJikwonGogekDTO(" +
            "b.buserno, b.busername, b.buserloc," +
            "j.jikwonno, j.jikwonname, j.jikwonjik, j.jikwonpay," +
            "g.gogekno, g.gogekname, g.gogektel) " +
            "from Buser b join b.jikwons j " +
            "left join j.gogeks g"
    )
    List<BuserJikwonGogekDTO> findAllJoinedData();
    // left join은 jikwons와 관련된 gogeks 데이터가 없더라도 Buser와 jikwons 자료를 가져온다.
}
