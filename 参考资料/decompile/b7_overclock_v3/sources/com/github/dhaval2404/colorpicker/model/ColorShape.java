package com.github.dhaval2404.colorpicker.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import xk.c;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@c
@d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003HÖ\u0001j\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/z1;", "writeToParcel", "<init>", "(Ljava/lang/String;I)V", "CIRCLE", "SQAURE", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public enum ColorShape implements Parcelable {
    CIRCLE,
    SQAURE;


    @k
    public static final Parcelable.Creator<ColorShape> CREATOR = new Parcelable.Creator<ColorShape>() { // from class: com.github.dhaval2404.colorpicker.model.ColorShape.a
        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ColorShape createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return ColorShape.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ColorShape[] newArray(int i10) {
            return new ColorShape[i10];
        }
    };

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ColorShape[] valuesCustom() {
        ColorShape[] colorShapeArrValuesCustom = values();
        return (ColorShape[]) Arrays.copyOf(colorShapeArrValuesCustom, colorShapeArrValuesCustom.length);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(name());
    }
}
