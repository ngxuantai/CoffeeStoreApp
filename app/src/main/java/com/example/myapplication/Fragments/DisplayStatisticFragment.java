package com.example.myapplication.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.Activities.DetailStatisticActivity;
import com.example.myapplication.Activities.HomeActivity;
import com.example.myapplication.CustomAdapter.AdapterDisplayStatistic;
import com.example.myapplication.DAO.OrderDAO;
import com.example.myapplication.DTO.OrderDTO;
import com.example.myapplication.R;

import java.util.List;

public class DisplayStatisticFragment extends Fragment {
    ListView lvStatistic;
    List<OrderDTO> orderDTOS;
    OrderDAO orderDAO;
    AdapterDisplayStatistic adapterDisplayStatistic;
    FragmentManager fragmentManager;
    int madon, manv, maban;
    String ngaydat, tongtien;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displaystatistic_layout,container,false);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Quản lý thống kê");
        setHasOptionsMenu(true);

        lvStatistic = (ListView)view.findViewById(R.id.lvStatistic);
        orderDAO = new OrderDAO(getActivity());

        orderDTOS = orderDAO.getListOrder();
        adapterDisplayStatistic = new AdapterDisplayStatistic(getActivity(),R.layout.custom_layout_displaystatistic, orderDTOS);
        lvStatistic.setAdapter(adapterDisplayStatistic);
        adapterDisplayStatistic.notifyDataSetChanged();

        lvStatistic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                madon = orderDTOS.get(position).getOrderID();
                manv = orderDTOS.get(position).getEmployeeID();
                maban = orderDTOS.get(position).getTableID();
                ngaydat = orderDTOS.get(position).getDate();
                tongtien = orderDTOS.get(position).getTotalAmount();

                Intent intent = new Intent(getActivity(), DetailStatisticActivity.class);
                intent.putExtra("madon",madon);
                intent.putExtra("manv",manv);
                intent.putExtra("maban",maban);
                intent.putExtra("ngaydat",ngaydat);
                intent.putExtra("tongtien",tongtien);
                startActivity(intent);
            }
        });

        return view;
    }
}
