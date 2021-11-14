package CZ2002_assignment;

import org.junit.Assert;
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
     * Test PromotionManager against manually created Promotion Set
     * @param ArrayList<MenuItem> list  = testPromoSet
     * The above params are meant to be the 'promotional sets' in use for testing
     * This function to see if PromotionManager is working as intended against a manually
     *  created Promotion List
     */
    @Test
    public void PromoMgrTest() {
        //Creation of Promotional Package using PromotionManager
        PromotionManager testPromoMgr = new PromotionManager();
        //Get Index by getting the Array of Promotions and returning it's length (append at the end)
        //Manually create a list of promotions
        //Artificial Promotion List
        ArrayList<Promotion> artificialPromoList = new ArrayList<Promotion>();
        //Manually create the same promotion as above and append to articialPromotions
        Promotion artificialPromo = new Promotion(990, "Vegetarian Set", testPromoSet, artificialPromoList.size());
        testPromoMgr.addPromo(artificialPromo);
        //Append the articialPromo
        artificialPromoList.add(artificialPromo);
        //Check that both are created and initialized properly
        Assert.assertTrue("Both Promotion Set Lists are NOT the same!", promoSetComparison(testPromoMgr.getArrayOfPromotions(), artificialPromoList));
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
            return comp;
        }

        for (int i = 0; i < mgrList.size(); i++)
        {
            Promotion mgrPromo = mgrList.get(i);
            Promotion artPromo = artList.get(i);
            //Check their name
            String mgrPromoName = mgrPromo.getName();
            String artPromoName = artPromo.getName();
            System.out.println(mgrPromoName + "=" + artPromoName);
            //Check their price
            int mgrPromoPrice = mgrPromo.getPriceInCents();
            int artPromoPrice = artPromo.getPriceInCents();
            //Cbeck their contents. TestingBothItemArray function defined in MenuItemTesting
            ArrayList<MenuItem> mgrListItem = mgrPromo.getArrayOfItems();
            ArrayList<MenuItem> artListItem = artPromo.getArrayOfItems();

            comp =  (mgrPromoName == artPromoName) && 
                    (mgrPromoPrice == artPromoPrice) && 
                    MenuItemTesting.TestingBothItemArrays(mgrListItem, artListItem);

            if (comp == false) {
                return comp;
            }
        }

        return comp;
    }
}