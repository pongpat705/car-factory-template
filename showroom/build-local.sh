#eval $(minikube -p minikube docker-env)
eval $(minikube docker-env)
./mvnw clean package
docker build -t showroom:v1.0.0 .