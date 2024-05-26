package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.example.myapplication.DAO.TableDAO;
import com.example.myapplication.R;

public class AddTableActivity extends AppCompatActivity {

    TextInputLayout TXTL_addtable_tenban;
    Button BTN_addtable_TaoBan;
    TableDAO tableDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtable_layout);

        //region Lấy đối tượng trong view
        TXTL_addtable_tenban = (TextInputLayout)findViewById(R.id.txtl_addtable_tenban);
        BTN_addtable_TaoBan = (Button)findViewById(R.id.btn_addtable_TaoBan);

        tableDAO = new TableDAO(this);
        BTN_addtable_TaoBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTenBanAn = TXTL_addtable_tenban.getEditText().getText().toString();
                if(sTenBanAn != null || sTenBanAn.equals("")){
                    boolean ktra = tableDAO.addTable(sTenBanAn);
                    //trả về result cho displaytable
                    Intent intent = new Intent();
                    intent.putExtra("ketquathem",ktra);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    //validate dữ liệu
    private boolean validateName(){
        String val = TXTL_addtable_tenban.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            TXTL_addtable_tenban.setError(getResources().getString(R.string.not_empty));
            return false;
        }else {
            TXTL_addtable_tenban.setError(null);
            TXTL_addtable_tenban.setErrorEnabled(false);
            return true;
        }
    }
}