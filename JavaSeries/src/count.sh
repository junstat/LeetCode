#!/usr/bin/env bash

sum=0
for x in $(seq 1 9); do
  dirName="Q""$x""00"
  if [ -d ${dirName} ]; then
    num=$(ls -l ${dirName} | wc -l)
    echo "${dirName}: ${num}"
    sum=$(($sum + $num))
  fi
done
echo "total: ${sum}"
