package com.mcommerce.clientui.exceptions;

import feign.codec.ErrorDecoder;
import feign.Response;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoqueur, Response reponse) {

        if(reponse.status() == 400 ) {
            return new ProductBadRequestException(
                    "Requête incorrecte "
            );
        }

        else if (reponse.status() == 404 ) {
            return new ProductNotFoundException(
                    "Produit non trouvé "
            );
        }

        return defaultErrorDecoder.decode(invoqueur, reponse);
    }
}
