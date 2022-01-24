package com.example.bookapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static android.provider.Telephony.Mms.Addr.CONTACT_ID;

public class MyContentProvider extends ContentProvider {

    static final String TABLE_NAME = "Books";
    static final String URI_AUTHORITY = "com.example.bookapp.MyContentProvider";
    static final String URL = "content://" + URI_AUTHORITY  + "/"+ TABLE_NAME;
    static final Uri CONTENT_URI = Uri.parse(URL);
    private static final int Books = 101;
    private static final int Book_ID = 201;
    private static final int Book_NAME = 301;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(URI_AUTHORITY,"/"+TABLE_NAME, Books );
        uriMatcher.addURI(URI_AUTHORITY,"/"+TABLE_NAME+"/#", Book_ID );
        uriMatcher.addURI(URI_AUTHORITY,"/"+TABLE_NAME+"/*",  Book_NAME );
    }

     DataBaseHandler sqlhelper;

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor;
        switch (uriMatcher.match(uri)) {
            case Books:
                sqlhelper = new DataBaseHandler(getContext());
                SQLiteDatabase sqldb = sqlhelper.getWritableDatabase();
                cursor = sqldb.query(sqlhelper.TABLE_NAME, null, null, null, null, null, null);
                return cursor;
            case Book_ID:
                Toast.makeText(getContext(), " Book-ID", Toast.LENGTH_LONG).show();
                return null;
            case Book_NAME:
                Toast.makeText(getContext(), " Book-Name", Toast.LENGTH_LONG).show();
                return null;
            default:
                Toast.makeText(getContext(), " Default ", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        sqlhelper= new DataBaseHandler(getContext());
        SQLiteDatabase  sqldb = sqlhelper.getWritableDatabase();
        sqldb.insert(sqlhelper.TABLE_NAME, null, values );
        sqldb.close();
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
