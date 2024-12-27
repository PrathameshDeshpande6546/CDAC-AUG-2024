#!/bin/bash

echo -e  "Enter Name:\n"
read name

if [ -f "$name" ]; then 
	echo  "Given $name is a regular file!!!"
	echo "Size:( stat "$name")"

else
	echo "Given $name is Directory!!! "
	ls "$name"

fi
	 

