package com.searchMart.entities;

public class OverallRating
{
    private String label;

    private String rating;

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [label = "+label+", rating = "+rating+"]";
    }
}
	