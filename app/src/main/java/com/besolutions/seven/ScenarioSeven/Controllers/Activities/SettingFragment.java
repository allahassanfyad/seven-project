package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.NetworkLayer.NetworkInterface;
import com.besolutions.seven.NetworkLayer.ResponseModel;
import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.Post;
import com.besolutions.seven.ScenarioSeven.Models.User;
import com.besolutions.seven.Utils.MyUtilFile;
import com.besolutions.seven.Utils.TinyDB;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SettingFragment extends Fragment implements NetworkInterface
{

    private View view;
    Post[] post ;

    final int PICK_IMAGE_REQUEST_CAMERA = 71;

    final int PICK_IMAGE_REQUEST_GALLERY = 72;


    EditText settingname,settingphone,settingimg,settingpass,settingcity;
    TextView textname, textbalance;
    String idnumber, name, phone,img, pass, city;
    String name1 ,phone1, img1, pass1, city1, email,balance;
    TinyDB tinyDB;
    Button btnedit;
    User[] userModel;

    ImageView userimage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.setting_fragment, container, false);
        tinyDB = new TinyDB(getContext());

        settingname = view.findViewById(R.id.editTextSettingname);
        settingphone = view.findViewById(R.id.editTextSettingphone);
        settingimg = view.findViewById(R.id.editTextSettingImg);
        settingpass = view.findViewById(R.id.editTextSettingPass);
        settingcity = view.findViewById(R.id.editTextSettingcity);
        btnedit = view.findViewById(R.id.btnSettingEdit);
        textname = view.findViewById(R.id.textSettingName);
        userimage = view.findViewById(R.id.profilePhoto);
        textbalance = view.findViewById(R.id.textAmount);

        name1 = tinyDB.getString("username");
        phone1 = tinyDB.getString("phone");
        img1 = tinyDB.getString("img");
        pass1 = tinyDB.getString("password");
        city1 = tinyDB.getString("city");
        email = tinyDB.getString("email");
        balance = tinyDB.getString("balance");



        settingname.setText(name1);
        settingphone.setText(phone1);
        settingpass.setText(pass1);
        settingcity.setText(city1);
        textname.setText(name1);
        textbalance.setText(balance);
        idnumber = tinyDB.getString("id");

            Glide.with(this).load(tinyDB.getString("img")).into(userimage);
            tinyDB.getString("img");


            settingimg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                showPicturDialog();
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name = settingname.getText().toString();
                phone = settingphone.getText().toString();
                img = settingimg.getText().toString();
                pass = settingpass.getText().toString();
                city = settingcity.getText().toString();


                new Apicalls(getContext(),SettingFragment.this).editProfile(idnumber,city1,pass1,img1,phone1,name1);

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model)
    {
            new MyUtilFile(getContext()).showMessage("تم تحديث الملف الشخصي بنجاح");
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public  void  showPicturDialog()
    {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getContext());
        pictureDialog.setTitle("قم بألختيار");
        String[] pictureDlialogItem={"اختر من المعرض" ,
                "قم بألتقاط صورة"};
        pictureDialog.setItems(pictureDlialogItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0 :
                        choosePhotoFromGallary();
                        break;
                    case 1:
                        takePhotoFromCamera();
                        break;
                }
            }
        });
        pictureDialog.show();
    }
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent,PICK_IMAGE_REQUEST_GALLERY);
    }

    private void takePhotoFromCamera() {

        //From Camera
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE
        );
        if(pictureIntent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null) {
            startActivityForResult(pictureIntent, PICK_IMAGE_REQUEST_CAMERA);
        }

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    @Override
    public void OnError(VolleyError error)
    {

        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();


    }
}
