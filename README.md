# Space Invaders en Java

Este proyecto es una implementación del clásico juego "Space Invaders" desarrollada en Java, como parte de la asignatura "Tecnología de la Programación 1" (TP1) de la Universidad Complutense de Madrid (UCM). El objetivo principal es aplicar y demostrar el uso de conceptos avanzados de programación orientada a objetos, incluyendo herencia, polimorfismo y manejo de excepciones.

## Características del Proyecto

- **Programación Orientada a Objetos (POO):** El diseño del juego se basa en los principios de la POO, promoviendo un código modular, reutilizable y fácil de mantener.

- **Herencia y Polimorfismo:** Se utilizan para modelar las diferentes entidades del juego, como naves, enemigos y proyectiles, permitiendo una jerarquía de clases clara y flexible.

- **Manejo de Excepciones:** Se implementan para gestionar errores y situaciones inesperadas durante la ejecución del juego, mejorando su robustez y experiencia de usuario.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **src/tp1:** Contiene el código fuente del juego, dividido en varios paquetes según la funcionalidad y responsabilidad de las clases.

- **README.md:** Este archivo, que proporciona una visión general del proyecto, instrucciones de instalación y uso.

## Requisitos del Sistema

- **Java Development Kit (JDK):** Versión 8 o superior.

- **Entorno de Desarrollo Integrado (IDE):** Recomendado Eclipse para una mejor experiencia de desarrollo.

## Instalación y Ejecución

1. **Clonar el Repositorio:**
   
   git clone https://github.com/Fariiixm/TECNOLOGIA-DE-LA-PROGRAMACION.git
   cd TECNOLOGIA-DE-LA-PROGRAMACION/src/tp1
   

2. **Compilar el Código:**
   Configurar previamente en debug las semillas (seed) a generar y el nivel EASY HARD ENSANE

   javac -d bin src/tp1/*.java
   

4. **Ejecutar el Juego:**
   
   java -cp bin tp1.Main
  

## Uso del Juego

Al iniciar el juego, el jugador controla una nave espacial que puede moverse horizontalmente y disparar proyectiles para eliminar oleadas de enemigos que descienden desde la parte superior de la pantalla. El objetivo es destruir a todos los enemigos sin ser alcanzado por ellos.
