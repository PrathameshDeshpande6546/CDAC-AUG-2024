#!/bin/bash

echo "Enter Three NUmbers!!! "
read n1 n2 n3

if [ $n1 -gt $n2 ] && [ $n1 -gt $n3 ];
then 
	echo " $n1 is Greater!!!"

elif [ $n2 -gt $n1 ] && [ $n2 -gt $n3 ];
then 
	echo " $n2 is Greater!!!"
else
	echo " $n3 is Greater!!!"
fi
