minikube start
kubectl create deployment nginx --image=nginx
kubectl expose deployment nginx --type=NodePort --port=80
