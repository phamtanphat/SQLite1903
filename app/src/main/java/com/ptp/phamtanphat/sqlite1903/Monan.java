package com.ptp.phamtanphat.sqlite1903;

/**
 * Created by KhoaPhamPC on 11/5/2018.
 */

public class Monan {
    private int Id;
    private String Tenmonan;
    private int Giamonan;

    public Monan(int id, String tenmonan, int giamonan) {
        Id = id;
        Tenmonan = tenmonan;
        Giamonan = giamonan;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenmonan() {
        return Tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        Tenmonan = tenmonan;
    }

    public int getGiamonan() {
        return Giamonan;
    }

    public void setGiamonan(int giamonan) {
        Giamonan = giamonan;
    }
}
