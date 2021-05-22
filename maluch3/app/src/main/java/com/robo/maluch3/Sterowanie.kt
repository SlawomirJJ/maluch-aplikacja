package com.robo.maluch3

class Sterowanie {
    var RC="S" // kierunek w sterowaniu RC
    var numero=0 //punkt w sterowaniiu autonomicznym
    var tryb="R" //domyślnie wartość R(tryb RC) albo A- autonomiczny
    var predkosc_zadana=255
    var wymiar=2 // wymiar planszy
    constructor(RC:String, numero: Int, tryb:String, predkosc_zadana:Int,wymiar:Int){
        this.RC=RC
        this.numero=numero
        this.tryb=tryb
        this.predkosc_zadana=predkosc_zadana
        this.wymiar=wymiar
    }

}