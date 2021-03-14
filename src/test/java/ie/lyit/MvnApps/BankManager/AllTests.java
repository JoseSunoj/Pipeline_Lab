package ie.lyit.MvnApps.BankManager;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;

import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ CustomerTest.class, CustomerAccountManagerTest.class })
@SelectPackages("ie.lyit.MvnApps.BankManager")
/**
 * In eclipse Run As Junit-4
 * 
 * @author Sunoj Jose
 *
 */
public class AllTests {

}
