grammar Expr;

program: (expr';')* EOF;
expr: state_assign|state_print;
state_assign: var=ID ':=' val=bit;
state_print: 'print' ID;
bit: left=operand (op+=('OR' | 'XOR') right+=operand)*;
operand: left=value (op+='AND' right+=value)*;
value: HEXNUM | ID | '('bit')' | 'NOT' value;

HEXNUM: ([0-9]+[a-fA-F0-9]*);
ID: [a-zA-Z]([a-zA-Z0-9])*;
WS:[ \t\r\n]+ -> skip;
