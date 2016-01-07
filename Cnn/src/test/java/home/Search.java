package home;

import commonApi.Base;
import org.testng.annotations.Test;

/**
 * Created by Shahida Lucky on 12/30/2015.
 */
public class Search extends Base {
    @Test
    public void test1(){
        clickOnCss("#search-button");
        typeOnCss("#search-input-field", "politics");
    }
}
