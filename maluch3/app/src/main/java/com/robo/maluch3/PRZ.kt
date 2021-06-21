package com.robo.maluch3

class PRZ {
    var temperatura=0.0
    var wilgotnosc=0.0
    var przeszkoda="false"
    var maxTemperatura=0.0
    var maxWilgotnosc=0.0
    var obstacleNumbers=0
    constructor(temperatura:Double,wilgotnosc:Double,przeszkoda:String,maxTemperatura:Double,maxWilgotnosc:Double,obstacleNumbers:Int){
        this.temperatura=temperatura
        this.wilgotnosc=wilgotnosc
        this.przeszkoda=przeszkoda
        this.maxTemperatura=maxTemperatura
        this.maxWilgotnosc=maxWilgotnosc
        this.obstacleNumbers=obstacleNumbers
    }
}