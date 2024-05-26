package com.example.myapplication.DTO;

public class OrderDTO {
    int OrderID, TableID, EmployeeID;
    String Status, Date,TotalAmount;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int maDonDat) {
        OrderID = maDonDat;
    }

    public int getTableID() {
        return TableID;
    }

    public void setTableID(int tableId) {
        TableID = tableId;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeId) {
        EmployeeID = employeeId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }
}
