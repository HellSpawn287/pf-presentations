package pf.zjava.junit5.conditions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionTests {
  @Disabled
  @Test
  void disabledTest(){
    System.out.println("dusabledTest");
  }
  @DisabledOnOs(value = OS.WINDOWS)
  @Test
  void disabledOnWindows(){
    System.out.println("disabledOnWindows");
  }

  @DisabledOnOs(value = OS.LINUX)
  @Test
  void disabledOnLINUX(){
    System.out.println("disabledOnLINUX");
  }

  @EnabledOnOs(value = OS.WINDOWS)
  @Test
  void enabledOnWindows(){
    System.out.println("enabledOnWindows");
  }

  @EnabledOnOs(value = OS.LINUX)
  @Test
  void enabledOnLINUX(){
    System.out.println("enabledOnLINUX");
  }

  @DisabledOnJre(value = JRE.JAVA_11)
  @Test
  void disabledOnJava11(){
    System.out.println("disabledOnJAVA_11");
  }

  @DisabledOnJre(value = JRE.JAVA_10)
  @Test
  void disabledOnJava10(){
    System.out.println("disabledOnJAVA_11");
  }

  @EnabledOnJre(value = JRE.JAVA_11)
  @Test
  void enabledOnJAVA_11(){
    System.out.println("enabledOnJAVA_11");
  }

  @EnabledOnJre(value = JRE.JAVA_10)
  @Test
  void enabledOnJAVA_10(){
    System.out.println("enabledOnJAVA_10");
  }

  @DisabledIfSystemProperty(named = "testSystemProperty",matches = "[a]+" )
  @Test
  void disabledIfSystemProperty(){
    System.out.println("disabledOnJAVA_11");
  }

  @EnabledIfSystemProperty(named = "testSystemProperty", matches = "[b]+" )
  @Test
  void enabledIfSystemProperty(){
    System.out.println("enabledOnJAVA_11");
  }

  @DisabledIfEnvironmentVariable(named = "testEnvironmentVariable", matches = "[1]+" )
  @Test
  void disabledIfEnvironmentVariable(){
    System.out.println("disabledOnJAVA_11");
  }

  @EnabledIfEnvironmentVariable(named = "testEnvironmentVariable", matches = "[2]+" )
  @Test
  void enabledIfEnvironmentVariable(){
    System.out.println("enabledOnJAVA_11");
  }
}
