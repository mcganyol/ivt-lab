package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockTsPri;
  private TorpedoStore mockTsSec;

  @Before
  public void init(){
	mockTsPri = mock(TorpedoStore.class);
	mockTsSec = mock(TorpedoStore.class);
    this.ship = new GT4500(mockTsPri, mockTsSec);
    
  }

  @Test
  public void fireTorpedos_Single_Success(){
    // Arrange

    // Act
    //boolean result = notMockedShip.fireTorpedos(FiringMode.SINGLE);
	
    // Assert
    //assertEquals(true, result);

  }
  


  @Test
  public void fireTorpedos_All_Success(){
    // Arrange
		when(mockTsPri.fire(1)).thenReturn(true);
		when(mockTsSec.fire(1)).thenReturn(true);
	  
    // Act
    //boolean result = ship.fireTorpedos(FiringMode.ALL);
		ship.fireTorpedos(FiringMode.ALL);

    // Assert
    //assertEquals(true, result);
		verify(mockTsPri,times(1)).fire(1);
		verify(mockTsSec,times(1)).fire(1);
  }
  
  // Az alabbi 5 teszt a single fire modot teszteli a leiras alapjan
  // 1.test: egy tuzeleskor azt varjuk hogy a primary-n hivunk egy lovest, a secondary-n nem
  // 2.test: a masodik tuzeleskor azt varjuk, hogy a primary-n nem hivunk lovest a secondary-n igen
  // 3.test: ha valamelyik torpedocso ures(false-al ter vissza), akkor a masik meghivodik
  // 4.test: ha a meghivott torpedocso hibaval ter vissza (IllegalArgumentException) akkor a masik sem hivodik meg
  // 5.test: forraskod alapjan, 
  
  @Test
  public void Test1(){
	  when(mockTsPri.fire(1)).thenReturn(true);
	  when(mockTsSec.fire(1)).thenReturn(false);
	  when(mockTsSec.isEmpty()).thenReturn(false);
	  when(mockTsPri.isEmpty()).thenReturn(false);
	  
	  ship.fireTorpedos(FiringMode.SINGLE);
	  
	  verify(mockTsPri,times(1)).fire(1);
	  verify(mockTsSec,never()).fire(1);	  

  }
  
  @Test
  public void Test2(){

  }
  
  @Test
  public void Test3(){

  }
  
  @Test
  public void Test4(){

  }
  
  @Test
  public void Test5(){

  }
  
  
}
