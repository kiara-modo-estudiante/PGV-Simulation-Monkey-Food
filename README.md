# Monkey Food Simulator (Simulador de comida para monos)

## Índice

1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Cómo Ejecutar el Proyecto](#cómo-ejecutar-el-proyecto)
4. [Roles en el Simulador](#roles-en-el-simulador)
   - [Productor (Turista)](#1-productor-turista)
   - [Consumidor (Mono)](#2-consumidor-mono)
   - [Recurso Compartido (Parque)](#3-recurso-compartido-parque)
5. [Funcionamiento del Simulador](#funcionamiento-del-simulador)
   - [Flujo General](#flujo-general)
6. [Ejemplo de Ejecución](#ejemplo-de-ejecución)
   - [Entrada](#entrada)
   - [Posible Salida](#posible-salida)

## Descripción del Proyecto

|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |                                                                      |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------- |
| El **Monkey Food Simulator** es un proyecto educativo que utiliza **programación multihilo** para simular la interacción entre turistas y monos en un parque. En este simulador, los **turistas** actúan como **productores** que lanzan frutas al parque, mientras que los **monos** son los **consumidores** que recogen y comen las frutas. El parque, representado como un **recurso compartido**, tiene una capacidad limitada, lo que introduce la necesidad de sincronización entre los hilos productores y consumidores. | ![Mono con plátanos](./docs/images/monkey-sitting-with-bananas.jpeg) |

## Estructura del Proyecto

El proyecto está organizado en las siguientes carpetas y archivos:

```
├── README.md
├── docs
│   └── images
└── src
    └── net
        └── salesianos
            ├── constants
            ├── shared
            ├── threads
            └── utils
```

### Descripción de las Carpetas

- **README.md**: Archivo principal que contiene la documentación del proyecto.

- **docs/images**: Carpeta que almacena imágenes utilizadas en la documentación.

- **src/net/salesianos**: Carpeta raíz del código fuente del proyecto, organizada en subcarpetas según la funcionalidad:

  - **constants**: Contiene clases o archivos que definen constantes utilizadas en el proyecto, como la lista de frutas predefinidas.

  - **shared**: Incluye la implementación del recurso compartido, el parque donde interactúan los turistas y los monos.

  - **threads**: Contiene las clases que representan los hilos del simulador, como los turistas (productores) y los monos (consumidores).

  - **utils**: Proporciona utilidades y funciones auxiliares, como generación de tiempos aleatorios o métodos de ayuda para el simulador.

Esta estructura modular facilita la organización, el mantenimiento y la escalabilidad del proyecto.

## Cómo Ejecutar el Proyecto

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/kiara-modo-estudiante/PGV-Simulation-Monkey-Food.git
   ```

2. **Navega al directorio del proyecto**:

   ```bash
   cd PGV-Simulation-Monkey-Food
   ```

3. **Compila el proyecto**:

   ```bash
   javac -d out src/**/*.java
   ```

4. **Ejecuta el simulador**:

   ```bash
   java -cp out net.salesianos.App
   ```

## Roles en el Simulador

### 1. **Productor (Turista)**

- **Descripción**: Los turistas son los hilos productores en el simulador. Su tarea es lanzar frutas al parque.
- **Responsabilidades**:
  - Generar un número específico de frutas.
  - Cada fruta tiene un tiempo de producción único e impredecible.
  - Añadir las frutas al recurso compartido (el parque).
  - Esperar si el parque está lleno hasta que los monos consuman frutas.
- **Ejemplo**:
  - (👩) Alice is picking up: (🍎) Red Apple
  - (👩) Alice threw (🍎) red apple to the Monkey Park!

### 2. **Consumidor (Mono)**

- **Descripción**: Los monos son los hilos consumidores en el simulador. Su tarea es recoger y comer las frutas lanzadas por los turistas.
- **Responsabilidades**:
  - Consumir un número específico de frutas.
  - Cada fruta tiene un tiempo de consumo único e impredecible.
  - Esperar si el parque está vacío hasta que los turistas lancen más frutas.
- **Ejemplo**:
  - (🐒) Charlie took the (🍌) banana!
  - (🐒) Charlie is eating: (🍌) Banana

### 3. **Recurso Compartido (Parque)**

- **Descripción**: El parque es el recurso compartido donde los turistas lanzan frutas y los monos las recogen. Está representado por una estructura de datos con capacidad limitada.
- **Responsabilidades**:
  - Almacenar las frutas lanzadas por los turistas.
  - Permitir que los monos recojan las frutas.
  - Sincronizar el acceso entre los hilos productores y consumidores.
  - Notificar a los hilos cuando el parque esté lleno o vacío.
- **Capacidad**: El parque tiene un límite de almacenamiento configurable (desde el ejecutable yo he pasado por parámetro 5 frutas).

## Funcionamiento del Simulador

### Flujo General

1. **Inicio**:

   - Se inicializan los hilos productores (turistas) y consumidores (monos) en [App.java](./src/App.java).
   - Se configura el recurso compartido con una capacidad máxima en [App.java](./src/App.java).

2. **Producción (Turistas)**:

   - Cada [turista](./src/net/salesianos/threads/Tourist.java) selecciona una fruta aleatoria de una lista predefinida en [FoodRepository](./src/net/salesianos/constants/FoodRepository.java).
   - Simula el tiempo de producción de la fruta. La fruta elegida y el tiempo en recogerla son aleatorios, utilizando funciones de [Utils](./src/net/salesianos/utils/Utils.java).
   - Lanza la fruta al [parque (recurso compartido)](./src/net/salesianos/shared/SharedResource.java).
   - Si el parque está lleno, el turista espera hasta que haya espacio disponible.

3. **Consumo (Monos)**:

   - Cada [mono](./src/net/salesianos/threads/Monkey.java) recoge una fruta del parque.
   - Simula el tiempo de consumo de la fruta, aleatoriamente también con una función de [Utils](./src/net/salesianos/utils/Utils.java).
   - Si el parque está vacío, el mono espera hasta que haya frutas disponibles.

4. **Finalización**:

   - Cuando todos los turistas terminan de lanzar frutas, notifican a los monos que no habrá más frutas.
   - Los monos terminan su trabajo una vez que han consumido todas las frutas disponibles.

## Ejemplo de Ejecución

### Entrada

```java
SharedResource monkeyPark = new SharedResource(5);

Tourist touristOne = new Tourist(1, "(👩) Alice", 3, FoodRepository.FOOD, 3);
Tourist touristTwo = new Tourist(2, "(👴) Bob", 3, FoodRepository.FOOD, 3);

Monkey monkeyOne = new Monkey(1, "(🐒) George", 3, 2);
Monkey monkeyTwo = new Monkey(2, "(🐒) Charlie", 3, 4);

touristOne.start();
touristTwo.start();
monkeyOne.start();
monkeyTwo.start();
```

### Posible Salida

```bash
╔════════════════════════════════════════════════╗
║  🍌 Welcome to the Monkey Park Simulator! 🙊   ║
╚════════════════════════════════════════════════╝

(✋) Monkey Park is empty! Monkeys have nothing to take.
(✋) Monkey Park is empty! Monkeys have nothing to take.
(👴) Bob is picking up: (🥝) Kiwi
(👩) Alice is picking up: (🥭) Mango
(👴) Bob threw (🥝) kiwi to the Monkey Park!
(👴) Bob is picking up: (🍍) Pineapple
(🐒) George took the (🥝) kiwi!
(✋) Monkey Park is empty! Monkeys have nothing to take.
(👩) Alice threw (🥭) mango to the Monkey Park!
(👩) Alice is picking up: (🍉) Watermelon
(🐒) Charlie took the (🥭) mango!
(🐒) George is eating: (🥝) Kiwi
(🐒) Charlie is eating: (🥭) Mango
(👩) Alice threw (🍉) watermelon to the Monkey Park!
(👩) Alice is picking up: (🍎) Red Apple
(🐒) George took the (🍉) watermelon!
(🐒) George is eating: (🍉) Watermelon
(✋) Monkey Park is empty! Monkeys have nothing to take.
(👴) Bob threw (🍍) pineapple to the Monkey Park!
(👴) Bob is picking up: (🍏) Green Apple
(🐒) Charlie took the (🍍) pineapple!
(🐒) Charlie is eating: (🍍) Pineapple
(👩) Alice threw (🍎) red apple to the Monkey Park!
(🐒) George took the (🍎) red apple!
(🐒) George is eating: (🍎) Red Apple
(👩) Alice has finished picking up fruits. 👋
(👴) Bob threw (🍏) green apple to the Monkey Park!
(👴) Bob has finished picking up fruits. 👋
(🐒) George has finished eating.
(🐒) Charlie took the (🍏) green apple!
(🐒) Charlie is eating: (🍏) Green Apple
(🐒) Charlie has finished eating.
```
