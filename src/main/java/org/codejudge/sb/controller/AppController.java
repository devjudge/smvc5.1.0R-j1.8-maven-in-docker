package org.codejudge.sb.controller;

import org.codejudge.sb.model.SumRequest;
import org.codejudge.sb.model.SumResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AppController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity helloWorld() {
        return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
    }

    @PostMapping(value = "/api/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity add2Nums(@RequestBody SumRequest request) {
        SumResponse sumResponse = new SumResponse();
        sumResponse.setSum(request.getNumber1() + request.getNumber2());
        return new ResponseEntity<>(sumResponse, HttpStatus.OK);
    }
}
