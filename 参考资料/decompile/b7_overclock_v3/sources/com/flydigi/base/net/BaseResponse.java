package com.flydigi.base.net;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class BaseResponse<T> implements Serializable {

    @SerializedName("data")
    public T data;

    @SerializedName("message")
    public String msg;

    @SerializedName("status")
    public int state;

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) o10;
        return this.state == baseResponse.state && Objects.equals(this.msg, baseResponse.msg) && Objects.equals(this.data, baseResponse.data);
    }

    public int hashCode() {
        int i10 = this.state * 31;
        String str = this.msg;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        T t10 = this.data;
        return iHashCode + (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        return "BaseResponse{state=" + this.state + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
