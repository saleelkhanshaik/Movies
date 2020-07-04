package com.example.krishna.activitydetails

import android.os.Parcel
import android.os.Parcelable

data class UserData(val name: String?, val age:Int):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(name)
        p0?.writeInt(age!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserData> {
        override fun createFromParcel(parcel: Parcel): UserData {
            return UserData(parcel)
        }

        override fun newArray(size: Int): Array<UserData?> {
            return arrayOfNulls(size)
        }
    }

}
