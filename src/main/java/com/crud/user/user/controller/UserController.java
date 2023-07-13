package com.crud.user.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.user.user.model.ServicesResponse;
import com.crud.user.user.model.User;
import com.crud.user.user.service.IUserServices;

@RestController
@RequestMapping("user")
@CrossOrigin("*")

public class UserController {

    @Autowired
    private IUserServices iUserServices;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){
        var result= iUserServices.findAll();
        return  new ResponseEntity<>(result, HttpStatus.OK); 
    }

    @PostMapping("/save")
    public ResponseEntity<ServicesResponse> save(@RequestBody User user){
        ServicesResponse s = new ServicesResponse();
        int result = iUserServices.save(user);
        if(result==1){
            s.setMessage("Usuario guardado exitosamente");
        }return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServicesResponse> update (@RequestBody User user){
        ServicesResponse s =new ServicesResponse();
        int result = iUserServices.update(user);
        if (result == 1) {  
            s.setMessage ("Datos actualizados correctamente ");
        }
        return new ResponseEntity<>(s, HttpStatus.OK);

    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<ServicesResponse> update(@PathVariable int id){
        ServicesResponse s = new ServicesResponse ();
        int result = iUserServices.delete(id);
        if(result==1){
            s.setMessage("Registro eliminado con éxito.");
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    @GetMapping("listarporid/{id}")
    public ResponseEntity<User> listid(@PathVariable int id){
        User u = iUserServices.findById(id);
        return new ResponseEntity<User>(u, HttpStatus.OK);
    }
    @GetMapping("{listActivos}")
    public ResponseEntity<List<User>> listActivo(){
        var result=iUserServices.findAllActive();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
