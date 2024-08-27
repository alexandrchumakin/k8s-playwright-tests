# Demo test project in Playwright and JUnit 5 to verify a simple Kubernetes app

## Requirements
- docker
- minikube
- kubectl

## Run Kubernetes app locally

### Start Minikube
```shell
minikube start
```

### Create a deployment
```shell
kubectl create deployment nginx --image=nginx
```

### Expose the deployment
```shell
kubectl expose deployment nginx --type=NodePort --port=80
```

### Get the service URL
```shell
minikube service nginx --url
```
After the service is provisioned locally, copy the URL and export to `NGINX_BASE_URL` environment variable.

#### Verify the deployment
```shell
kubectl get deployments
kubectl get pods
kubectl get services
```

## Run tests
```shell
NGINX_BASE_URL=$NGINX_BASE_URL mvn test
```
### Run in headful mode
```shell
HEADFUL=true NGINX_BASE_URL=$NGINX_BASE_URL mvn test
```
