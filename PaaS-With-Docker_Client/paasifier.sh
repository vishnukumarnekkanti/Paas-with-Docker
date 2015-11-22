#!/bin/bash
if [ "$#" -gt 4	 ] || [ "$#" -le 0 ]
then
	echo "Usage: d_paas_cli deploy <repository:tag> <default app port> <serverip:port>"
	exit 1
fi
if ! [ "$1" == "deploy" ];
then
        echo "Usage: d_paas_cli deploy <repository:tag> <default app port> <serverip:port>"
        exit 1
fi
curl -X POST http://$4/deploy -H "Content-Type:application/json" -d '{"repo": "'$2'","port":"'$3'"}'
