package com.example.krishna.activitydetails;

import android.os.Parcel;
import android.os.Parcelable;

public class UserName implements Parcelable {
    private String name;
    private int age;

    protected UserName(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<UserName> CREATOR = new Creator<UserName>() {
        @Override
        public UserName createFromParcel(Parcel in) {
            return new UserName(in);
        }

        @Override
        public UserName[] newArray(int size) {
            return new UserName[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected UserName(Parcel in, String name, int age) {
        this.name = name;
        this.age = age;
    }
    public UserName( String name, int age){
        this.age = age;
        this.name = name;
    }

    public static Creator<UserName> getCREATOR() {
        return CREATOR;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeString(name);
    }
}
