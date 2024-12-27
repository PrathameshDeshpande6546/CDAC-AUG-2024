#!/bin/bash

choice=0
until [ $choice -eq 5 ]; do

echo -e "1.Date\n2.cal\n3.ls\n4.pwd\n5.exit"
echo "Enter Choice"
read choice

case $choice in 
	1)
		echo -n "Date:"
		date
		;;
	2)
		echo "Calender:"
		cal
		;;

	3)
		echo "Directory Contents: "
		ls
		;;
	
	4)     	
		echo "Current Directory:"
		pwd
		;;
	
  	5) 
		break
		;;	
		
	

	*)
		echo " Enter Right Choice!!!"
		;;

	

  	esac
done
