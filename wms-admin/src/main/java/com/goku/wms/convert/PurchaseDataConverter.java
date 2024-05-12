package com.goku.wms.convert;

import com.goku.common.model.entity.Purchase;
import com.goku.wms.form.PurchaseFormResource;
import com.goku.wms.response.PurchaseResource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class PurchaseDataConverter {
    public Function<PurchaseFormResource,Purchase> convertToPurchase(PurchaseFormResource purchaseFormResource) {
       return purchaseForm -> {
           Purchase purchase = new Purchase();
           BeanUtils.copyProperties(purchaseForm,purchase);
           return purchase;
       };
    }

    public Function<Purchase, PurchaseResource> convertToPurchaseResource(Purchase purchase) {
        return purchaseForm -> {
            PurchaseResource purchaseResource = new PurchaseResource();
            BeanUtils.copyProperties(purchaseForm,purchaseResource);
            return purchaseResource;
        };
    }
}
