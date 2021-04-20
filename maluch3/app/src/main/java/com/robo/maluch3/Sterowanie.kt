package com.robo.maluch3

class Sterowanie {
    var RC="S" // kierunek w sterowaniu RC
    var numero=0 //punkt w sterowaniiu autonomicznym
    var tryb="R" //domyślnie wartość R(tryb RC) albo A- autonomiczny
    //var przeszkoda="" ,przeszkoda:String
    constructor(RC:String,numero:Int,tryb:String){
        this.RC=RC
        this.numero=numero
        this.tryb=tryb
       // this.przeszkoda=przeszkoda
    }

}