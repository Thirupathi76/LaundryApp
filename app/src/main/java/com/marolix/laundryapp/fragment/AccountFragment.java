package com.marolix.laundryapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.marolix.laundryapp.R;
import com.marolix.laundryapp.utils.Singleton;

import org.json.JSONException;
import org.json.JSONObject;

public class AccountFragment extends Fragment implements OnClickListener {
    private RelativeLayout mAccountAboutUsLL;
    private RelativeLayout mAccountCouponCodesLL;
    private TextView mAccountEditTV;
    private RelativeLayout mAccountFaqLL;
    private RelativeLayout mAccountHelpLL;
    private RelativeLayout mAccountManageAddressLL;
    private TextView mAccountNameTV;
    private ImageView mAccountProfileIV;
    private RelativeLayout mAccountShareLL;
    private RelativeLayout mAccountSignOutLL;
    private String userName = "";
    private String userNumber = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View layoutInflater = inflater.inflate(R.layout.fragment_account, viewGroup, false);
        mAccountManageAddressLL = layoutInflater.findViewById(R.id.account_manage_address_linear_layout);
        mAccountCouponCodesLL = layoutInflater.findViewById(R.id.account_coupon_codes_linear_layout);
        mAccountShareLL = layoutInflater.findViewById(R.id.account_share_linear_layout);
        mAccountHelpLL = layoutInflater.findViewById(R.id.account_help_linear_layout);
        mAccountAboutUsLL = layoutInflater.findViewById(R.id.account_about_us_linear_layout);
        mAccountFaqLL = layoutInflater.findViewById(R.id.account_faq_linear_layout);
        mAccountSignOutLL = layoutInflater.findViewById(R.id.account_sign_out_linear_layout);
        mAccountNameTV = layoutInflater.findViewById(R.id.account_name_textView);
        mAccountEditTV = layoutInflater.findViewById(R.id.account_edit_textView);
        mAccountProfileIV = layoutInflater.findViewById(R.id.account_profile_imageView);
        mAccountManageAddressLL.setOnClickListener(this);
        mAccountCouponCodesLL.setOnClickListener(this);
        mAccountShareLL.setOnClickListener(this);
        mAccountHelpLL.setOnClickListener(this);
        mAccountAboutUsLL.setOnClickListener(this);
        mAccountFaqLL.setOnClickListener(this);
        mAccountSignOutLL.setOnClickListener(this);
        mAccountEditTV.setOnClickListener(this);
        return layoutInflater;
    }

    private void setUser() {
        this.userNumber = Singleton.getInstance().getPreference().getUserPhone(getActivity());
        try {
            JSONObject jSONObject = new JSONObject(Singleton.getInstance().getPreference().getUserDetails(getActivity()));
            if (jSONObject.isNull("fullName")) {
                this.userName = "";
            } else {
                this.userName = jSONObject.getString("fullName");
            }
            if (!(jSONObject.isNull("imageURL") || jSONObject.getString("imageURL").equals(""))) {
                /*Picasso picasso = Picasso.get();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Urls.mainUrl);
                stringBuilder.append(jSONObject.getString("imageURL"));
                picasso.load(stringBuilder.toString()).fit().memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).into(this.mAccountProfileIV);
*/
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.userName.equals("")) {
            this.mAccountNameTV.setText(this.userNumber);
        } else {
            this.mAccountNameTV.setText(this.userName);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.account_about_us_linear_layout:
//                startActivity(new Intent(getActivity(), AboutUsActivity.class));
                return;
            case R.id.account_coupon_codes_linear_layout:
//                startActivity(new Intent(getActivity(), CouponsActivity.class));
                return;
            case R.id.account_edit_textView:
                /*Intent edit = new Intent(getActivity(), EditAccountActivity.class);
                edit.putExtra("FROM_ACTIVITY", "ACCOUNT");
                startActivity(edit);*/
                return;
            case R.id.account_faq_linear_layout:
//                startActivity(new Intent(getActivity(), FAQActivity.class));
                return;
            case R.id.account_help_linear_layout:

                Intent intent1 = new Intent("android.intent.action.SEND");
                intent1.setType("message/rfc822");
                intent1.putExtra("android.intent.extra.EMAIL", "projects.marolix@gmail.com");
                intent1.putExtra("android.intent.extra.SUBJECT", "Laundry kart");
                intent1.putExtra("android.intent.extra.TEXT", "");
                startActivity(Intent.createChooser(intent1, "Select Email Sending App :"));
                return;
            case R.id.account_manage_address_linear_layout:
                /*intent1 = new Intent(getContext(), ManageAddressActivity.class);
                intent1.putExtra("FROM_SCREEN", "Account");
                startActivity(intent1);*/
                return;
            case R.id.account_share_linear_layout:
                StringBuilder intent2 = new StringBuilder();
                intent2.append("http://play.google.com/store/apps/details?id=");
                intent2.append(getActivity().getPackageName());
               String str = intent2.toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", "Laundry app");
                intent.putExtra("android.intent.extra.TEXT", str);
                startActivity(Intent.createChooser(intent, "Share via"));
                return;
            case R.id.account_sign_out_linear_layout:
                Singleton.getInstance().getPreference().saveUserPhone(getActivity(), "");
                Singleton.getInstance().getPreference().saveUserId(getActivity(), "");
                Singleton.getInstance().getPreference().saveUserDetails(getActivity(), "");
                Singleton.getInstance().getPreference().saveAddress(getActivity(), "");
                Singleton.getInstance().getPreference().savePickupAddress(getActivity(), "");
                Singleton.getInstance().getPreference().saveDropAddress(getActivity(), "");
                Singleton.getInstance().getPreference().savePickupAddressID(getActivity(), "");
                Singleton.getInstance().getPreference().saveDropAddressId(getActivity(), "");
                Singleton.getInstance().getPreference().saveLoginState(getActivity(), false);
                Singleton.getInstance().productsAddedModelHashMap.clear();
                /*Intent in = new Intent(getActivity(), LoginActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);*/
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    public void onResume() {
        super.onResume();
        setUser();
    }
}
