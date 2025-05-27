package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pack.model.JikwonDto;
import pack.repository.JikwonProcess;

import java.util.List;

@RequestMapping("/jikwon")
@RestController
public class JikwonController {
    @Autowired
    private JikwonProcess jikwonProcess;

    @GetMapping
    public ResponseEntity<List<JikwonDto>> getAllJikwon(){
        List<JikwonDto> busers = jikwonProcess.getAll();
        return ResponseEntity.ok(busers);
    }
}
