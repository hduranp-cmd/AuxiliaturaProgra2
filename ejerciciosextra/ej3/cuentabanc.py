class CuentaBancaria:
    def __init__(self,titular,nroCuenta,saldo):
        self.__titular=titular
        self.__nroCuenta=nroCuenta
        self.__saldo=saldo
    def depositar(self,deposito):
        if deposito<0 or deposito==0:
            print("error")
        self.__saldo=self.__saldo+deposito
    def retirar(self,retiro):
        if retiro>self.__saldo:
            print("no tienes dienero suficiente")
        else:
            self.__saldo=self.__saldo-retiro
    def mostrardatos(self):
        print(self.__saldo)
        print(self.__nroCuenta)
        print(self.__titular)