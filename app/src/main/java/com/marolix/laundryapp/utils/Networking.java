package com.marolix.laundryapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class Networking {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
           NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null) {
                for (NetworkInfo state : networkInfo) {
                    if (state.getState() == State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/*public static class SelectDropDateFragment extends DialogFragment implements OnDateSetListener {
        @NonNull
        public Dialog onCreateDialog(Bundle bundle) {
            long time;
            Calendar cal = Calendar.getInstance();
            int i = cal.get(1);
            int i2 = cal.get(2);
            int i3 = cal.get(5);
            try {
                time = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).parse(HomeFragment.mPickupDateTV.getText().toString()).getTime() + 259200000;
            } catch (Exception bundle2) {
                bundle2.printStackTrace();
                time = 0;
            }
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, i, i2, i3);
            datePickerDialog.getDatePicker().setMinDate(time);
            return datePickerDialog;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            populateSetDate(i, i2 + 1, i3);
        }

        public void populateSetDate(int i, int i2, int i3) {
            String str = "";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("-");
            stringBuilder.append(i2);
            stringBuilder.append("-");
            stringBuilder.append(i3);
            String i = stringBuilder.toString();
            i2 = new SimpleDateFormat("yy-MM-dd", Locale.getDefault());
            try {
                i = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(i2.parse(i));
            } catch (int i4) {
                i4.printStackTrace();
                i4 = str;
            }
            HomeFragment.dropDate = i4;
            HomeFragment.mDropDateTV.setText(i4);
            Singleton.getInstance().setDropDate(i4);
        }
    }

    public static class SelectPickupDateFragment extends DialogFragment implements OnDateSetListener {
        @NonNull
        public Dialog onCreateDialog(Bundle bundle) {
            bundle = Calendar.getInstance();
            int i = bundle.get(1);
            int i2 = bundle.get(2);
            int i3 = bundle.get(5);
            long time = bundle.getTime().getTime();
            Bundle datePickerDialog = new DatePickerDialog(getActivity(), this, i, i2, i3);
            datePickerDialog.getDatePicker().setMinDate(time);
            return datePickerDialog;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            populateSetDate(i, i2 + 1, i3);
        }

        public void populateSetDate(int i, int i2, int i3) {
            long time;
            long j;
            String str = "";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("-");
            stringBuilder.append(i2);
            stringBuilder.append("-");
            stringBuilder.append(i3);
            i = stringBuilder.toString();
            i2 = new SimpleDateFormat("yy-MM-dd", Locale.getDefault());
            i3 = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            try {
                i = i3.format(i2.parse(i));
            } catch (int i4) {
                i4.printStackTrace();
                i4 = str;
            }
            HomeFragment.pickupDate = i4;
            HomeFragment.mPickupDateTV.setText(i4);
            Singleton.getInstance().setPickUpDate(i4);
            i2 = HomeFragment.mDropDateTV.getText().toString();
            try {
                i4 = i3.parse(i4);
                i2 = i3.parse(i2);
                time = i4.getTime();
                try {
                    i4 = i2.getTime();
                } catch (ParseException e) {
                    i4 = e;
                    i4.printStackTrace();
                    i4 = 0;
                    j = time + 259200000;
                    if (j <= i4) {
                        i4 = Calendar.getInstance();
                        i4.setTimeInMillis(j);
                        HomeFragment.mDropDateTV.setText(i3.format(i4.getTime()));
                        Singleton.getInstance().setDropDate(i3.format(i4.getTime()));
                    }
                }
            } catch (ParseException e2) {
                i4 = e2;
                time = 0;
                i4.printStackTrace();
                i4 = 0;
                j = time + 259200000;
                if (j <= i4) {
                    i4 = Calendar.getInstance();
                    i4.setTimeInMillis(j);
                    HomeFragment.mDropDateTV.setText(i3.format(i4.getTime()));
                    Singleton.getInstance().setDropDate(i3.format(i4.getTime()));
                }
            }
            j = time + 259200000;
            if (j <= i4) {
                i4 = Calendar.getInstance();
                i4.setTimeInMillis(j);
                HomeFragment.mDropDateTV.setText(i3.format(i4.getTime()));
                Singleton.getInstance().setDropDate(i3.format(i4.getTime()));
            }
        }
    }*/