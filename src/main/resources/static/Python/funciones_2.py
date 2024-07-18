'''
Funcion para generar lista con Numeros aleatorios
'''
import random #Modulo Random

def aleatorio(cantidad):
    lista=[]
    for x in range(cantidad):
        numero = random.randint(1,100)
        lista.append(numero)
    
    return lista

#Invocar funcion
print(aleatorio(10))