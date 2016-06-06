package com.searchMart.entities;


public class ReviewStatistics
{
private RatingDistributions[] ratingDistributions;

private String averageOverallRating;

private String totalReviewCount;

private String overallRatingRange;

public RatingDistributions[] getRatingDistributions ()
{
return ratingDistributions;
}

public void setRatingDistributions (RatingDistributions[] ratingDistributions)
{
this.ratingDistributions = ratingDistributions;
}

public String getAverageOverallRating ()
{
return averageOverallRating;
}

public void setAverageOverallRating (String averageOverallRating)
{
this.averageOverallRating = averageOverallRating;
}

public String getTotalReviewCount ()
{
return totalReviewCount;
}

public void setTotalReviewCount (String totalReviewCount)
{
this.totalReviewCount = totalReviewCount;
}

public String getOverallRatingRange ()
{
return overallRatingRange;
}

public void setOverallRatingRange (String overallRatingRange)
{
this.overallRatingRange = overallRatingRange;
}

@Override
public String toString()
{
return "ClassPojo [ratingDistributions = "+ratingDistributions+", averageOverallRating = "+averageOverallRating+", totalReviewCount = "+totalReviewCount+", overallRatingRange = "+overallRatingRange+"]";
}
}