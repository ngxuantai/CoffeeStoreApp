package com.example.myapplication.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.DAO.TableDAO;
import com.example.myapplication.DAO.EmployeeDAO;
import com.example.myapplication.DTO.OrderDTO;
import com.example.myapplication.DTO.EmployeeDTO;
import com.example.myapplication.R;

import java.util.List;

public class AdapterDisplayStatistic extends BaseAdapter {
    Context context;
    int layout;
    List<OrderDTO> orderDTOS;
    ViewHolder viewHolder;
    EmployeeDAO employeeDAO;
    TableDAO tableDAO;

    public AdapterDisplayStatistic(Context context, int layout, List<OrderDTO> orderDTOS){
        this.context = context;
        this.layout = layout;
        this.orderDTOS = orderDTOS;
        employeeDAO = new EmployeeDAO(context);
        tableDAO = new TableDAO(context);
    }

    @Override
    public int getCount() {
        return orderDTOS.size();
    }

    @Override
    public Object getItem(int position) {
        return orderDTOS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return orderDTOS.get(position).getOrderID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            viewHolder.txt_customstatistic_MaDon = (TextView)view.findViewById(R.id.txt_customstatistic_MaDon);
            viewHolder.txt_customstatistic_NgayDat = (TextView)view.findViewById(R.id.txt_customstatistic_NgayDat);
            viewHolder.txt_customstatistic_TenNV = (TextView)view.findViewById(R.id.txt_customstatistic_TenNV);
            viewHolder.txt_customstatistic_TongTien = (TextView)view.findViewById(R.id.txt_customstatistic_TongTien);
            viewHolder.txt_customstatistic_TrangThai = (TextView)view.findViewById(R.id.txt_customstatistic_TrangThai);
            viewHolder.txt_customstatistic_BanDat = (TextView)view.findViewById(R.id.txt_customstatistic_BanDat);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        OrderDTO orderDTO = orderDTOS.get(position);

        viewHolder.txt_customstatistic_MaDon.setText("Mã đơn: "+ orderDTO.getOrderID());
        viewHolder.txt_customstatistic_NgayDat.setText(orderDTO.getDate());
        viewHolder.txt_customstatistic_TongTien.setText(orderDTO.getTotalAmount()+" VNĐ");
        if (orderDTO.getStatus().equals("true"))
        {
            viewHolder.txt_customstatistic_TrangThai.setText("Đã thanh toán");
        }else {
            viewHolder.txt_customstatistic_TrangThai.setText("Chưa thanh toán");
        }
        EmployeeDTO employeeDTO = employeeDAO.getEmployeeById(orderDTO.getOrderID());
        viewHolder.txt_customstatistic_TenNV.setText(employeeDTO.getFullName());
        viewHolder.txt_customstatistic_BanDat.setText(tableDAO.getTableNameById(orderDTO.getTableID()));

        return view;
    }
    public class ViewHolder{
        TextView txt_customstatistic_MaDon, txt_customstatistic_NgayDat, txt_customstatistic_TenNV
                ,txt_customstatistic_TongTien,txt_customstatistic_TrangThai, txt_customstatistic_BanDat;

    }
}
