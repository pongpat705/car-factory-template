#eval $(minikube -p minikube docker-env)
eval $(minikube docker-env)
mvn clean package
docker build -t showroom:$1 .