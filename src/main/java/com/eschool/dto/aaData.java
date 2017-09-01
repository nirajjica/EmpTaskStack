package com.eschool.dto;

import com.eschool.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class aaData<T> {
    @JsonView(Views.Public.class)
    private int sEcho;
    @JsonView(Views.Public.class)
    private long iTotalRecords;
    @JsonView(Views.Public.class)
    private int iTotalDisplayRecords;
    @JsonView(Views.Public.class)
    private List<T> aaData = null;
    @JsonView(Views.Public.class)
    private int page = 0;
    @JsonView(Views.Public.class)
    private int iDisplayStart = 0;
    @JsonView(Views.Public.class)
    private int iDisplayLength = 0;

    public aaData() {
    }

    public aaData(final int sEcho, final int page, final int iDisplayStart, final int iDisplayLength, final long iTotalRecords, final int iTotalDisplayRecords, final List<T> aaData) {
        this.sEcho = sEcho;
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.aaData = aaData;
        this.page = page;
        this.iDisplayStart = iDisplayStart;
        this.iDisplayLength = iDisplayLength;
    }

    public int getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public int getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }

    public int getsEcho() {
        return sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    public long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    @Override
    public String toString() {
        return "aaData{" + "aaData=" + aaData + ", sEcho=" + sEcho
                + ", iTotalRecords=" + iTotalRecords
                + ", iTotalDisplayRecords=" + iTotalDisplayRecords + '}';
    }

}
