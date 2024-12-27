#!/bin/bash


echo "Enter number "
read num

res=1

for i in ` seq $num `
do
	res=`expr $res \* $i`
done

echo "factorial of $num is : $res"


