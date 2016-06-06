package com.searchMart.entities;

import com.search.externalcalls.ReviewsAPI;

/**
 * This is the main POJO to store response
 * recieved from {@link ReviewsAPI}
 * @author praveen
 *
 */
public class ProductReview
{
    private String categoryPath;

    private String productTrackingUrl;

    private Reviews[] reviews;

    private String categoryNode;

    private String availableOnline;

    private String productUrl;

    private String name;

    private ReviewStatistics reviewStatistics;

    private String salePrice;

    private String itemId;

    private String brandName;

    private String upc;

    public String getCategoryPath ()
    {
        return categoryPath;
    }

    public void setCategoryPath (String categoryPath)
    {
        this.categoryPath = categoryPath;
    }

    public String getProductTrackingUrl ()
    {
        return productTrackingUrl;
    }

    public void setProductTrackingUrl (String productTrackingUrl)
    {
        this.productTrackingUrl = productTrackingUrl;
    }

    public Reviews[] getReviews ()
    {
        return reviews;
    }

    public void setReviews (Reviews[] reviews)
    {
        this.reviews = reviews;
    }

    public String getCategoryNode ()
    {
        return categoryNode;
    }

    public void setCategoryNode (String categoryNode)
    {
        this.categoryNode = categoryNode;
    }

    public String getAvailableOnline ()
    {
        return availableOnline;
    }

    public void setAvailableOnline (String availableOnline)
    {
        this.availableOnline = availableOnline;
    }

    public String getProductUrl ()
    {
        return productUrl;
    }

    public void setProductUrl (String productUrl)
    {
        this.productUrl = productUrl;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public ReviewStatistics getReviewStatistics ()
    {
        return reviewStatistics;
    }

    public void setReviewStatistics (ReviewStatistics reviewStatistics)
    {
        this.reviewStatistics = reviewStatistics;
    }

    public String getSalePrice ()
    {
        return salePrice;
    }

    public void setSalePrice (String salePrice)
    {
        this.salePrice = salePrice;
    }

    public String getItemId ()
    {
        return itemId;
    }

    public void setItemId (String itemId)
    {
        this.itemId = itemId;
    }

    public String getBrandName ()
    {
        return brandName;
    }

    public void setBrandName (String brandName)
    {
        this.brandName = brandName;
    }

    public String getUpc ()
    {
        return upc;
    }

    public void setUpc (String upc)
    {
        this.upc = upc;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [categoryPath = "+categoryPath+", productTrackingUrl = "+productTrackingUrl+", reviews = "+reviews+", categoryNode = "+categoryNode+", availableOnline = "+availableOnline+", productUrl = "+productUrl+", name = "+name+", reviewStatistics = "+reviewStatistics+", salePrice = "+salePrice+", itemId = "+itemId+", brandName = "+brandName+", upc = "+upc+"]";
    }
}
		
