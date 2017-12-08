package cn.colafans.hellotest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.widget.Button;

import cn.colafans.hellotest.R;

public class IntentActivity extends Activity implements View.OnClickListener {

    private static final int GET_CONTACTS = 100;
    private Button btnSelectContact, btnSelectContact2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        btnSelectContact = (Button) findViewById(R.id.btn_select_contact);
        btnSelectContact.setOnClickListener(this);
        btnSelectContact2 = (Button) findViewById(R.id.btn_select_contact2);
        btnSelectContact2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select_contact:
                startContacts();
                break;
            case R.id.btn_select_contact2:
                getContacts();
                break;
        }
    }

    private void startContacts() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType(Phone.CONTENT_TYPE);
        startActivityForResult(intent, GET_CONTACTS);
    }

    private void getContacts() {
        Intent mContactListIntent = new Intent(Intent.ACTION_GET_CONTENT);
        mContactListIntent.setType(Phone.CONTENT_ITEM_TYPE);
        startActivityForResult(mContactListIntent, GET_CONTACTS);
    }
}
