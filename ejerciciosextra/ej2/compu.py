class Computadora:
    def __init__(self,marca:str,procesador:str,ram:int,almacenamiento:int):
        self.__marca=marca
        self.__procesador=procesador
        self.__ram=ram
        self.__almacenamiento=almacenamiento
    def ramigual(self,x:int):
        if self.__ram==x:
            print("la ram es igual")
        else:
            print("la ram no es igual")
    def get_almacenamiento(self):
        return self.__almacenamiento
    def mostrarinfo(self):
        print(self.__marca)
        print(self.__procesador)
        print(self.__almacenamiento)
        print(self.__ram)
        

compu1=Computadora("samsung","i9",8,128)
compu2=Computadora("asus","i3",16,256)

if compu1.get_almacenamiento()>compu2.get_almacenamiento():
    compu1.mostrarinfo()
elif compu1.get_almacenamiento()<compu2.get_almacenamiento():
    compu2.mostrarinfo()
else:
    print("las dos son iguales")