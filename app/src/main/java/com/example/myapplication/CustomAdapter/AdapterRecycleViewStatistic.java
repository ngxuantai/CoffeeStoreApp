package com.example.myapplication.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DAO.TableDAO;
import com.example.myapplication.DAO.EmployeeDAO;
import com.example.myapplication.DTO.OrderDTO;
import com.example.myapplication.DTO.EmployeeDTO;
import com.example.myapplication.R;

import java.util.List;

public class AdapterRecycleViewStatistic extends RecyclerView.Adapter<AdapterRecycleViewStatistic.ViewHolder> {
    Context context;
    int layout;
    List<OrderDTO> orderDTOList;
    EmployeeDAO employeeDAO;
    TableDAO tableDAO;

    public AdapterRecycleViewStatistic(Context context, int layout, List<OrderDTO> orderDTOList){

        this.context =context;
        this.layout = layout;
        this.orderDTOList = orderDTOList;
        employeeDAO = new EmployeeDAO(context);
        tableDAO = new TableDAO(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterRecycleViewStatistic.ViewHolder holder, int position) {
        OrderDTO orderDTO = orderDTOList.get(position);
        holder.txt_customstatistic_MaDon.setText("Mã đơn: "+ orderDTO.getOrderID());
        holder.txt_customstatistic_NgayDat.setText(orderDTO.getDate());
        if(orderDTO.getTotalAmount().equals("0"))
        {
            holder.txt_customstatistic_TongTien.setVisibility(View.INVISIBLE);
        }else {
            holder.txt_customstatistic_TongTien.setVisibility(View.VISIBLE);
        }

        if (orderDTO.getStatus().equals("true"))
        {
            holder.txt_customstatistic_TrangThai.setText("Đã thanh toán");
        }else {
            holder.txt_customstatistic_TrangThai.setText("Chưa thanh toán");
        }
        EmployeeDTO employeeDTO = employeeDAO.getEmployeeById(orderDTO.getEmployeeID());
        holder.txt_customstatistic_TenNV.setText(employeeDTO.getFullName());
        holder.txt_customstatistic_BanDat.setText(tableDAO.getTableNameById(orderDTO.getTableID()));
    }

    @Override
    public int getItemCount() {
        return orderDTOList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_customstatistic_MaDon, txt_customstatistic_NgayDat, txt_customstatistic_TenNV,
                txt_customstatistic_BanDat, txt_customstatistic_TongTien,txt_customstatistic_TrangThai;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txt_customstatistic_MaDon = itemView.findViewById(R.id.txt_customstatistic_MaDon);
            txt_customstatistic_NgayDat = itemView.findViewById(R.id.txt_customstatistic_NgayDat);
            txt_customstatistic_TenNV = itemView.findViewById(R.id.txt_customstatistic_TenNV);
            txt_customstatistic_BanDat = itemView.findViewById(R.id.txt_customstatistic_BanDat);
            txt_customstatistic_TongTien = itemView.findViewById(R.id.txt_customstatistic_TongTien);
            txt_customstatistic_TrangThai = itemView.findViewById(R.id.txt_customstatistic_TrangThai);
        }
    }
}
