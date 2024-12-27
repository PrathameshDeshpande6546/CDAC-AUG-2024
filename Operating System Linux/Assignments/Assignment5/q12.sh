#!/bin/bash
#


echo "Enter File Name:"
read fname

if [ -f $fname ]; 
then 
	echo "File Exist :)"
	echo -n  "File last "
	 stat $fname|tail -3|head -1

else
	echo "File Doesn't Exist :("

fi
