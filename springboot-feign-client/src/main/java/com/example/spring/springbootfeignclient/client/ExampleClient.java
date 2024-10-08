package com.example.spring.springbootfeignclient.client;

import com.example.spring.springbootfeignclient.dto.DataRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "exampleClient", url = "${feign-data.url}")
public interface ExampleClient {

    // GET 요청 (데이터 조회)
    @GetMapping("/api/data/{id}")
    String getData(@PathVariable("id") Long id);

    // POST 요청 (데이터 생성)
    @PostMapping("/api/data")
    String createData(@RequestBody DataRequest dataRequest);

    // PUT 요청 (데이터 수정)
    @PutMapping("/api/data/{id}")
    String updateData(@PathVariable("id") Long id, @RequestBody DataRequest dataRequest);

    // DELETE 요청 (데이터 삭제)
    @DeleteMapping("/api/data/{id}")
    String deleteData(@PathVariable("id") Long id);
}
