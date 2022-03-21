package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Test
    public void whenOK() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "1");
        map.put("subject", "2");
        Generator generatorNew = new GeneratorNew();
        String templateNew = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a 1, Who are 2?";
        String rsl = generatorNew.produce(templateNew, map);
        assertThat(rsl, is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMoreKeys() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "1");
        map.put("subject", "2");
        map.put("subject2", "3");
        Generator generatorNew = new GeneratorNew();
        String templateNew = "I am a ${name}, Who are ${subject}?";
        String rsl = generatorNew.produce(templateNew, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectKeys() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "1");
        map.put("subjectNew", "2");
        Generator generatorNew = new GeneratorNew();
        String templateNew = "I am a ${name}, Who are ${subject}?";
        String rsl = generatorNew.produce(templateNew, map);
    }

}
