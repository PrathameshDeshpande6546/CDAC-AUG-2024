#!/bin/bash


echo -n  "Enter Year:"
read year

if [ `expr $year % 4` -eq 0 ] && [ `expr $year % 100` -ne 0 ] || [ `expr $year % 400` -eq 0 ];
then 
	echo "$year Is Leap Year!!!";

else
	echo "$year Is Not A Leap Year!!!"

fi

