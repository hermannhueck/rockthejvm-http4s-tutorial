#! /bin/sh

set -x
# curl 'http://localhost:8080/api/movies?director=Zack%20Snyder&year=2021' | json_pp

# using httpie
http get 'http://localhost:8080/api/movies?director=Zack%20Snyder&year=2021'
