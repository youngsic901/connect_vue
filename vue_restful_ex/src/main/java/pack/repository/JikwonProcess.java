package pack.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pack.model.JikwonDto;
import pack.model.JikwonRepository;

import java.util.List;

@Repository
public class JikwonProcess {
    @Autowired
    private JikwonRepository jikwonRepository;

    public List<JikwonDto> getAll() {
        return jikwonRepository.findAllorderByBuserName();
    }
}
