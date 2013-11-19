set term png
set output 'scaling_benchmark.png'
set title "linux kernel source, 'hello world', 44000 files"

set ylabel "runtime in ms"
set y2label "runtime in ms"
set y2range [10 : 100]
set y2tics

plot 'scaling_benchmark.csv' using 1:2 with lines axes x1y1, \
     'scaling_benchmark.csv' using 1:3 with lines axes x1y2

