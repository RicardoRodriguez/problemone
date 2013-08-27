package net.itr2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { ConnectionMemoryTest.class, 
						RailMapTest.class, 
						RailMapAllRoutes.class })
public class AllTests {

}
