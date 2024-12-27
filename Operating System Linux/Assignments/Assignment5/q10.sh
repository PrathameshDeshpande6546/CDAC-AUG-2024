#!/bin/bash



echo -n "Enter Number:"
read num

x=0
y=1
echo -n "1 "
for(( i=1 ; i < $num ; i++ ))
do	
       res=`expr $x + $y`
       x=$y
       y=$res

       echo -n "$res "
done

echo -e "\n"	
