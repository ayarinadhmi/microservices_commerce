package com.mcommerce.clientui.proxies;


import com.mcommerce.clientui.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * decode404 = true
 * permet de passer l'erreur 404 et ainsi
 * d'eviter de declancher l erreur 404
 */
@FeignClient(name = "microservice-produit", url = "localhost:9001")
public interface MicroserviceProduitsProxy {

    @GetMapping(value = "/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);
}
