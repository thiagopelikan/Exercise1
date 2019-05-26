package br.com.pelikan.exercise1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Burger implements Parcelable {

    private final int id;
    private final String name;
    private final String price;
    private final String image;

    public Burger(int id, String name, String price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    protected Burger(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readString();
        image = in.readString();
    }

    public static final Creator<Burger> CREATOR = new Creator<Burger>() {
        @Override
        public Burger createFromParcel(Parcel in) {
            return new Burger(in);
        }

        @Override
        public Burger[] newArray(int size) {
            return new Burger[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(price);
        parcel.writeString(image);
    }
}
