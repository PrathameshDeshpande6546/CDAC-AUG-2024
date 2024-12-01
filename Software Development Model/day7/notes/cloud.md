# AWS

## introduction

- stands for Amazon Web Services
- a cloud provider
- cloud implementation from Amazon
- used to create virtual appliances (virtual machines, virtual network, virtual storage etc) on cloud
- services
  - compute:
    - EC2: Elastic Compute Cloud (IaaS)
    - Lambda: serverless computing (FaaS)
    - Elastic Bean: platform used by developers to host app (PaaS)
  - storage
    - S3: Simple Storage Service
    - EFS: Elastic File Service
    - EBS: Elastic Block Storage Service
- Elasticity
  - ability to expand (provision) and shrink (deprovision) the resources (scaling out or in) on demand automatically

## EC2

- used to create virtual machines on AWS cloud
- virtual machine is known as EC2 instance
- please please please make sure you are selecting Mumbai region
- ec2 configuration
  - name: mern-server
  - AMI:
    - name: ubuntu-server 24.04 LTS
    - architecture: x86
  - instance type: t2.micro
  - key-pair file
    - name: kdac-aug-24
    - key pair type: RSA
    - private key type: .pem
  - storage: 8GB

## configuring MERN application

### connecting EC2 instance

```bash

# if you get an error: UNPROTECTED PRIVATE KEY FILE!
# change the pem file permissions
# r: 4, w: 2, x: 1
# 400 => r-- --- ---
> chmod 400 ~/Downloads/kdac-aug-24.pem

# connect to the ec2 instance using public IPv4
# > ssh -i <pem file path> <username>@<public IP>
> ssh -i ~/Downloads/kdac-aug-24.pem ubuntu@<IP>

```

### mysql

```bash

# update apt cache
> sudo apt-get update

# install mysql server
> sudo apt-get install mysql-server

# check the status of mysql server service
> sudo systemctl status mysql

# start the mysql service
> sudo systemctl start mysql

# auto start the mysql service at the booting time
> sudo systemctl enable mysql

# first time setup
# login to mysql as root
> sudo mysql

# use the following to change the root password
> ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
> FLUSH PRIVILEGES;
> exit

# try logging in using root user credentials
> mysql -u root -p

# initialize the database

```

### express application (backend)

```bash

# please execute these commands on ec2 instance

# since the backend is developed in nodejs, first install the latest version of NodeJs
> sudo apt-get update

# download the apt source for latest version of node
> curl -sL https://deb.nodesource.com/setup_20.x -o /tmp/nodesource_setup.sh

# update the apt source
> sudo bash /tmp/nodesource_setup.sh
> sudo apt-get update

# install the nodejs v20
> sudo apt-get install nodejs

# check and confirm the node version
> node -v

```

```bash

# please execute these commands on your machine

# upload the code using scp

# go t the project's parent directory
# archive the project directory
# this command will create a new file named server.tar in current directory
> tar -cvf server.tar server

# upload the server.tar file to the ec2 instance
# > scp -i <pem file path> <source> ubuntu@<IP>:~/
> scp -i ~/Downloads/kdac-aug-24.pem server.tar ubuntu@65.1.130.139:~/

```

```bash

# please execute these commands on EC2 instance

# unarchive the tar file
# this will extract server directory from server.tar
# which has the backend code
> tar -xvf server.tar

# install pm2 to the express server forever
> sudo npm install -g pm2

# start the backend server using pm2
> cd server
> pm2 start --name backend-server server.js

# get the list of application running using pm2
> pm2 list

# stop a backend service
> pm2 stop <index / id>

# start the backend server
> pm2 start <index / id>

# restart the backend server
> pm2 restart <index / id>

# to verify the backend server
> curl http://localhost:4000/

```

```bash

# please use management console to modify the security group / firewall settings

# from ec2 dashboard, select the required instance
# select the security tab below
# select the security group configured for the instance
# edit the inbound rules
# add the following rules

# for http/apache/react application
# - type: http
# - protocol: TCP
# - port: 80
# - Source: anywhere-IPv4 (0.0.0.0/0)

# for express backend
# - type: Custom TCP
# - protocol: TCP
# - port: 4000
# - Source: anywhere-IPv4 (0.0.0.0/0)


# standard ports
# - 20, 21: FTP
# - 22: ssh
# - 23: telnet
# - 25: smtp
# - 53: dns
# - 80: http
# - 443: https

```

### frontend application

```bash

# execute these commands on your machine
# go to the express application
# open config.js file
# change the ip address from localhost to server ip address

# build the application
# this will create the build directory
> yarn build

# archive the build directory
> cd build
> tar -cvf react-app.tar *

# upload the file to the ec2 instance
> scp -i ~/Downloads/kdac-aug-24.pem react-app.tar ubuntu@<IP>:~/

```

```bash

# please execute these commands on ec2 instance (server)

# update the apt cache
> sudo apt-get update

# install apache2 webserver
> sudo apt-get install apache2

# check the status of apache2
> sudo systemctl status apache2

# enable the apache2 for auto start and start now
> sudo systemctl enable --now apache2

# go to the apache2's webroot
> cd /var/www/html

# remove everything from webroot
> sudo rm -rf *

# move react-app.tar from home directory to the webroot
> sudo mv ~/react-app.tar .

# extract the react-app file
> sudo tar -xvf react-app.tar

```

## AWS infrastructure

- 1 rack server: 10TB x 10 = 100TB
- 1 rack = 10 servers = 10 x 100 = 1000TB
- 1 rack row = 20 = 20 \* 1000TB = 20000TB
- 1 room = 20 rack rows
- 1 floor = 10 rooms
- 1 building = 10 floors
- 1 data center = 5 buildings
- 1 availability zone = 3 data centers
- 1 region = 3 AZs
