#!/bin/bash


echo "Enter Two Files Name:"
read f1 f2

rev $f1 | cat >> $f2

cat $f2
