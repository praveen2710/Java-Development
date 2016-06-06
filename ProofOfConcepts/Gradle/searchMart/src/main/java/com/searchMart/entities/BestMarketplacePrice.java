package com.searchMart.entities;

public class BestMarketplacePrice
{
    private String price;

    private String availableOnline;

    private String sellerInfo;

    private String standardShipRate;

    private String clearance;

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getAvailableOnline ()
    {
        return availableOnline;
    }

    public void setAvailableOnline (String availableOnline)
    {
        this.availableOnline = availableOnline;
    }

    public String getSellerInfo ()
    {
        return sellerInfo;
    }

    public void setSellerInfo (String sellerInfo)
    {
        this.sellerInfo = sellerInfo;
    }

    public String getStandardShipRate ()
    {
        return standardShipRate;
    }

    public void setStandardShipRate (String standardShipRate)
    {
        this.standardShipRate = standardShipRate;
    }

    public String getClearance ()
    {
        return clearance;
    }

    public void setClearance (String clearance)
    {
        this.clearance = clearance;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [price = "+price+", availableOnline = "+availableOnline+", sellerInfo = "+sellerInfo+", standardShipRate = "+standardShipRate+", clearance = "+clearance+"]";
    }
}
