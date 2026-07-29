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
@d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/z1;", "writeToParcel", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "_50", "_100", "_200", "_300", "_400", "_500", "_600", "_700", "_800", "_900", "A100", "A200", "A300", "A400", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public enum ColorSwatch implements Parcelable {
    _50("50"),
    _100("100"),
    _200("200"),
    _300("300"),
    _400("400"),
    _500("500"),
    _600("600"),
    _700("700"),
    _800("800"),
    _900("900"),
    A100("a100"),
    A200("a200"),
    A300("a300"),
    A400("a400");


    @k
    public static final Parcelable.Creator<ColorSwatch> CREATOR = new Parcelable.Creator<ColorSwatch>() { // from class: com.github.dhaval2404.colorpicker.model.ColorSwatch.a
        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ColorSwatch createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return ColorSwatch.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ColorSwatch[] newArray(int i10) {
            return new ColorSwatch[i10];
        }
    };

    @k
    private final String value;

    ColorSwatch(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ColorSwatch[] valuesCustom() {
        ColorSwatch[] colorSwatchArrValuesCustom = values();
        return (ColorSwatch[]) Arrays.copyOf(colorSwatchArrValuesCustom, colorSwatchArrValuesCustom.length);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @k
    public final String getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(name());
    }
}
