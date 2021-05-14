#!/usr/bin/env bash

sum=0
for x in $(seq 0 9); do
  dirName="Q0""$x""99"
  if [ -d ${dirName} ]; then
    num=$(ls -l ${dirName} | wc -l)
    echo "${dirName}: ${num}"
    sum=$(($sum + $num))
  fi
done
echo "total: ${sum}"
