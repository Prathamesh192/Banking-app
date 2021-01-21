package com.example.tsf_bank;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbSupport extends SQLiteOpenHelper {
    private static final String TAG = "DbSupport";
    private static final String Table_Name = "Details";
    private static final String Col1 = "Id";
    private static final String Col2 = "Name";
    private static final String Col3 = "Emailid";
    private static final String Col4 = "CurrentBal";
    private static final String Col5 = "AccountNumber";
    SQLiteDatabase db =this.getWritableDatabase();

    public DbSupport(@Nullable Context context) {
        super(context,Table_Name,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ Table_Name +
                "  (" + Col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Col2 + " TEXT, " +
                Col3 + " TEXT, " +
                Col4 + " TEXT, " +
                Col5 + " INTEGER);";
                db.execSQL(query);

    }
    public void AddMem(MemberImport memberImport){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DbSupport.Col2,memberImport.getName());
        contentValues.put(DbSupport.Col3,memberImport.getEmail());
        contentValues.put(DbSupport.Col4,memberImport.getCurrentbal());
        contentValues.put(DbSupport.Col5,memberImport.getAccountNo());

        db.insert(DbSupport.Table_Name,null,contentValues);
        db.close();


    }

    public List<MemberImport> getMember(){
        String sql = "select * from " + Table_Name ;
        db = this.getReadableDatabase();
        List<MemberImport> stormem = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String curruentbal = cursor.getString(3);
                String accountno = cursor.getString(4);
                stormem.add(new MemberImport(id,name,email,curruentbal,accountno));

            }while (cursor.moveToNext());

        }cursor.close();
        return stormem;



    }


    public int updatemem(MemberImport memberImport){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col2,memberImport.getName());
        contentValues.put(Col3,memberImport.getEmail());
        contentValues.put(Col4,memberImport.getCurrentbal());
        contentValues.put(Col5,memberImport.getAccountNo());

        return db.update(Table_Name,contentValues,Col1+"=?",new String[]{String.valueOf(memberImport.getName()),});
    }
    public Boolean Delmem(String name){
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + Table_Name +" where name = ?",new String[]{name});
        if (cursor.getCount() > 0 ){
            long result = db.delete(Table_Name,"name=?",new String[]{name});
            if (result == -1){
                return false;
            } else {
                return true;

        }
    }else{
        return false;
        }
    }
    public void updateam(String name,Integer amount){
        ContentValues cv = new ContentValues();
        cv.put(Col4,amount);

        db.update(Table_Name,cv,"name =?",new String[]{name});
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name+"; ");
        onCreate(db);

    }
}
