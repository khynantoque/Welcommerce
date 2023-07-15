package com.khynsoft.welcommerce.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Business: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke()
    var ownerId: String = ""
    var businesssName: String = ""
    var description: String = ""
    var addressBuildingName: String = ""
    var addressStreet: String = ""
    var addressBrgy: String = ""
    var addressCity: String = ""
    var postalCode: String = ""
    var images: RealmList<String> = realmListOf()
    var creationDate: RealmInstant = RealmInstant.from(System.currentTimeMillis(), 0)
}
