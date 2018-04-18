package edu.iupui.cs.cs450;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeTest
{
  @Test
  /*
   * This test method tests the 'static Time getCurrentTime ()' method
   */
  public void testgetCurrentTime ()
  {

    Time t_gCurTime1 = Time.getCurrentTime();
    Time t_gCurTime2 = Time.getCurrentTime();

    Assert.assertEquals (t_gCurTime1.getSeconds(), t_gCurTime2.getSeconds());
  }

  @Test
  /*
   * This test method tests the 'Time ()' default constructor
   */
  public void testConstructor ()
  {
    Time t = new Time ();

    Assert.assertEquals (0, t.getSeconds ());
    Assert.assertEquals (0, t.getNanosecs ());
  }

  @Test
  /*
   * This test method tests the 'Time (long millis)' constructor
   */
  public void testInitializingConstructor1 ()
  {
    Time t_millis = new Time (1000);

    Assert.assertEquals (1, t_millis.getSeconds());
    Assert.assertEquals (0, t_millis.getNanosecs());
  }

  @Test
  /*
   * This test method tests the 'Time (int second, int nanosec)' constructor
   */
  public void testInitializingConstructor2 ()
  {
    Time t_sec_nanoSec = new Time (10, 20);

    Assert.assertEquals (10, t_sec_nanoSec.getSeconds());
    Assert.assertEquals (20, t_sec_nanoSec.getNanosecs());
  }

  @Test
  /*
   * This test method tests the set methods 'void setSeconds (int sec)' and void setNanosecs (int nanosec)
   */
  public void testSetters ()
  {
    Time t_set = new Time ();
    t_set.setSeconds(10);
    t_set.setNanosecs(20);

    Assert.assertEquals (10, t_set.getSeconds());
    Assert.assertEquals (20, t_set.getNanosecs());
  }

  @Test
  /*
   * This test method tests the 'long convert (TimeUnit dstTimeUnit)' method
   */
  public void testConvert ()
  {
    Time t_convert = new Time (1, 0);

    Assert.assertEquals(1000, t_convert.convert(TimeUnit.MILLISECONDS));
  }

  @Test
  /*
   * This test method tests the 'boolean isAfter (Time time)' method
   */
  public void testisAfter ()
  {
    Time t_isAfter1 = new Time (10, 20);
    Time t_isAfter2 = new Time (20, 30);

    Assert.assertEquals (true, t_isAfter2.isAfter(t_isAfter1));
    Assert.assertEquals (false, t_isAfter1.isAfter(t_isAfter2));

    t_isAfter2.setSeconds(10);
    Assert.assertEquals (true, t_isAfter2.isAfter(t_isAfter1));

    t_isAfter2.setNanosecs(20);
    Assert.assertEquals (false, t_isAfter2.isAfter(t_isAfter1));
  }

  @Test
  /*
   * This test method tests the 'boolean isAfterOrEqual (Time time)' method
   */
  public void testisAfterOrEqual ()
  {
    Time t_isAfterorE1 = new Time (10, 20);
    Time t_isAfterorE2 = new Time (20, 30);

    Assert.assertEquals (true, t_isAfterorE2.isAfterOrEqual(t_isAfterorE1));
    Assert.assertEquals (false, t_isAfterorE1.isAfterOrEqual(t_isAfterorE2));

    t_isAfterorE2.setSeconds(10);
    Assert.assertEquals (true, t_isAfterorE2.isAfterOrEqual(t_isAfterorE1));

    t_isAfterorE2.setNanosecs(10);
    Assert.assertEquals (false, t_isAfterorE2.isAfterOrEqual(t_isAfterorE1));
  }

  @Test
  /*
   * This test method tests the 'boolean isBefore (Time time)' method
   */
  public void testisBefore ()
  {
    Time t_isBefore1 = new Time (10, 20);
    Time t_isBefore2 = new Time (20, 30);

    Assert.assertEquals (true, t_isBefore1.isBefore(t_isBefore2));
    Assert.assertEquals (false, t_isBefore2.isBefore(t_isBefore1));

    t_isBefore2.setSeconds(10);
    Assert.assertEquals (true, t_isBefore1.isBefore(t_isBefore2));

    t_isBefore2.setNanosecs(20);
    Assert.assertEquals (false, t_isBefore1.isBefore(t_isBefore2));
  }

  @Test
  /*
   * This test method tests the 'boolean isBeforeOrEqual (Time time)' method
   */
  public void testisBeforeorEqual ()
  {
    Time t_isBeforeorE1 = new Time (10, 20);
    Time t_isBeforeorE2 = new Time (20, 30);

    Assert.assertEquals (true, t_isBeforeorE1.isBeforeOrEqual(t_isBeforeorE2));
    Assert.assertEquals (false, t_isBeforeorE2.isBeforeOrEqual(t_isBeforeorE1));

    t_isBeforeorE2.setSeconds(10);
    Assert.assertEquals (true, t_isBeforeorE1.isBeforeOrEqual(t_isBeforeorE2));

    t_isBeforeorE2.setNanosecs(10);
    Assert.assertEquals (false, t_isBeforeorE1.isBeforeOrEqual(t_isBeforeorE2));
  }

  @Test
  /*
   * This test method tests the 'boolean isEqual (Time time)' method
   */
  public void testisEqual ()
  {
    Time t_isEqual1 = new Time (10, 20);
    Time t_isEqual2 = new Time (10, 20);

    Assert.assertEquals (true, t_isEqual1.isEqual(t_isEqual2));

    t_isEqual2.setNanosecs(30);
    Assert.assertEquals (false, t_isEqual1.isEqual(t_isEqual2));

    t_isEqual2.setSeconds(20);
    Assert.assertEquals (false, t_isEqual1.isEqual(t_isEqual2));
  }

  @Test
  /*
   * This test method tests the 'Date toDate ()' method
   */
  public void testtoDate()
  {
    Time t_toDate = new Time (60000);
    Date d = new Date(60000);

    Assert.assertEquals (d, t_toDate.toDate());

  }

  @Test
  /*
   * This test method tests the 'boolean equals (Object obj)' method
   */
  public void testequals ()
  {
    Time t_equals1 = new Time (0, 0);
    Time t_equals2 = new Time (0, 0);

    Assert.assertEquals (true, t_equals1.equals(t_equals2));
    Assert.assertEquals (false, t_equals1.equals(0));
    Assert.assertEquals (true, t_equals1.equals(t_equals1));
  }

  @Test
  /*
   * This test method tests the 'String toString ()' method
   */
  public void testtoString ()
  {
    Time t_toString = new Time (60, 0);

    Assert.assertEquals ("7:01:00 PM", t_toString.toString());

  }
}
