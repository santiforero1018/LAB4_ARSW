## Escuela Colombiana de Ingeniería

## Arquitecturas de Software

# Componentes y conectores - Parte I.

El ejercicio se debe traer terminado para el siguiente laboratorio (Parte II).

#### Middleware- gestión de planos.


## Antes de hacer este ejercicio, realice [el ejercicio introductorio al manejo de Spring y la configuración basada en anotaciones](https://github.com/ARSW-ECI/Spring_LightweightCont_Annotation-DI_Example).

Parte 1 completada, el link contiene el [repositorio correspondiente](https://github.com/santiforero1018/TALLER_LAB4_ARSW.git)

En este ejercicio se va a construír un modelo de clases para la capa lógica de una aplicación que permita gestionar planos arquitectónicos de una prestigiosa compañia de diseño. 

![](img/ClassDiagram1.png)

1. Configure la aplicación para que funcione bajo un esquema de inyección de dependencias, tal como se muestra en el diagrama anterior.


	Lo anterior requiere:

	* Agregar las dependencias de Spring.
	* Agregar la configuración de Spring.
	* Configurar la aplicación -mediante anotaciones- para que el esquema de persistencia sea inyectado al momento de ser creado el bean 'BlueprintServices'.

	- Para esta implementación, se configuró el siguiente archivo
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/abad132d-519b-428e-98fc-20b6656e8cf4)

 	- Luego añadir algunos plugins al POM.xml	 
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/cc0d95af-1bfa-40cc-ac47-8e2c8ee4845e)


2. Complete los operaciones getBluePrint() y getBlueprintsByAuthor(). Implemente todo lo requerido de las capas inferiores (por ahora, el esquema de persistencia disponible 'InMemoryBlueprintPersistence') agregando las pruebas correspondientes en 'InMemoryPersistenceTest'.
	-  Implementación de los metodos solicitados
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/388f19e1-0744-43c1-9c8b-d24c3cdc4ffb)
	- Prueba de los metodos
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/cf8379ef-6776-483c-88c5-c009006ded44)
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/3de69d9e-50bf-437b-9758-991742367bbd)


3. Haga un programa en el que cree (mediante Spring) una instancia de BlueprintServices, y rectifique la funcionalidad del mismo: registrar planos, consultar planos, registrar planos específicos, etc.
	- Para este punto, se implemento una clase llamada Main.java
4. Se quiere que las operaciones de consulta de planos realicen un proceso de filtrado, antes de retornar los planos consultados. Dichos filtros lo que buscan es reducir el tamaño de los planos, removiendo datos redundantes o simplemente submuestrando, antes de retornarlos. Ajuste la aplicación (agregando las abstracciones e implementaciones que considere) para que a la clase BlueprintServices se le inyecte uno de dos posibles 'filtros' (o eventuales futuros filtros). No se contempla el uso de más de uno a la vez:
	- Para este ejercicio, se implemento la siguiente interfaz y luego las correspondientes implementaciones, junto con la inyección a probar
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/b1e0bdbb-5f77-485a-83b6-821e5bc9b478)

 	* (A) Filtrado de redundancias: suprime del plano los puntos consecutivos que sean repetidos.
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/344dca2b-0b76-4827-b774-7bd90974ef07)

	* (B) Filtrado de submuestreo: suprime 1 de cada 2 puntos del plano, de manera intercalada.
		![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/66a3ccf3-f6a3-4b46-98c4-8b8ac036dc7d)

5. Agrege las pruebas correspondientes a cada uno de estos filtros, y pruebe su funcionamiento en el programa de prueba, comprobando que sólo cambiando la posición de las anotaciones -sin cambiar nada más-, el programa retorne los planos filtrados de la manera (A) o de la manera (B).
   	- Prueba de la redundancia
   	  ![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/66fbb660-b15c-4b94-a749-badb337b0567)

   	- Prueba del submuestreo
	![image](https://github.com/santiforero1018/LAB4_ARSW/assets/88952698/225a3290-adb9-4abd-b285-90ab1228c080)
