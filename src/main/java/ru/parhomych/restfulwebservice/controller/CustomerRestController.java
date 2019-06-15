package ru.parhomych.restfulwebservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.parhomych.restfulwebservice.model.Customer;
import ru.parhomych.restfulwebservice.model.Status;
import ru.parhomych.restfulwebservice.repository.CustomerDAO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class CustomerRestController {

    @Autowired
    CustomerDAO customerDAO;

    @GetMapping("/buyer")
    public List<Customer> getAllBuyers(){

        return customerDAO.findAll();
    }

    @GetMapping("/buyer/{id}")
    public ResponseEntity getConsumerById(@PathVariable(value = "id") Integer consId){
        Customer customer = null;
        try {
            customer = (Customer) customerDAO.findById(consId).orElseThrow(ResourceNotFoundException::new);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (customer != null){
            return ResponseEntity.ok().body(customer);
        } else {
            return ResponseEntity.ok().body(new Status("Customer with id " + consId + " was not found"));
        }


    }

    @PostMapping("/buyer/")
    public ResponseEntity<Status> saveCustomer(@RequestBody @Valid Customer customer){
        CustomerDAO cr = new CustomerDAO();
        Status status;
        cr.save(customer);
        status = new Status("Buyer added successfully");
        return new ResponseEntity<Status>(status, HttpStatus.OK);
    }

    @DeleteMapping("/buyer/{id}")
    public ResponseEntity<Status> deleteCustomerById(@PathVariable(value = "id") Integer consId){
        CustomerDAO cr = new CustomerDAO();
        Status status;
        if (cr.findById((int)consId).isPresent()){
            cr.deleteById(consId);
            status = new Status("Buyer " + consId + " deleted successfully");
        } else {
            status = new Status("Buyer " + consId + " was not found");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String StatusStr = objectMapper.writeValueAsString(status);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Status>(status, HttpStatus.OK);
    }

    @DeleteMapping("/buyer/")
    public ResponseEntity<Status> deleteAllCustomers(){
        CustomerDAO cr = new CustomerDAO();
        cr.deleteAll();
        return new ResponseEntity<Status>(new Status("All customers was deleted"), HttpStatus.OK);
    }

}
