#!/bin/bash
docker stop play-1234
docker rm play-1234
docker pull $2
docker run --name play-1234 -p 1234:$1 $2 >/dev/null 2>&1 &
IN=$(hostname -I)
arrIN=(${IN// / })
tput setaf 2
echo -e your application is at $arrIN:1234 "\n"
tput sgr0
