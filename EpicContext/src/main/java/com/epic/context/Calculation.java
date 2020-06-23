package com.epic.context;

enum Customer{ 
	REGULAR, PREMIUM 
}

class Calculation
{
	/**
	*This method will calculate bill amount based on customer type and purchase amount
	*
	* @param customerType customer type such as Regular and Premium
	* @param amount Purchase amount
	* @return bill amount
	*/
    public static double calculate(Customer customerType, Integer purchaseAmount)
    {
    	double billAmount = 0;
    	  switch(customerType) {
          case REGULAR:
        	  billAmount=calculateRegularAmount(purchaseAmount);
            break;
          case PREMIUM:
        	  billAmount=calculatePremiumAmount(purchaseAmount);
            break;
        }
        return purchaseAmount-billAmount;
    }
    
    /**
	*This method will calculate bill amount for Regular Customer
	*
	* @param amount Purchase amount
	* @return bill amount
	*/
    public static double calculateRegularAmount(Integer purchaseAmount)
    {
    	double calcAmount=0;
    	if(purchaseAmount <= Constants.REGULAR_SLAB_1_MAX)
    	{
    		calcAmount= 0;
    	}
    	else if(purchaseAmount <= Constants.REGULAR_SLAB_2_MAX)
    	{
    		calcAmount=((Constants.REGULAR_SLAB_2_MAX-(purchaseAmount-Constants.REGULAR_SLAB_1_MAX))*Constants.REGULAR_SLAB_1_DISCOUNT_PERCENTAGE);
    	}
    	else
    	{
    		calcAmount=(Constants.REGULAR_SLAB_1_MAX*Constants.REGULAR_SLAB_1_DISCOUNT_PERCENTAGE)+((purchaseAmount-Constants.REGULAR_SLAB_2_MAX)*Constants.REGULAR_SLAB_2_DISCOUNT_PERCENTAGE);
    	}
    	return calcAmount;
    }
    
    /**
	*This method will calculate bill amount for Premium Customer
	*
	* @param amount Purchase amount
	* @return bill amount
	*/
    public static double calculatePremiumAmount(Integer purchaseAmount)
    {
    	double calcAmount=0;
    	if(purchaseAmount <= Constants.PREMIUM_SLAB_1_MAX)
    	{
    		calcAmount= purchaseAmount*Constants.PREMIUM_SLAB_1_DISCOUNT_PERCENTAGE;
    	}
    	else if(purchaseAmount <= Constants.PREMIUM_SLAB_2_MAX)
    	{
    		calcAmount=(Constants.PREMIUM_SLAB_1_MAX*Constants.PREMIUM_SLAB_1_DISCOUNT_PERCENTAGE)+((Constants.PREMIUM_SLAB_2_MAX-(purchaseAmount-Constants.PREMIUM_SLAB_1_MAX))*Constants.PREMIUM_SLAB_2_DISCOUNT_PERCENTAGE);
    	}
    	else if(purchaseAmount <= Constants.PREMIUM_SLAB_3_MAX)
    	{
    		calcAmount=(Constants.PREMIUM_SLAB_1_MAX*Constants.PREMIUM_SLAB_1_DISCOUNT_PERCENTAGE)+(Constants.PREMIUM_SLAB_1_MAX*Constants.PREMIUM_SLAB_2_DISCOUNT_PERCENTAGE)+((purchaseAmount-Constants.PREMIUM_SLAB_2_MAX)*Constants.PREMIUM_SLAB_3_DISCOUNT_PERCENTAGE);
    	}
    	else
    	{
    		calcAmount=(Constants.PREMIUM_SLAB_1_MAX*Constants.PREMIUM_SLAB_1_DISCOUNT_PERCENTAGE)+(Constants.PREMIUM_SLAB_1_MAX*Constants.PREMIUM_SLAB_2_DISCOUNT_PERCENTAGE)+(Constants.PREMIUM_SLAB_1_MAX*Constants.PREMIUM_SLAB_3_DISCOUNT_PERCENTAGE)+((purchaseAmount-Constants.PREMIUM_SLAB_3_MAX)*Constants.PREMIUM_SLAB_4_DISCOUNT_PERCENTAGE);
    	}
    	return calcAmount;
    }
    
}