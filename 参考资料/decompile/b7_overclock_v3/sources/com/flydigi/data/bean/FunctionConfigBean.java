package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class FunctionConfigBean implements Parcelable {
    public static final Parcelable.Creator<FunctionConfigBean> CREATOR = new Parcelable.Creator<FunctionConfigBean>() { // from class: com.flydigi.data.bean.FunctionConfigBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FunctionConfigBean createFromParcel(Parcel source) {
            return new FunctionConfigBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FunctionConfigBean[] newArray(int size) {
            return new FunctionConfigBean[size];
        }
    };
    private HashMap<String, Integer> config;

    public FunctionConfigBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HashMap<String, Integer> getConfig() {
        return this.config;
    }

    public void setConfig(HashMap<String, Integer> config) {
        this.config = config;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.config.size());
        for (Map.Entry<String, Integer> entry : this.config.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeValue(entry.getValue());
        }
    }

    public FunctionConfigBean(Parcel in2) {
        int i10 = in2.readInt();
        this.config = new HashMap<>(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.config.put(in2.readString(), (Integer) in2.readValue(Integer.class.getClassLoader()));
        }
    }
}
