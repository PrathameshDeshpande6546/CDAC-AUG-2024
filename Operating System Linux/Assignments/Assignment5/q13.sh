#!/bin/bash


echo "Enter Directory Name:"
read dir

ls -a $dir | grep "^\."
