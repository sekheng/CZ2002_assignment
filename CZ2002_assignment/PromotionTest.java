package CZ2002_assignment;

import org.junit.Assert;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
* Test class for testing Promotions & Promotion Manager 
* @author  Chai Youxiang
* @version 1.0
* @since   2021-12-11
*/
public class PromotionTest {

    //Create a promotional set with a list of MenuItems
    //Requires subset of full menu, shouldn't use auto-generated list with MenuItemManager
    ArrayList<MenuItem> testPromoSet = new ArrayList<MenuItem>(Arrays.asList(
        new MenuItem(250,"vegetarian","sandwich","appetizer"),
        new MenuItem(500,"many mushrooms","mushroom risoto","maincourse"),
        new MenuItem(350,"cold","lemon tea","drinks")
    ));

    /**
     * Function to test the Promotion Manager
     * @param ArrayList<MenuItem> list  = testPromoSet
     * list is meant to be the promotional package containing items under a package price
     */
    @Test
    public void PromoMgrTest() {
        //Creation of Promotional Package using PromotionManager
        PromotionManager testPromoMgr = new PromotionManager();
        //Get Index by getting the Array of Promotions and returning it's length (append at the end)
        testPromoMgr.createPromotion("Vegetarian Set", 990, testPromoSet, testPromoMgr.getArrayOfPromotions().size());
        System.out.println(testPromoMgr.getArrayOfPromotions());
        //Manually create a list of promotions
        //Artificial Promotion List
        ArrayList<Promotion> artificialPromoList = new ArrayList<Promotion>();
        //Manually create the same promotion as above and append to articialPromotions
        Promotion artificialPromo = new Promotion(990, "Vegetarian Set", testPromoSet, artificialPromoList.size());
        //Append the articialPromo
        artificialPromoList.add(artificialPromo);
        System.out.println(artificialPromoList);
        //Check that both are created and initialized properly
        Assert.assertTrue("Both Promotion Set Lists are the NOT the same!", promoSetComparison(testPromoMgr.getArrayOfPromotions(), artificialPromoList));
    }

    /**
     * @param mgrList is the list created organically with PromotionManager
     * @param artList is the artificial list created manually by calling Promotion and appending
     * @return true if both arrays are the same, false otherwise
     */
    private static boolean promoSetComparison(ArrayList<Promotion> mgrList, ArrayList<Promotion> artList) {
        boolean comp = false;

        if (mgrList.size() != artList.size())
        {
            return false;
        }

        for (Promotion mgrPromoItem : mgrList)
        {
            for (Promotion artPromoItem : artList)
            {
                if (mgrPromoItem.getArrayOfItems() == artPromoItem.getArrayOfItems())
                {
                    comp = true;
                    break;
                }
                comp = false;
            }
        }
        return comp;
    }
}
