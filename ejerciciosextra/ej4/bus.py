class Bus: 
    def __init__(self, capacidad: int):
        self.__capacidad = capacidad
        self.__pasajeros = 0
        self.__dinero = 0.0

    def subir_pasajeros(self, x: int):
        asientos_libres = self.__capacidad - self.__pasajeros 
        if x <= asientos_libres:
            self.__pasajeros += x
        else:
            print("No se pueden subir mas pasajeros.")

    def cobrar_pasaje(self):
        costopas = 1.50
        monto_cobrado = self.__pasajeros * costopas
        self.__dinero += monto_cobrado 
        return monto_cobrado

    def asientos_disponibles(self):
        libres = self.__capacidad - self.__pasajeros
        return libres



bus1 = Bus(capacidad=30)  
bus1.subir_pasajeros(12)
print("Asientos disponibles:", bus1.asientos_disponibles())
print("Total cobrado: Bs.", bus1.cobrar_pasaje())