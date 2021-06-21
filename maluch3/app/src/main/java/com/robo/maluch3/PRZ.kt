package com.robo.maluch3

class PRZ {
    var temperarura=0.0
    var wilgotnosc=0.0
    var przeszkoda="false"
    var maxTemperatura=0.0
    var maxWilgotnosc=0.0
    var obstacleNumbers=0
    constructor(przeszkoda:String,maxTemperatura:Double,maxWilgotnosc:Double,obstacleNumbers:Int){
        this.temperarura=temperarura
        this.wilgotnosc=wilgotnosc
        this.przeszkoda=przeszkoda
        this.maxTemperatura=maxTemperatura
        this.maxWilgotnosc=maxWilgotnosc
        this.obstacleNumbers=obstacleNumbers
    }
}