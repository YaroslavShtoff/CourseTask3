package pro.sky.cw3.coursetask3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.cw3.coursetask3.model.SockItem;
import pro.sky.cw3.coursetask3.service.StoreService;

@RestController
@RequestMapping("/api/socks")
public class StoreController<cottonMax> {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public ResponseEntity<?> coming(@RequestBody SockItem sockItem){
        storeService.coming(sockItem);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> consumption(@RequestBody SockItem sockItem){
        storeService.consumption(sockItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Integer> count(@RequestParam String color,
                                         @RequestParam float size,
                                         @RequestParam(required = false, defaultValue = "0")  int cottonMin,
                                         @RequestParam(required = false, defaultValue = "100")  int cottonMax) {
      int available = storeService.count(color, size, cottonMin, cottonMax);
        return ResponseEntity.ok(available);
    }

    @DeleteMapping
    public ResponseEntity<?> remove (@RequestBody SockItem sockItem){
        storeService.consumption(sockItem);
        return ResponseEntity.ok().build();
    }
}
