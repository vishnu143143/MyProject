package com.copykatha.assignment.Models

class SecondModel {
    var name:String? = null
    var handle:String? = null
    var favoriteCount:Int?= 0
var retweetCount:Int?=0
    var profileImageUrl:String?=null
    var text:String?=null
    constructor(name:String?,handle:String?,favoriteCount:Int?,retweetCount:Int?,profileImageUrl:String?,text:String?){
        this.name = name
        this.handle=handle
        this.favoriteCount =favoriteCount
        this.retweetCount=retweetCount
        this.profileImageUrl=profileImageUrl
        this.text=text
    }
}