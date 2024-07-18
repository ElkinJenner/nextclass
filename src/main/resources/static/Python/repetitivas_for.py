'''
Algoritmo que genere la tabla de multiplicar de
un numero ingresado por teclado
'''
num = int(input('Ingresar Numero: \n'))

for x in range(12):
    multiplo = num * (x+1)
    print(num, 'x', (x+1), '=',multiplo)
