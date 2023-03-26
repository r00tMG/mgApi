package com.root.mgapi.controller;

import com.root.mgapi.model.Produit;
import com.root.mgapi.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produit")
public class ProduitController {
    public final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    //Api pour la recupération des produit
    @GetMapping("/listproduit")
    public ResponseEntity<List<Produit>> getListProduit(){
        List<Produit> produitlist = produitService.getListProduit();
        return new ResponseEntity<>(produitlist, HttpStatus.OK);

    }
    //Api pour la recuperation des produit sachant l'id
    @GetMapping("/produitId/{id}")
    public ResponseEntity<Produit> getIdProduit(@PathVariable String id){
        Produit produitbyid = produitService.getProduitById(id);
        return new ResponseEntity<>(produitbyid, HttpStatus.OK);
    }
    //Api pour l'ajout ou la sauvegarde de produit
    @PostMapping("/saveproduit")
    public ResponseEntity<Produit> saveProduit(@RequestBody Produit produit) {
        Produit produitsave = produitService.saveProduit(produit);
        return new ResponseEntity<>(produitsave, HttpStatus.CREATED);
    }

    //Api pour modifier un produit
    @PutMapping("/updateproduit")
    public ResponseEntity<Produit> updateSaveProduit(@RequestBody Produit produit){
        Produit updatesaveproduit = produitService.updateProduit(produit);
        return new ResponseEntity<>(updatesaveproduit, HttpStatus.CREATED);
    }
    //Api pour supprimer un produit
    @DeleteMapping("deleteProduit/{id}")
    public ResponseEntity<?> supProduit(@PathVariable("id") String id){
         produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
