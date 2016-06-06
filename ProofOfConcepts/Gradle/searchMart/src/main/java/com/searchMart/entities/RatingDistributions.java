package com.searchMart.entities;

public class RatingDistributions
{
    private String ratingValue;

    private String count;

    public String getRatingValue ()
    {
        return ratingValue;
    }

    public void setRatingValue (String ratingValue)
    {
        this.ratingValue = ratingValue;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ratingValue = "+ratingValue+", count = "+count+"]";
    }
}
