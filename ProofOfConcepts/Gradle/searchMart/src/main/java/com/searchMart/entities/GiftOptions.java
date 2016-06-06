package com.searchMart.entities;
public class GiftOptions
{
    private String allowGiftMessage;

    private String allowGiftReceipt;

    private String allowGiftWrap;

    public String getAllowGiftMessage ()
    {
        return allowGiftMessage;
    }

    public void setAllowGiftMessage (String allowGiftMessage)
    {
        this.allowGiftMessage = allowGiftMessage;
    }

    public String getAllowGiftReceipt ()
    {
        return allowGiftReceipt;
    }

    public void setAllowGiftReceipt (String allowGiftReceipt)
    {
        this.allowGiftReceipt = allowGiftReceipt;
    }

    public String getAllowGiftWrap ()
    {
        return allowGiftWrap;
    }

    public void setAllowGiftWrap (String allowGiftWrap)
    {
        this.allowGiftWrap = allowGiftWrap;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [allowGiftMessage = "+allowGiftMessage+", allowGiftReceipt = "+allowGiftReceipt+", allowGiftWrap = "+allowGiftWrap+"]";
    }
}
		