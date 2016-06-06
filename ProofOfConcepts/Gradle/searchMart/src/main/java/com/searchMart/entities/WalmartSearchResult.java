package com.searchMart.entities;

import com.search.externalcalls.SearchProductAPI;

/**
 * This will be the POJO that stores the retrieved result from 
 * the {@link SearchProductAPI} class.
 * 
 * All variable types are String for now.
 * @author praveen
 *
 */
public class WalmartSearchResult
{
    private String sort;

    private Items[] items;

    private String start;

    private String totalResults;

    private String query;

    private String[] facets;

    private String responseGroup;

    private String numItems;

    public String getSort ()
    {
        return sort;
    }

    public void setSort (String sort)
    {
        this.sort = sort;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    public String getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (String totalResults)
    {
        this.totalResults = totalResults;
    }

    public String getQuery ()
    {
        return query;
    }

    public void setQuery (String query)
    {
        this.query = query;
    }

    public String[] getFacets ()
    {
        return facets;
    }

    public void setFacets (String[] facets)
    {
        this.facets = facets;
    }

    public String getResponseGroup ()
    {
        return responseGroup;
    }

    public void setResponseGroup (String responseGroup)
    {
        this.responseGroup = responseGroup;
    }

    public String getNumItems ()
    {
        return numItems;
    }

    public void setNumItems (String numItems)
    {
        this.numItems = numItems;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sort = "+sort+", items = "+items+", start = "+start+", totalResults = "+totalResults+", query = "+query+", facets = "+facets+", responseGroup = "+responseGroup+", numItems = "+numItems+"]";
    }
}
			
			