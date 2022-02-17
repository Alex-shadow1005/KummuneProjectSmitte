package com.examplelag.kummuneprojectsmitte.controller;

import com.examplelag.kummuneprojectsmitte.Model.County;
import com.examplelag.kummuneprojectsmitte.Repo.CountyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountyRESTController {

    @Autowired
    CountyRepo countyRepo;


    @GetMapping("/counties")
    public List<County> getAllCounties(){
        return countyRepo.findAll();

    }



    @GetMapping("/")
    public String test(){
        return "hallo world";
    }

    @GetMapping("/county/{id}")
    public County countyId(@PathVariable String id){
       Optional<County> obj = countyRepo.findById(id);

       if (obj.isPresent()){
           return obj.get();
        } else {
           return null;
        }
    }

    @PostMapping("/county")
    @ResponseStatus(HttpStatus.CREATED)
    public County postCounty(@RequestBody County county) {
        System.out.println(county);
        return countyRepo.save(county);

    }

    @PutMapping("/county{id}")
    public ResponseEntity<County> updateCounty(@PathVariable String id, @RequestBody County county) {
        Optional<County> optionalCounty = countyRepo.findById(id);
        if (optionalCounty.isPresent()) {
            countyRepo.save(county);
            return new ResponseEntity<County>(county, HttpStatus.OK);
        } else {
            County notfoundCounty = new County();
            notfoundCounty.setName("kan ikke find id=" + id);
            return new ResponseEntity<County>(notfoundCounty,HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/county/{id}")
    public ResponseEntity<String> deleteCounty(@PathVariable String id) {
        try {
            countyRepo.deleteById(id);
            return new ResponseEntity<>("slettet id =" +id, HttpStatus.OK);
        } catch (Exception Err){
            return new ResponseEntity<>("jeg kunne ikke slette id =" + id, HttpStatus.NOT_FOUND);
        }
        }




}
