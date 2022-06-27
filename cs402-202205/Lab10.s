#Still Hello World?
###################################
.data
hello: .asciiz "\n hello  world  "
.globl main
.text
main:
li $v0, 4    
la $a0, hello 
syscall