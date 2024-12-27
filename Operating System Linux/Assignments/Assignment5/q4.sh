#!/bin/bash

echo "Enter Number: "
read num
i=2

while [ $i -lt $num ]; do
    if [ $(expr $num % $i) -eq 0 ]; then
        echo "$num Not a Prime Number!!!"
        exit 0
    fi

    i=$(expr $i + 1)
done

if [ $num -eq $i ]; then
    echo "$num Is a Prime Number!!!"
fi
