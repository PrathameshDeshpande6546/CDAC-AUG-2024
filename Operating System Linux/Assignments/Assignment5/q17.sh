#!/bin/bash
echo "Enter No Of lines"
read line
i=0
while [ $i -lt  $line ];
do 
	for ((j=0;j<=$i;j++))
	do

			echo -n  "*"

	done

	i=`expr $i + 1`
	echo
done
