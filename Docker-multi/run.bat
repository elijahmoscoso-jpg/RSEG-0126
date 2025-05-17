docker build -t hellogcc:latest -f ./Dockerfile.gcc .
docker build -t helloubuntu:latest -f ./Dockerfile.ubuntu .
docker build -t helloalpine:latest -f ./Dockerfile.alpine .

docker run -it --rm hellogcc:latest
docker run -it --rm helloubuntu:latest
docker run -it --rm helloalpine:latest
