package com.just.agentweb;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class Action implements Parcelable {
    public static final Parcelable.Creator<Action> CREATOR = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final transient int f21725d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final transient int f21726e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final transient int f21727f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f21728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21730c;

    public static class a implements Parcelable.Creator<Action> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Action createFromParcel(Parcel parcel) {
            return new Action(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Action[] newArray(int i10) {
            return new Action[i10];
        }
    }

    public Action() {
        this.f21728a = new ArrayList<>();
    }

    public static Action a(String[] strArr) {
        Action action = new Action();
        action.j(1);
        action.z(new ArrayList<>(Arrays.asList(strArr)));
        return action;
    }

    public void C(String[] strArr) {
        this.f21728a = new ArrayList<>(Arrays.asList(strArr));
    }

    public int b() {
        return this.f21729b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f21730c;
    }

    public ArrayList<String> g() {
        return this.f21728a;
    }

    public void j(int i10) {
        this.f21729b = i10;
    }

    public Action s(int i10) {
        this.f21730c = i10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f21728a);
        parcel.writeInt(this.f21729b);
        parcel.writeInt(this.f21730c);
    }

    public void z(ArrayList<String> arrayList) {
        this.f21728a = arrayList;
    }

    public Action(Parcel parcel) {
        this.f21728a = new ArrayList<>();
        this.f21728a = parcel.createStringArrayList();
        this.f21729b = parcel.readInt();
        this.f21730c = parcel.readInt();
    }
}
