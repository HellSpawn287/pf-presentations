package pf.zjava.junit5.extension.parameter;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryDirectoryPath implements ParameterResolver, AfterEachCallback {

  public static final String TMP_PATH = "tmpPath";

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.getParameter().getType().equals(Path.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    Path zjava = null;
    try {
      zjava = Files.createTempDirectory("zjava");
      extensionContext.getStore(ExtensionContext.Namespace.create(this.getClass()))
          .put(TMP_PATH, zjava);
    } catch (IOException e) {
      throw new ParameterResolutionException("can't create temp directory", e);
    }
    return zjava;
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    Path path = context.getStore(ExtensionContext.Namespace.create(this.getClass())).get(TMP_PATH, Path.class);
    deleteDirectory(path.toFile());
  }

  boolean deleteDirectory(File directoryToBeDeleted) {
    File[] allContents = directoryToBeDeleted.listFiles();
    if (allContents != null) {
      for (File file : allContents) {
        deleteDirectory(file);
      }
    }
    return directoryToBeDeleted.delete();
  }
}
