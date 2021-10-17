package com.example.PaymentService.controller;


import com.example.PaymentService.Entity.transaction;
import com.example.PaymentService.dto.TransactionDto;
import com.example.PaymentService.service.transactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/transaction")
public class transactionController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private transactionService TransactionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity confirmBooking(@RequestBody TransactionDto transactionDto){

        transaction newTransaction = modelMapper.map(transactionDto, transaction.class);
        transaction savedTransaction = TransactionService.incurtransaction(newTransaction);
        TransactionDto savedTransactionDto = modelMapper.map(savedTransaction, TransactionDto.class);

        return new ResponseEntity(savedTransactionDto.getTransactionId(), HttpStatus.CREATED);
    }
    @GetMapping(value ="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTransaction(@PathVariable(name="id") int id) {
        transaction getTransaction = TransactionService.gettransactiondetailsbyId(id);
        System.out.println(id);
        System.out.println(getTransaction);
        TransactionDto gotTransactionDTO = modelMapper.map(getTransaction, TransactionDto.class);
        return new ResponseEntity(gotTransactionDTO.getTransactionId(), HttpStatus.FOUND);
    }

}
