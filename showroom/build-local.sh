#eval $(minikube -p minikube docker-env)
eval $(minikube docker-env)
./mvnw clean package
docker build -t showroom:v1.0.0 .
#then helm install credit-scoring-five-plus-listener ./helm
#helm uninstall credit-scoring-five-plus-listener
#kubectl get events --sort-by='.lastTimestamp'