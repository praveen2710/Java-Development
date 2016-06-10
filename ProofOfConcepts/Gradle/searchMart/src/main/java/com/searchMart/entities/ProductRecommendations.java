package com.searchMart.entities;

import com.search.externalcalls.ProductRecommendationAPI;

/**
 * This will be the POJO that stores the retrieved result from 
 * the {@link ProductRecommendationAPI} .
 * 
 * All variable types are String for now.
 * @author praveen
 *
 */
public class ProductRecommendations
{
    private String ninetySevenCentShipping;

    private String affiliateAddToCartUrl;

    private String standardShipRate;

    private String customerRatingImage;

    private String thumbnailImage;

    private String brandName;

    private GiftOptions giftOptions;

    private String productTrackingUrl;

    private String stock;

    private String categoryNode;

    private String msrp;

    private String numReviews;

    private String freeShippingOver50Dollars;

    private String mediumImage;

    private String name;

    private String shipToStore;

    private String longDescription;

    private String addToCartUrl;

    private String bundle;

    private ImageEntities[] imageEntities;

    private String customerRating;

    private String maxItemsInOrder;

    private String largeImage;

    private String parentItemId;

    private String clearance;

    private String itemId;

    private String upc;

    private String categoryPath;

    private String availableOnline;

    private String shortDescription;

    private String color;

    private String productUrl;

    private String salePrice;

    private String freeShipToStore;

    private String preOrder;

    private String modelNumber;

    private BestMarketplacePrice bestMarketplacePrice;
    
    private ProductReview productReview;

    public String getNinetySevenCentShipping ()
    {
        return ninetySevenCentShipping;
    }

    public void setNinetySevenCentShipping (String ninetySevenCentShipping)
    {
        this.ninetySevenCentShipping = ninetySevenCentShipping;
    }

    public String getAffiliateAddToCartUrl ()
    {
        return affiliateAddToCartUrl;
    }

