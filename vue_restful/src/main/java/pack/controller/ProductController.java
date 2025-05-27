package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.dto.ProductDto;
import pack.repository.ProductProcess;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private ProductProcess productProcess;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> products = productProcess.getAll();
        return ResponseEntity.ok(products);
//        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductDto> getData(@PathVariable("code")String code){
        ProductDto product = productProcess.getData(code);

        if(product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ProductDto dto) {
        productProcess.insert(dto);
        return ResponseEntity.ok("insert success");
    }

    @PutMapping("/{code}")
    public ResponseEntity<String> update(@PathVariable("code")String code,
                                         @RequestBody ProductDto dto) {
        // 수정 대상 자료 읽기
        ProductDto existProduct = productProcess.getData(code);

        if(existProduct == null) {
            return ResponseEntity.notFound().build();
        }

        // 수정 진행
        dto.setCode(code);
        productProcess.update(dto);
        return ResponseEntity.ok("update success");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable("code")String code) {
        // 삭제 대상 자료 일기
        ProductDto existProduct = productProcess.getData(code);

        if(existProduct == null) {
            return ResponseEntity.notFound().build();
        }

        //삭제 진행
        productProcess.delete(code);
        return ResponseEntity.ok("delete success");
    }

}
