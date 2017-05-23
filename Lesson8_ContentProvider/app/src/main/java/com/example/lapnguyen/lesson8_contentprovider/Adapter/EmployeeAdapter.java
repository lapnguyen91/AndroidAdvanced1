package com.example.lapnguyen.lesson8_contentprovider.Adapter;

import android.content.Context;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lapnguyen.lesson8_contentprovider.DatabaseHelper;
import com.example.lapnguyen.lesson8_contentprovider.Model.Employee;
import com.example.lapnguyen.lesson8_contentprovider.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lapnguyen on 23/05/2017.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>  {
private List<Employee> employeeList = new ArrayList<>();
private LayoutInflater layoutInflater;
        DatabaseHelper db;


        public EmployeeAdapter(List<Employee> employeeList){
                this.employeeList=employeeList;
        }

        public EmployeeAdapter(Context context){
                db = new DatabaseHelper(context);
                employeeList = db.getAllEmployee();
                System.out.println("================= db");
                for (Employee st: employeeList ) {
                        System.out.println(st.toString());
                }
        }

        @Override
        public int getItemCount() {
                return employeeList != null ? employeeList.size() : 0;
        }

        @Override
        public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                if (layoutInflater == null) {
                        layoutInflater = LayoutInflater.from(parent.getContext());
                }
                View v = layoutInflater.inflate(R.layout.item_employee, parent, false);
                return new EmployeeViewHolder(v);
        }

        @Override
        public void onBindViewHolder(EmployeeViewHolder holder, int position) {
                holder.bindData(employeeList.get(position));
        }

    public void updateList(List<Employee> students) {
        this.employeeList = students;
        notifyDataSetChanged();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder  {
        private TextView tvId;
        private TextView tvName;
        private TextView tvDivision;
        public EmployeeViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tv_id);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDivision = (TextView) itemView.findViewById(R.id.tv_division);
        }

        public void bindData(Employee employee){
            if (employee == null) return;
            tvId.setText(""+employee.getId());
            tvName.setText("Name: " + employee.getName());
            tvDivision.setText("Address: " + employee.getDivision());
        }
    }
}
