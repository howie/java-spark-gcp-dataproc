# Requirement

Before submit task please run login first

```
gcloud auth login
```


## Create cluster

Reference： [gcloud dataproc clusters create](https://cloud.google.com/sdk/gcloud/reference/dataproc/clusters/create)
```
gcloud dataproc clusters create <cluster_name> \
       --bucket <bucket_name> \
       --zone <zone: us-central1-a> \
       --master-boot-disk-size 500GB \
       --worker-boot-disk-size 500GB \
       --num-masters 1 \
       --num-workers 2 \
       --num-preemptible-workers 2
```


## Build and submit job

Before execute make sure to update variable in Gradle file

```
./gradlew clean build deployJar submitJob

```


## Shutdown and delete cluster

```
./gradlew shutdownCluster deleteJar

```

