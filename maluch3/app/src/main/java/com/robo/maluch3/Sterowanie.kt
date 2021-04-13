package com.robo.maluch3

class Sterowanie {
    var RC="S" // kierunek w sterowaniu RC
    var numero=0 //punkt w sterowaniiu autonomicznym
    var A="R" //domyślnie wartość R(tryb RC) albo A- autonomiczny
    //var przeszkoda="" ,przeszkoda:String
    constructor(RC:String,numero:Int,A:String){
        this.RC=RC
        this.numero=numero
        this.A=A
       // this.przeszkoda=przeszkoda
    }

}