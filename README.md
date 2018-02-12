# Belajar Java EE 6

Menggunakan java EE 6, deploy into websphere

## Running Websphere via docker

`docker run -d -p 80:9080 \
  -v $(pwd)/target/javaee6-example.war:/config/dropins/SampleJavaEE6.war \
  websphere-liberty:webProfile6`