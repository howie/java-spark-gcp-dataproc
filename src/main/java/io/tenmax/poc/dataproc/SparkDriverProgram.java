package io.tenmax.poc.dataproc;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author howie
 * @since 2018/1/10
 */
public class SparkDriverProgram {

    private static final Logger log = LoggerFactory.getLogger(SparkDriverProgram.class);

    public static void main(String args[]) {

        SparkSession spark = SparkSession.builder()
                                         .appName("poc-on-dataproc")
                                         .master("local[*]")
                                         .getOrCreate();

        // Create Spark Context with configuration
        JavaSparkContext sc = JavaSparkContext.fromSparkContext(spark.sparkContext());

        // Create a RDD for a log file
        // Each line in log file become a record in RDD
        JavaRDD<String> lines = sc.textFile(args[0]);

        System.out.println("Total lines in log file " + lines.count());

        /* Map operation -> Mapping number of characters into each line as RDD */
        JavaRDD<Integer> lineCharacters = lines.map(String::length);

        /* Reduce operation -> Calculating total characters */
        int totalCharacters = lineCharacters.reduce((a, b) -> a + b);

        System.out.println("Total characters in log file " + totalCharacters);

        sc.close();
    }
}
