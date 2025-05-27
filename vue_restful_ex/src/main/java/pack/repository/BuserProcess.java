package pack.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pack.model.BuserDto;
import pack.model.BuserRepository;

import java.util.List;

@Repository
public class BuserProcess {
    @Autowired
    private BuserRepository buserRepository;

    public List<BuserDto> getAll() {
        return buserRepository.findAll();
    }

    public BuserDto getBuser(int buserNo) {
        if(buserRepository.findById(buserNo).isPresent()) {
            return buserRepository.findById(buserNo).get();
        } else {
            return null;
        }
    }

    public void insertBuser(BuserDto dto) {
        if(buserRepository.existsById(dto.getBuserno())) {
            throw new IllegalArgumentException("이미 존재하는 부서 입니다.");
        }
        buserRepository.save(dto);
    }

    public void updateBuser(BuserDto dto) {
        if(!buserRepository.existsById(dto.getBuserno())) {
            throw new IllegalArgumentException("해당 부서가 이미 존재합니다.");
        }
        buserRepository.save(dto);
    }
}
