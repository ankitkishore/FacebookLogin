package com.example.ankit.firebasewithlistview;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    /*MyDBHandler dbHandler;*/
    EditText nameeditText,urleditText;
    Button btnsave,delete,b1;
    DatabaseReference db;
    FirebaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*dbHandler = new MyDBHandler(this, null, null, 1);

*/
        // get the listview
        expListView = findViewById(R.id.lvExp);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                LoginManager.getInstance().logOut();

            }
        });

        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);



      /*  for(Vocabulary voc : helper.retrieve())
        {
            dbHandler.addWord(voc);
        }
*/
        listAdapter = new ExpandableListAdapter(this, helper.retrieve());
        expListView.setAdapter(listAdapter);


        // Listview Group click listener
       /* expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplication(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplication(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
       */
       FloatingActionButton fab =  findViewById(R.id.fab);
       fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();
            }
        });
    }

  private void displayDialog()
    {
        Dialog d= new Dialog(this);
        d.setTitle("SaveData");
        d.setContentView(R.layout.customdialog_layout);
        nameeditText= d.findViewById(R.id.nameEditText);
        urleditText= d.findViewById(R.id.urlEditText);
        btnsave= d.findViewById(R.id.saveBtn);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String word = nameeditText.getText().toString();
                String meaning = urleditText.getText().toString();
                nameeditText.setText("");
                urleditText.setText("");

                Vocabulary s = new Vocabulary();
                s.setWord(word);
                s.setMeaning(meaning);
                /*dbHandler.addWord(s);*/
                //SIMPLE VALIDATION
                if (word!= null && word.length() > 0 && meaning!= null && meaning.length() > 0) {
                    //THEN SAVE
                    if (helper.save(s)) {
                        //IF SAVED CLEAR EDITXT
                        /*addButtonClicked(word, meaning);
                        */
                        nameeditText.setText("");
                        urleditText.setText("");
                        listAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }

            }
            }
        });

        d.show();
        }

  /*  public void addButtonClicked(String word, String meaning){
        Vocabulary vocabulary = new Vocabulary(word, meaning);
        dbHandler.addWord(vocabulary);
    }*/

 /*   //Delete items
    public void deleteButtonClicked(View view){
        String inputText = buckysInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        buckysText.setText(dbString);
        buckysInput.setText("");
    }
*/
/*

    private void prepareListData() {

        listAdapter = new ExpandableListAdapter(this, dbHandler.databaseToList());
        expListView.setAdapter(listAdapter);
    }
*/


}
