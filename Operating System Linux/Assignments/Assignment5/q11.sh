#!/bin/bash
#

echo -n  "Enter Basic Salary:"
read sal
 
da=0.4
hra=0.2

echo " $sal + $sal * $da + $sal + $sal * $hra "|bc

