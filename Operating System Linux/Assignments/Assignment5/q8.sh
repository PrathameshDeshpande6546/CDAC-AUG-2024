#!/bin/bash


echo "Enter number "
read num

for i in ` seq 10 `
do
	echo " $num * $i: ` expr $num \* $i`"

done	
