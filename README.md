# Nutrion on Wheels
Backend code for Nutrition on wheels project

Running docker image

1. Please provide the full name of the docker iamge including the tag. e.g.  nutrition:1.1
2. Attach the port expose in the beginning docker run -dp 8080:8080  nutrition:1.1
3. aws ecr-public --profile riva get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws (ap-south not connecting)
4. docker tag 17a42e40083b public.ecr.aws/e1b2e4b4/nutrition-1.0:1.0
5. docker push public.ecr.aws/e1b2e4b4/nutrition-1.0:1.0
6. https://dev.to/gigincg/deploy-jar-file-to-elastic-beanstalk-using-eb-cli-4f46 - for installing AWS EBS and deploy.
7. Please remember to create a user and give full permission to the user.