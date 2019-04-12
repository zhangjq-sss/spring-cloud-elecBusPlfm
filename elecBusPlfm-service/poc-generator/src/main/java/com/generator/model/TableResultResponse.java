package com.generator.model;

import java.util.List;

import com.common.msg.BaseResponse;

public class TableResultResponse<Map> extends BaseResponse {

    TableData<Map> data;

    public TableResultResponse(long total, List<Map> rows) {
        this.data = new TableData<Map>(total, rows);
    }

    public TableResultResponse() {
        this.data = new TableData<Map>();
    }

    TableResultResponse<Map> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<Map> total(List<Map> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<Map> getData() {
        return data;
    }

    public void setData(TableData<Map> data) {
        this.data = data;
    }

    @SuppressWarnings("hiding")
	class TableData<Map> {
        long total;
        List<Map> rows;

        public TableData(long total, List<Map> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<Map> getRows() {
            return rows;
        }

        public void setRows(List<Map> rows) {
            this.rows = rows;
        }
    }
}
