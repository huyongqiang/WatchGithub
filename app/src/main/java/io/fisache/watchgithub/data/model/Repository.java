package io.fisache.watchgithub.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Repository implements Parcelable {
    public static final Parcelable.Creator<Repository> CREATOR = new Parcelable.Creator<Repository>() {
        public Repository createFromParcel(Parcel source) {
            return new Repository(source);
        }

        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    public long id;
    public String name;
    public String html_url;
    public String desc;
    public int star_count;
    public int fork_count;
    public boolean fork;
    public String pushed_at;

    public Repository() {

    }

    public Repository(long id, String name, String html_url, String desc, int star_count, int fork_count, boolean fork, String pushed_at) {
        this.id = id;
        this.name = name;
        this.html_url = html_url;
        this.desc = desc;
        this.star_count = star_count;
        this.fork_count = fork_count;
        this.fork = fork;
        this.pushed_at = pushed_at;
    }

    protected Repository(Parcel in) {
        id = in.readLong();
        name = in.readString();
        html_url = in.readString();
        desc = in.readString();
        star_count = in.readInt();
        fork_count = in.readInt();
        fork = (in.readInt() == 1 ? true : false);
        pushed_at = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(html_url);
        dest.writeString(desc);
        dest.writeInt(star_count);
        dest.writeInt(fork_count);
        dest.writeInt((fork ? 1 : 0));
        dest.writeString(pushed_at);
    }
}
