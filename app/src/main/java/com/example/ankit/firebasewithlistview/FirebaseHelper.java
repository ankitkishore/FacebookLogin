package com.example.ankit.firebasewithlistview;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;


public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
    ArrayList<Vocabulary> vocabulary=new ArrayList<>();
    /*
 PASS DATABASE REFRENCE
  */
    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
    //WRITE IF NOT NULL
    public Boolean save(Vocabulary Vocabulary)
    {
        if(Vocabulary==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Vocabulary").push().setValue(Vocabulary);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        vocabulary.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Vocabulary Vocabulary=ds.getValue(Vocabulary.class);
            vocabulary.add(Vocabulary);
        }
    }
    //RETRIEVE
    public ArrayList<Vocabulary> retrieve()
    {
        Query q = db.orderByChild("word");
        q.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return vocabulary;
    }
}