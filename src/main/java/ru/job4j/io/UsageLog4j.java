package ru.job4j.io;

/*import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    //private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        System.out.println();
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        System.out.println();
        int a = 0;
        byte b = 1;
        short c = 4;
        float d = 2.0f;
        double e = 3.0d;
        long f = 5L;
        boolean g = true;
        char h = 'a';
        LOG.debug("8 variables : int a : {}, byte b : {}, short c : {}, float d : {}, double e : {}, long f : {}, boolean g : {}, char h : {}", a, b, c, d, e, f, g, h);

    }
}