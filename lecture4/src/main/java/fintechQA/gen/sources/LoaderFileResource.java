package fintechQA.gen.sources;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoaderFileResource {

    public static List<String> loadResource2(String fileName) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            list = stream
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static List<String> loadResource(String fileName) {
        List<String> list;
        InputStream in = ClassLoader.getSystemResourceAsStream(fileName);
        try (Stream<String> stream = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines()) {
            list = stream
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());
        }
        return list;
    }


}
