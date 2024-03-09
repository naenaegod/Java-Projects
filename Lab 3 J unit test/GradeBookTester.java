import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeBookTester {
   private GradeBook gradebook1;
   private GradeBook gradebook2;

   @Before
   public void setUp() {
       gradebook1 = new GradeBook(5);
       gradebook2 = new GradeBook(5);
       gradebook1.addScore(95);
       gradebook1.addScore(85);
       gradebook2.addScore(75);
       gradebook2.addScore(65);
   }

   @After
   public void tearDown() {
       gradebook1 = null;
       gradebook2 = null;
   }

   // Test methods
   
   @Test
   public void testAddScore() {
       assertTrue(gradebook1.toString().equals("95.0 85.0"));
       assertEquals(2, gradebook1.getScoreSize());

       assertTrue(gradebook2.toString().equals("75.0 65.0"));
       assertEquals(2, gradebook2.getScoreSize());
   }
   @Test
   public void testSum() {
       assertEquals(180, gradebook1.sum(), 0.001);
       assertEquals(140, gradebook2.sum(), 0.001);
   }
   @Test
   public void testMinimum() {
       assertEquals(85, gradebook1.minimum(), 0.001);
       assertEquals(65, gradebook2.minimum(), 0.001);
   }
   @Test
   public void testFinalScore() {
       assertEquals(95, gradebook1.finalScore(), 0.001); 
       assertEquals(75, gradebook2.finalScore(), 0.001);
   }



}