    public void setAffiliateAddToCartUrl (String affiliateAddToCartUrl)
    {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    public String getStandardShipRate ()
    {
        return standardShipRate;
    }

    public void setStandardShipRate (String standardShipRate)
    {
        this.standardShipRate = standardShipRate;
    }

    public String getCustomerRatingImage ()
    {
        return customerRatingImage;
    }

    public void setCustomerRatingImage (String customerRatingImage)
    {
        this.customerRatingImage = customerRatingImage;
    }

    public String getThumbnailImage ()
    {
        return thumbnailImage;
    }

    public void setThumbnailImage (String thumbnailImage)
    {
        this.thumbnailImage = thumbnailImage;
    }

    public String getBrandName ()
    {
        return brandName;
    }

    public void setBrandName (String brandName)
    {
        this.brandName = brandName;
    }

    public GiftOptions getGiftOptions ()
    {
        return giftOptions;
    }

    public void setGiftOptions (GiftOptions giftOptions)
    {
        this.giftOptions = giftOptions;
    }

    public String getProductTrackingUrl ()
    {
        return productTrackingUrl;
    }

    public void setProductTrackingUrl (String productTrackingUrl)
    {
        this.productTrackingUrl = productTrackingUrl;
    }

    public String getStock ()
    {
        return stock;
    }

    public void setStock (String stock)
    {
        this.stock = stock;
    }

    public String getCategoryNode ()
    {
        return categoryNode;
    }

    public void setCategoryNode (String categoryNode)
    {
        this.categoryNode = categoryNode;
    }

    public String getMsrp ()
    {
        return msrp;
    }

    public void setMsrp (String msrp)
    {
        this.msrp = msrp;
    }

    public String getNumReviews ()
    {
        return numReviews;
    }

    public void setNumReviews (String numReviews)
    {
        this.numReviews = numReviews;
    }

    public String getFreeShippingOver50Dollars ()
    {
        return freeShippingOver50Dollars;
    }

    public void setFreeShippingOver50Dollars (String freeShippingOver50Dollars)
    {
        this.freeShippingOver50Dollars = freeShippingOver50Dollars;
    }

    public String getMediumImage ()
    {
        return mediumImage;
    }

    public void setMediumImage (String mediumImage)
    {
        this.mediumImage = mediumImage;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getShipToStore ()
    {
        return shipToStore;
    }

    public void setShipToStore (String shipToStore)
    {
        this.shipToStore = shipToStore;
    }

    public String getLongDescription ()
    {
        return longDescription;
    }

    public void setLongDescription (String longDescription)
    {
        this.longDescription = longDescription;
    }

    public String getAddToCartUrl ()
    {
        return addToCartUrl;
    }

    public void setAddToCartUrl (String addToCartUrl)
    {
        this.addToCartUrl = addToCartUrl;
    }

    public String getBundle ()
    {
        return bundle;
    }

    public void setBundle (String bundle)
    {
        this.bundle = bundle;
    }

    public ImageEntities[] getImageEntities ()
    {
        return imageEntities;
    }

    public void setImageEntities (ImageEntities[] imageEntities)
    {
        this.imageEntities = imageEntities;
    }

    public String getCustomerRating ()
    {
        return customerRating;
    }

    public void setCustomerRating (String customerRating)
    {
        this.customerRating = customerRating;
    }

    public String getMaxItemsInOrder ()
    {
        return maxItemsInOrder;
    }

    public void setMaxItemsInOrder (String maxItemsInOrder)
    {
        this.maxItemsInOrder = maxItemsInOrder;
    }

    public String getLargeImage ()
    {
        return largeImage;
    }

    public void setLargeImage (String largeImage)
    {
        this.largeImage = largeImage;
    }

    public String getParentItemId ()
    {
        return parentItemId;
    }

    public void setParentItemId (String parentItemId)
    {
        this.parentItemId = parentItemId;
    }

    public String getClearance ()
    {
        return clearance;
    }

    public void setClearance (String clearance)
    {
        this.clearance = clearance;
    }

    public String getItemId ()
    {
        return itemId;
    }

    public void setItemId (String itemId)
    {
        this.itemId = itemId;
    }

    public String getUpc ()
    {
        return upc;
    }

    public void setUpc (String upc)
    {
        this.upc = upc;
    }

    public String getCategoryPath ()
    {
        return categoryPath;
    }

    public void setCategoryPath (String categoryPath)
    {
        this.categoryPath = categoryPath;
    }

    public String getAvailableOnline ()
    {
        return availableOnline;
    }

    public void setAvailableOnline (String availableOnline)
    {
        this.availableOnline = availableOnline;
    }

    public String getShortDescription ()
    {
        return shortDescription;
    }

    public void setShortDescription (String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public String getColor ()
    {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public String getProductUrl ()
    {
        return productUrl;
    }

    public void setProductUrl (String productUrl)
    {
        this.productUrl = productUrl;
    }

    public String getSalePrice ()
    {
        return salePrice;
    }

    public void setSalePrice (String salePrice)
    {
        this.salePrice = salePrice;
    }

    public String getFreeShipToStore ()
    {
        return freeShipToStore;
    }

    public void setFreeShipToStore (String freeShipToStore)
    {
        this.freeShipToStore = freeShipToStore;
    }

    public String getPreOrder ()
    {
        return preOrder;
    }

    public void setPreOrder (String preOrder)
    {
        this.preOrder = preOrder;
    }

    public String getModelNumber ()
    {
        return modelNumber;
    }

    public void setModelNumber (String modelNumber)
    {
        this.modelNumber = modelNumber;
    }

    public BestMarketplacePrice getBestMarketplacePrice ()
    {
        return bestMarketplacePrice;
    }

    public void setBestMarketplacePrice (BestMarketplacePrice bestMarketplacePrice)
    {
        this.bestMarketplacePrice = bestMarketplacePrice;
    }

    public ProductReview getProductReview() {
		return productReview;
	}

	public void setProductReview(ProductReview productReview) {
		this.productReview = productReview;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [ninetySevenCentShipping = "+ninetySevenCentShipping+", affiliateAddToCartUrl = "+affiliateAddToCartUrl+", standardShipRate = "+standardShipRate+", customerRatingImage = "+customerRatingImage+", thumbnailImage = "+thumbnailImage+", brandName = "+brandName+", giftOptions = "+giftOptions+", productTrackingUrl = "+productTrackingUrl+", stock = "+stock+", categoryNode = "+categoryNode+", msrp = "+msrp+", numReviews = "+numReviews+", freeShippingOver50Dollars = "+freeShippingOver50Dollars+", mediumImage = "+mediumImage+", name = "+name+", shipToStore = "+shipToStore+", longDescription = "+longDescription+", addToCartUrl = "+addToCartUrl+", bundle = "+bundle+", imageEntities = "+imageEntities+", customerRating = "+customerRating+", maxItemsInOrder = "+maxItemsInOrder+", largeImage = "+largeImage+", parentItemId = "+parentItemId+", clearance = "+clearance+", itemId = "+itemId+", upc = "+upc+", categoryPath = "+categoryPath+", availableOnline = "+availableOnline+", shortDescription = "+shortDescription+", color = "+color+", productUrl = "+productUrl+", salePrice = "+salePrice+", freeShipToStore = "+freeShipToStore+", preOrder = "+preOrder+", modelNumber = "+modelNumber+", bestMarketplacePrice = "+bestMarketplacePrice+"]";
    }
}
