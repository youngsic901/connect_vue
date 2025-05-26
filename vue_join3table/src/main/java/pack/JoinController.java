package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://127.0.0.1:5500"})   //cors 정책 허용
public class JoinController {
    @Autowired
    private JoinService joinService;

    @GetMapping("/joindata")
    public List<BuserJikwonGogekDTO> getJoinData(){
        return joinService.getJoinedData();
    }

    @GetMapping("/busers")
    public List<Buser> getAllBusers(){
        return joinService.getAllBusers();
    }

    @GetMapping("/jikwons")
    public List<JikwonDto> getAllJikwons(){
        return joinService.getAllJikwons();
    }

    @GetMapping("/gogeks")
    public List<Gogek> getAllGogeks(){
        return joinService.getAllGogeks();
    }
}
