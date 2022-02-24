poolobject
==========

[![Java CI](https://github.com/dgm1003/poolobject/actions/workflows/ci.yml/badge.svg)](https://github.com/dgm1003/poolobject/actions/workflows/ci.yml) [![Build Status](https://app.travis-ci.com/dgm1003/poolobject.svg?branch=master)](https://app.travis-ci.com/dgm1003/poolobject) [![codecov](https://codecov.io/gh/dgm1003/poolobject/branch/master/graph/badge.svg)](https://codecov.io/gh/dgm1003/poolobject)

Java code example of creational design pattern pool object

Workshop to use good practices in software developmemnt: testing and measurement.

Authors:

- Carlos Lopez Nozal
- Jesus Alonso Abad

- Diego García Muñoz
- Óscar Valverde Escobar
 
# Índice
1. [Introducción](#intro)
2. [Objetivos](#objetivos)
3. [Enunciado](#enunciado)
4. [Solución](#solucion)
5. [Cuestiones](#cuestiones)
   1. [¿Se ha realizado trabajo en equipo?](#c1)
   2. [¿Tiene calidad el conjunto de pruebas disponibles?](#c2)
   3. [¿Cuál es el esfuerzo invertido en realizar la actividad?](#c3)
   4. [¿Cuál es el número de fallos encontrados en el código?](#c4)

---

## INTRODUCCIÓN <a name="intro"></a>
Práctica centrada en la monitorización de un proceso de integración contínua para las pruebas de un código, para que se comprendan los conceptos de medición relacionados con las pruebas software.

## OBJETIVOS <a name="objetivos"></a>
 - Comprender los objetivos de medición relacionados con la caracterización y la evaluación de productos, procesos y recursos software
 - Comprender, aplicar y analizar técnicas de medición sobre entidades de productos software relacionados con conjuntos de pruebas de software
 - Comprender, aplicar y analizar medidas relacionadas sobre entidades de proceso y recursos de prueba del software

## ENUNCIADO <a name="enunciado"></a>
En la práctica se va simular un pequeño desarrollo de un producto software para realizar mediciones sobre él. El objetivo es establecer un caso de estudio que sirva para caracterizar y evaluar tanto el producto desarrollado como el proceso seguido.
#### (a) Descripción del producto
Dado un código de ejemplo del patrón diseño creacional Pool Object, se debe crear una batería de pruebas tal que las coberturas de sus clases sean del 100%. El código de las clases se puede obtener en el repositorio https://github.com/clopezno/poolobject. La batería de pruebas JUnit debe estar contenida en la clase ubu.gii.dass.test.c01.ReuseblePoolTest.java.
#### (b) Descripción del proceso
El proceso de desarrollo de la batería de pruebas se va a gestionar utilizando el control de versiones del sistema Git proporcionado por el repositorio de proyectos GitHub (https://github.com ). 
Los pasos para gestionar el procesos son los siguientes:
1. Cada miembro del equipo tiene que estar registrado en GitHub, Travis CI y Codecov.io.
2. Uno de los miembros tiene que realizar un fork del repositorio donde se encuentra el código que se quiere probar https://github.com/clopezno/poolobject. El nuevo repositorio tiene que ser público.
3. Invitar al resto de miembros del equipo para que puedan participar en el desarrollo de las pruebas.
4. Vincular el proyecto con Travis CI y Codecov.io.
5. Cada nuevo test realizado ejecutar un commit/push al repositorio del grupo. El texto del commit tiene que describir el caso de prueba añadido.
6. Verificar el resultado de las pruebas en el pipeline de integración continua y cómo la calidad del producto va mejorando con las sucesivas integraciones.

## SOLUCIÓN <a name="solucion"></a>
Se han realizado las pruebas en la clase ubu.gii.dass.test.c01.ReuseblePoolTest.java, 

## CUESTIONES <a name="cuestiones"></a>
### ¿Se ha realizado trabajo en equipo? <a name="c1"></a>

### ¿Tiene calidad el conjunto de pruebas disponibles? <a name="c2"></a>

### ¿Cuál es el esfuerzo invertido en realizar la actividad? <a name="c3"></a>

### ¿Cuál es el número de fallos encontrados en el código? <a name="c4"></a>
