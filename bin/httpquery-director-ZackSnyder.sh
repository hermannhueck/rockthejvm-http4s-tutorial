#! /bin/sh

set -x
# curl 'http://localhost:8080/api/private/directors/Zack%20Snyder' | json_pp

# using httpie
http get 'http://localhost:8080/api/private/directors/Zack%20Snyder'
