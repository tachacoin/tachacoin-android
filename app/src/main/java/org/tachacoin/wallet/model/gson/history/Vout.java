package org.tachacoin.wallet.model.gson.history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Vout extends RealmObject implements TransactionInfo {

    @SerializedName("value")
    @Expose
    @Ignore
    private BigDecimal value;
    @SerializedName("address")
    @Expose
    private String address;
    private String valueString;
    private boolean isOwnAddress = false;

    /**
     * Constructor for unit testing
     */
    public Vout() {
    }

    /**
     * Constructor for unit testing
     */
    public Vout(String address) {
        this.address = address;
    }

    public Vout(String address, String valueString) {
        this.address = address;
        this.valueString = valueString;
    }

    public boolean isOwnAddress() {
        return isOwnAddress;
    }

    public void setOwnAddress(boolean ownAddress) {
        isOwnAddress = ownAddress;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }
}
