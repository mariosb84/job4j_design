package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }
    @Test
    public void whenPairWithComment() {
        String path = "data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }
    @Test
    public void whenPairWithEmptyLines() {
        String path = "data/pair_with_emptyLines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void whenPairWithInvalidKey()  {
        String path = "data/pair_with_invalidKey.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value(null), is("Petr Arsentev"));
    }
}
