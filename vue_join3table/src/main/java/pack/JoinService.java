package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoinService {

    private VueJoin3tableApplication vueJoin3tableApplication;

    @Autowired
    private BuserRepository buserRepository;
    @Autowired
    private JikwonRepository jikwonRepository;
    @Autowired
    private GogekRepository gogekRepository;

    JoinService(VueJoin3tableApplication vueJoin3tableApplication) {
        this.vueJoin3tableApplication = vueJoin3tableApplication;
    }

    public List<BuserJikwonGogekDTO> getJoinedData() {
        return buserRepository.findAllJoinedData();
    }

    public List<Buser> getAllBusers() {
        return buserRepository.findAll();
    }

    public List<JikwonDto> getAllJikwons() {
        return jikwonRepository.findAll().stream()
                .map(jikwon -> new JikwonDto(
                        jikwon.getJikwonno(),
                        jikwon.getJikwonname(),
                        jikwon.getBuser().getBusername(),
                        jikwon.getJikwonjik(),
                        jikwon.getJikwonpay(),
                        jikwon.getJikwonibsail().toString(),
                        jikwon.getJikwongen(),
                        jikwon.getJikwonrating()
                ))
                .collect(Collectors.toList());
    }

    public List<Gogek> getAllGogeks() {
        return gogekRepository.findAll();
    }
}
