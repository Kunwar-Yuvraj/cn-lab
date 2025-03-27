# Create NS simulator
set ns [new Simulator]

# Open trace file
set tracefile [open "ess.tr" w]
$ns trace-all $tracefile

# Create wireless nodes
set n1 [$ns node]
set n2 [$ns node]
set ap [$ns node]   ;# Access Point

# Set node positions
$n1 set X_ 100; $n1 set Y_ 200
$n2 set X_ 200; $n2 set Y_ 300
$ap set X_ 150; $ap set Y_ 250

# UDP Traffic from n1 and n2 to AP
foreach n "$n1 $n2" {
    set udp [new Agent/UDP]
    set sink [new Agent/Null]
    $ns attach-agent $n $udp
    $ns attach-agent $ap $sink
    $ns connect $udp $sink
    
    set cbr [new Application/Traffic/CBR]
    $cbr set packetSize_ 512
    $cbr set rate_ 100Kb
    $cbr attach-agent $udp
    $ns at 0.1 "$cbr start"
}

# Finish procedure
proc finish {} {
    global ns tracefile
    $ns flush-trace
    close $tracefile
    exit 0
}

# Run simulation
$ns at 10.0 "finish"
$ns run
