package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JikwonRepository extends JpaRepository<JikwonDto, Integer> {
    @Query("select j from JikwonDto j join j.buser b order by b.busername asc")
    List<JikwonDto> findAllorderByBuserName();
}
