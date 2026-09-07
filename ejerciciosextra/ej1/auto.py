class Vehiculo:
    def __init__(self,marca:str,modelo:str,anio:int,kilometraje:int,color:str):
        self.__marca=marca
        self.__modelo=modelo
        self.__anio=anio
        self.__kilometraje=kilometraje
        
    def mostrar_kilometraje(self):
        km=int(self.__kilometraje)
        metros =self.__kilometraje * 1000
        print("Kilometraje: ",km, "km y ",metros," m")
    
    def cambiacolor(self,ncolor:str):
        self.__color=ncolor

auto1=Vehiculo("susuki","corona",2026,150,"rojo")
auto2=Vehiculo("toyota","viruela",2014,120,"verde")

auto1.cambiacolor("amarillo")
auto1.mostrar_kilometraje()
auto2.cambiacolor("celeste")
auto2.mostrar_kilometraje()