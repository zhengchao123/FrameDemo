package com.rcb.financialservice.net.netretrofit.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class FindFaceEntity implements Parcelable {

    private long id;
    private String name;
    private int userType;
    private String avatar = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1571195072&di=d20134da537d2c4aa05d7b496339de7c&src=http://www.banyingle.com/shop/images_shop/24622/2012-01-12/69872012112106083970703.jpg";

    public FindFaceEntity() {
    }

    protected FindFaceEntity(Parcel in) {
        id = in.readLong();
        name = in.readString();
        userType = in.readInt();
        avatar = in.readString();
    }

    public static final Creator<FindFaceEntity> CREATOR = new Creator<FindFaceEntity>() {
        @Override
        public FindFaceEntity createFromParcel(Parcel in) {
            return new FindFaceEntity(in);
        }

        @Override
        public FindFaceEntity[] newArray(int size) {
            return new FindFaceEntity[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "FindFaceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userType=" + userType +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeInt(userType);
        dest.writeString(avatar);
    }
}
