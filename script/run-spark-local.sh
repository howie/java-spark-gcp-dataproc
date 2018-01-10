#!/bin/sh

# Run application locally on any cores

spark-submit  \
--class io.tenmax.poc.dataproc.SparkDriverProgram \
--deploy-mode client \
--master local[*] \
build/libs/java-spark-gcp-dataproc-all.jar \
 /tmp/test