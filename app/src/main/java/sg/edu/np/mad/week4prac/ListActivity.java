package sg.edu.np.mad.week4prac;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.ArrayList;
import java.util.Random;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.DefaultItemAnimator;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<User> myUser_List = new ArrayList<>();
        for (int i=0; i<20; i++){
            int name = new Random().nextInt(999999999);
            int description = new Random().nextInt(999999999);
            boolean followed = new Random().nextBoolean();

            User user = new User("John Doe","MAD Developer", 1, false);
            user.setName("Name" + String.valueOf(name));
            user.setDescription("Description"+String.valueOf(description));
            user.setFollowed(followed);
            myUser_List.add(user);

        }

        UserAdapter userAdapter = new UserAdapter(myUser_List, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);




        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setCancelable(false);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){

            }
        });




    }
}