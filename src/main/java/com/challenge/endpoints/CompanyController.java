package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id")Long id){
    Optional<Company> seTemCmpny = companyService.findById(id);

    return seTemCmpny.isPresent()? ResponseEntity.ok(seTemCmpny.get())
            : ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Company>> findAllCompanyByAccelerationOrUserId(
           @RequestParam(name = "accelerationId",required = false)Long accelerationId,
           @RequestParam(name = "userId",required = false)Long userId
    ){
    List<Company> cmpnis;
    cmpnis =companyService.findByAccelerationId(accelerationId);
    cmpnis.addAll(companyService.findByUserId(userId));

        return ResponseEntity.ok(cmpnis);
    }
}
