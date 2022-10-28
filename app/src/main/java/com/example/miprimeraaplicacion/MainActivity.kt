package com.example.miprimeraaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validarMayorEdad(18)
        multiplicarN(5)
        listadoParalelo()
        val carro = Carro()
        carro.imprimir()
        calcularIVA(50)
        validarCedula("1102775283")
    }

    fun validarMayorEdad(edad: Int){
        if(edad < 18){
            println("Usted es menor de edad")
        }else{
            println("Ustde es mayor de edad")

        }
    }

    fun multiplicarN(n: Int){
        for (i in 1..10){
            println(i * n)
        }

        println();

        for (i in 10 downTo 1)
            println(i * n)
    }

    fun listadoParalelo(){
        var listadoEstudiantes = listOf<String>("Persona 1",
            "Persona 2",
            "Persona 3",
            "Persona 4",
            "Persona 5",)

        listadoEstudiantes.forEach {
            println(it)
        }

        val subGrupos: Map<String, String> = mapOf(
            "Martinez Mateo " to "Mascotas",
            "Alvarado Eric " to "Registro UTPL",
            "Leiva Diego" to "Mascotas",
            "Cuenca Erick " to "Registro UTPL",
            "Ojeda Rommel " to "Registro UTPL",
            "Caraguay Miguel" to "Mascotas",
        )

        val ordenado = subGrupos.toSortedMap()
        println(ordenado)
    }



    class Carro {

        private var traccion: String = "Buena"
        private var motor: String = "Buena"
        private var tipoVehiculo: String = "Buena"
        private var capacidad: Int = 5


        fun imprimir() {
            println("Traccion:" + traccion)
            println("Motor:" + motor)
            println("Tipo Vehiculo:" + tipoVehiculo)
            println("Capacidad:" + capacidad)
        }
    }


    fun calcularIVA(valor: Int){
        println("El iva del valor " + valor + " es de " + (valor*0.12))
    }

    fun validarCedula(cedula: Int){
        var valores = listOf<Int>(2,1,2,1,2,1,2,1,2)
    }


    fun validarCedula(cedula: String){
        var valores = listOf<Int>(2,1,2,1,2,1,2,1,2)
        val listaValores = cedula.toList()
        var total = 0
        for(i in 0..(listaValores.size - 2)){
            var totalNum = valores[i] * listaValores.get(i).digitToInt()
            var sum = 0
            if(totalNum>=10){
                while (totalNum > 0) {
                    var aux = totalNum % 10
                    sum += aux
                    totalNum /= 10
                }
                totalNum = sum
            }
            total += totalNum
        }

        if(10-(total % 10) == listaValores.last().digitToInt()){
            println("Cedula correcta")
        }else{
            println("Cedula incorrecta")

        }
    }
}