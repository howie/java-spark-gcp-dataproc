package io.tenmax.poc.dataproc;

import org.junit.Test;

/**
 * @author howie
 * @since 2018/1/10
 */
public class SparkDriverProgramTest {

    @Test
    public void test_local_mode() {

        SparkDriverProgram.main(new String[] {"/tmp/test.log"});
    }
}
