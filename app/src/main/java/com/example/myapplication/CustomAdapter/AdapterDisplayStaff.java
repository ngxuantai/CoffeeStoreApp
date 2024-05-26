package com.example.myapplication.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.DAO.RoleDAO;
import com.example.myapplication.DTO.EmployeeDTO;
import com.example.myapplication.R;

import java.util.List;

public class AdapterDisplayStaff extends BaseAdapter {
    Context context;
    int layout;
    List<EmployeeDTO> employeeDTOS;
    ViewHolder viewHolder;
    RoleDAO roleDAO;

    public AdapterDisplayStaff(Context context, int layout, List<EmployeeDTO> employeeDTOS){
        this.context = context;
        this.layout = layout;
        this.employeeDTOS = employeeDTOS;
        roleDAO = new RoleDAO(context);
    }

    @Override
    public int getCount() {
        return employeeDTOS.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeDTOS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return employeeDTOS.get(position).getEmployId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            viewHolder.img_customstaff_HinhNV = (ImageView)view.findViewById(R.id.img_customstaff_HinhNV);
            viewHolder.txt_customstaff_TenNV = (TextView)view.findViewById(R.id.txt_customstaff_TenNV);
            viewHolder.txt_customstaff_TenQuyen = (TextView)view.findViewById(R.id.txt_customstaff_TenQuyen);
            viewHolder.txt_customstaff_SDT = (TextView)view.findViewById(R.id.txt_customstaff_SDT);
            viewHolder.txt_customstaff_Email = (TextView)view.findViewById(R.id.txt_customstaff_Email);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        EmployeeDTO employeeDTO = employeeDTOS.get(position);

        viewHolder.txt_customstaff_TenNV.setText(employeeDTO.getFullName());
        viewHolder.txt_customstaff_TenQuyen.setText(roleDAO.getRoleById(employeeDTO.getRoleId()));
        viewHolder.txt_customstaff_SDT.setText(employeeDTO.getPhoneNumber());
        viewHolder.txt_customstaff_Email.setText(employeeDTO.getEmail());

        return view;
    }

    public class ViewHolder{
        ImageView img_customstaff_HinhNV;
        TextView txt_customstaff_TenNV, txt_customstaff_TenQuyen,txt_customstaff_SDT, txt_customstaff_Email;
    }
}
