package com.searchMart.entities;

public class ImageEntities
{
    private String mediumImage;

    private String largeImage;

    private String entityType;

    private String thumbnailImage;

    public String getMediumImage ()
    {
        return mediumImage;
    }

    public void setMediumImage (String mediumImage)
    {
        this.mediumImage = mediumImage;
    }

    public String getLargeImage ()
    {
        return largeImage;
    }

    public void setLargeImage (String largeImage)
    {
        this.largeImage = largeImage;
    }

    public String getEntityType ()
    {
        return entityType;
    }

    public void setEntityType (String entityType)
    {
        this.entityType = entityType;
    }

    public String getThumbnailImage ()
    {
        return thumbnailImage;
    }

    public void setThumbnailImage (String thumbnailImage)
    {
        this.thumbnailImage = thumbnailImage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [mediumImage = "+mediumImage+", largeImage = "+largeImage+", entityType = "+entityType+", thumbnailImage = "+thumbnailImage+"]";
    }
}
	
