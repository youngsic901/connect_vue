package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.model.BuserDto;
import pack.repository.BuserProcess;

import java.util.List;

@RequestMapping("/buser")
@RestController
public class BuserController {
    @Autowired
    private BuserProcess buserProcess;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("GET 요청 정상 작동");
    }

    @GetMapping
    public ResponseEntity<List<BuserDto>> getAll(){
        List<BuserDto> busers = buserProcess.getAll();
        return ResponseEntity.ok(busers);
    }

    @GetMapping("/{buserno}")
    public ResponseEntity<BuserDto> getBuser(@PathVariable("buserno") int buserno){
        BuserDto buser = buserProcess.getBuser(buserno);

        if(buser == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(buser);
        }
    }

    @PostMapping
    public ResponseEntity<String> insertBuser(@RequestBody BuserDto buser){

        BuserDto existBuser = buserProcess.getBuser(buser.getBuserno());

        if(existBuser != null){
            return ResponseEntity.notFound().build();
        }

        buserProcess.insertBuser(buser);
        return ResponseEntity.ok("insert success");
    }

    @PutMapping("/updatebuser/{buserno}")
    public ResponseEntity<String> updateBuser(@PathVariable("buserno")int buserno,
                                              @RequestBody BuserDto buser){
        BuserDto existBuser = buserProcess.getBuser(buserno);

        if(existBuser == null){
            return ResponseEntity.notFound().build();
        }

        buser.setBuserno(buserno);
        buserProcess.updateBuser(buser);
        return ResponseEntity.ok("update success");
    }
}
