package pf.zjava.junit5.extension.parameter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=0qI6_NKFQsY&t=386s
public class ParamFromExtensionTest {
  @Test
  @ExtendWith(TemporaryDirectoryPath.class)
  void writeAndReadFile(Path tempDir) throws Exception {
    Path testFile = tempDir.resolve("test.txt");

    List<String> expected = Arrays.asList("aa", "bb");
    Files.write(testFile, expected);

    List<String> lines = Files.readAllLines(testFile);
    Assertions.assertIterableEquals(expected, lines);
  }
}
