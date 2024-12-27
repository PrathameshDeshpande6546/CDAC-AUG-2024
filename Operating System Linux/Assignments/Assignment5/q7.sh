#!/bin/bash

echo -n  "Enter Number:"
read num


if [ $num -eq 0 ];
then 
	echo "Number is $num "

elif [ $num -lt 0 ];
then 
	echo "$num is Ngative number :)"

else 
	echo "$num is Positive number :) "
fi

