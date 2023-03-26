package com.root.mgapi.service;

import com.root.mgapi.model.Produit;
import com.root.mgapi.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    // Methode pour récupérer la liste des produit
    public List<Produit> getListProduit(){
        return produitRepository.findAll();
    }

    // Methode pour recupérer un produit sachant son Id

    public Produit getProduitById(String id){
        return produitRepository.findById(id).orElseThrow(()->new RuntimeException("Message d'erreur!"));
    }

    // Methode pour sauvegarder un produit
    public Produit saveProduit(Produit produit){
        produit.setCodeProduit(UUID.randomUUID().toString());
        return produitRepository.save(produit);
    }
    // Methode pour modifier un produit
    public Produit updateProduit(Produit produit){
        return produitRepository.save(produit);
    }
    // Methode pour supprimer un produit
    public void deleteProduit(String id){
        produitRepository.deleteById(id);
    }

}
